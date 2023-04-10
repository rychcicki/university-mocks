package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static university_mocks.EmployeeVerificationUtils.finalListOfEmployees;

class ResearcherTest {
    private final Researcher researcher1 = ResearcherVerificationUtils.buildListOfFakeEResearchers().get(0);
    private final Researcher researcher2 = ResearcherVerificationUtils.buildListOfFakeEResearchers().get(0);

    @Test
    public void shouldReturnListOfTaughtSubjects() {
        //given
//        Researcher researcher = VerificationUtils.buildListOfResearchers().get(1);
        //when
//        List<String> subjectsTaughtCheck = researcher.listOfTaughtSubjectsVerifier(researcher);
        //then
//        Assertions.assertEquals(List.of("Law"), subjectsTaughtCheck);
    }

    @Test
    public void shouldReturnTrueWhenResearcherIsFired() {
        System.out.println(finalListOfEmployees);
        Subject subject = buildSubjects();
        List<Researcher> staff = new ArrayList<>();
        staff.add(researcher1);
        staff.add(researcher2);
        //when - act
        boolean checkSubjects = researcher1.checkResearcherMayBeFired(researcher1, subject);
        List<Researcher> listOfResearchers = researcher1.deleteResearcherFromStaffAndSetFalseAsEmployee(researcher1, staff);
        boolean containsDeletedResearcher = listOfResearchers.contains(researcher1);
        boolean employed = researcher1.isEmployed();
        //then - assert
        Assertions.assertAll(() -> Assertions.assertTrue(checkSubjects), () -> Assertions.assertFalse(containsDeletedResearcher));
    }

    @Test
    public void shouldCheckWhenResearcherReplacesAnother() {
        //given
//        Researcher researcher = VerificationUtils.buildListOfResearchers().get(0);
        Subject subject = buildSubjects();
        //when
        Researcher anotherResearcher = researcher1.replaceResearcherByAnotherResearcher(researcher1, subject);
        //then
        Assertions.assertNotNull(anotherResearcher);
    }

    @Test
    public void shouldReturnFalseIfResearcherWasDeletedFromFaculty() {
        //given
//        Employee employee = VerificationUtils.buildEmployee("Andrzej", "Tomaszewski", "Warszawa", 10000, JobPosition.RESEARCHER);
        Employee employee = finalListOfEmployees.get(0);
//        List<String> subjectsForResearcher = new ArrayList<>();
//        subjectsForResearcher.add("Statistics");
//        subjectsForResearcher.add("Algebra");
//        Researcher researcher = buildResearcherFromEmployee(employee, subjectsForResearcher);
        Faculty faculty = VerificationUtils.buildFacultyOfMathematics("Warszawa");
        List<Researcher> staff = faculty.getStaff();
        //when
        List<Researcher> researchers = researcher1.deleteResearcherFromFaculty(researcher1, faculty);
        //then
        Assertions.assertEquals(staff, researchers);
    }

    private Subject buildSubjects() {
        List<Researcher> researchersWhoTeachTheSubjects = new ArrayList<>();
        researchersWhoTeachTheSubjects.add(researcher1);
        researchersWhoTeachTheSubjects.add(researcher2);
        return new Subject("Algebra", researchersWhoTeachTheSubjects, 5);
    }
}
