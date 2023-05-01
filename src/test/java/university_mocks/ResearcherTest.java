package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static university_mocks.PersonVerificationUtils.faker;

class ResearcherTest {
    private final ResearcherVerificationUtils researcherVerificationUtils = new ResearcherVerificationUtils();
    List<Researcher> researchers = researcherVerificationUtils.buildListOfFakeResearchers();
    private final Researcher researcher2 = researchers.get(3);
    private final Researcher researcher1 = researchers.get(1);
    private final SubjectService subjectService = mock(SubjectService.class);
    private final ResearcherService researcherService = mock(ResearcherService.class);
    private final VerificationUtils verificationUtils = new VerificationUtils();

    @Test
    public void shouldReturnTrueWhenResearcherIsFired() {
        Subject subject = buildSubject();
        List<Researcher> staff = new ArrayList<>();
        when(researcherService.findAll()).thenReturn(researcherVerificationUtils.buildListOfFakeResearchers());
        Researcher researcher2 = researcherService.findAll().get(3);
        Researcher researcher1 = researcherService.findAll().get(1);
        staff.add(researcher1);
        staff.add(researcher2);
        //when - act
        boolean checkSubjects = researcher1.checkResearcherMayBeFired(researcher1, subject);
        List<Researcher> listOfResearchers = researcher1.deleteResearcherFromStaffAndSetFalseAsEmployee(researcher1, staff);
        boolean containsDeletedResearcher = listOfResearchers.contains(researcher1);
        boolean employed = researcher1.isEmployed();
        //then - assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(checkSubjects),
                () -> Assertions.assertFalse(containsDeletedResearcher),
                () -> Assertions.assertFalse(employed)
        );
    }

    @Test
    public void shouldReturnTrueWhenResearcherIsFiredWithMockito() {
        when(subjectService.findSubject()).thenReturn(buildSubject());
        Subject subject = subjectService.findSubject();
        when(researcherService.findResearcher())
                .thenReturn(researcherVerificationUtils.buildListOfFakeResearchers().get(3),
                        researcherVerificationUtils.buildListOfFakeResearchers().get(1));
        Researcher researcher2 = researcherService.findResearcher();
        Researcher researcher1 = researcherService.findResearcher();
        List<Researcher> staff = new ArrayList<>();
        staff.add(researcher1);
        staff.add(researcher2);
        //when - act
        /** Sprawdź, bo niezależnie którego Researchera przekażesz, to będzie działać  */
        boolean checkSubjects = researcher1.checkResearcherMayBeFired(researcher1, subject);
        List<Researcher> listOfResearchers = researcher1.deleteResearcherFromStaffAndSetFalseAsEmployee(researcher1, staff);
        boolean containsDeletedResearcher = listOfResearchers.contains(researcher1);
        boolean employed = researcher1.isEmployed();
        //then - assert
        Assertions.assertAll(
                () -> Assertions.assertTrue(checkSubjects),
                () -> Assertions.assertFalse(containsDeletedResearcher),
                () -> Assertions.assertFalse(employed));
    }

    @Test
    public void shouldCheckWhenResearcherReplacesAnother() {
        //given
        Subject subject = buildSubject();
        List<Researcher> researchersWhoTeachTheSubjects = subject.getResearchersWhoTeachTheSubjects();
        /** Zabawa z ArgumentCaptor'em  */
        Researcher mockResearcher = mock(Researcher.class);
        mockResearcher.replaceResearcherByAnotherResearcher(this.researcher1, subject);
        ArgumentCaptor<Researcher> researcherCaptor = ArgumentCaptor.forClass(Researcher.class);
        //when
        verify(mockResearcher).replaceResearcherByAnotherResearcher(researcherCaptor.capture(), eq(subject));
        Researcher anotherResearcher = this.researcher1.replaceResearcherByAnotherResearcher(this.researcher1, subject);
        //then
        Assertions.assertAll(
                () -> Assertions.assertNotNull(anotherResearcher),
                () -> Assertions.assertFalse(researchersWhoTeachTheSubjects.contains(this.researcher1)),
                () -> Assertions.assertEquals(researcherCaptor.getValue(), this.researcher1)
        );
    }

    @Test
    public void shouldReturnFalseIfResearcherWasDeletedFromFaculty() {
        //given
        /**     Tutaj mockuję interfejs i trochę na siłę wykorzystuję dopasowania */
        FacultyService facultyService = mock(FacultyService.class);
        when(facultyService.getFacultyNames(anyString()))
                .thenReturn(verificationUtils.buildFacultyOfMathematics("Java Faculty"));
        Faculty faculty = facultyService.getFacultyNames("Faculty of Mathematics");
        List<Researcher> staff = faculty.getStaff();
        //when
        List<Researcher> researchers = this.researcher1.deleteResearcherFromFaculty(this.researcher1, faculty);
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(staff, researchers),
                () -> Assertions.assertEquals(faculty.getAddress(), "Java Faculty")
        );
    }

    private Subject buildSubject() {
        List<Researcher> researchersWhoTeachTheSubjects = new ArrayList<>();
        researchersWhoTeachTheSubjects.add(this.researcher1);
        researchersWhoTeachTheSubjects.add(this.researcher2);
        return new Subject(faker.educator().course(), researchersWhoTeachTheSubjects, faker.number().numberBetween(1, 10));
    }
}
