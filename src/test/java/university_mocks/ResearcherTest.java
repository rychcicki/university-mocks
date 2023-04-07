package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResearcherTest {
    @Test
    public void shouldReturnListOfTaughtSubjects() {
        //given
        Researcher researcher = VerificationUtils.buildListOfResearchers().get(1);
        //when
//        List<String> subjectsTaughtCheck = researcher.listOfTaughtSubjectsVerifier(researcher);
        //then
//        Assertions.assertEquals(List.of("Law"), subjectsTaughtCheck);
    }

    @Test
    public void shouldReturnTrueWhenResearcherIsFired() {
        //given - arrange
        Researcher researcher1 = VerificationUtils.buildListOfResearchers().get(0);
        Researcher researcher2 = VerificationUtils.buildListOfResearchers().get(1);
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
        Researcher researcher = VerificationUtils.buildListOfResearchers().get(0);
        Subject subject = buildSubjects();
        //when
        Researcher anotherResearcher = researcher.replaceResearcherByAnotherResearcher(researcher, subject);
        //then
        Assertions.assertNotNull(anotherResearcher);
    }

    @Test
    public void shouldReturnFalseIfResearcherWasDeletedFromFaculty() {
        //given
        Employee employee = VerificationUtils.buildEmployee("Andrzej", "Tomaszewski", "Warszawa", 10000, JobPosition.RESEARCHER);
        List<String> subjectsForResearcher = new ArrayList<>();
        subjectsForResearcher.add("Statistics");
        subjectsForResearcher.add("Algebra");
        Researcher researcher = buildResearcherFromEmployee(employee, subjectsForResearcher);
        Faculty faculty = VerificationUtils.buildFacultyOfMathematics("Warszawa");
        List<Researcher> staff = faculty.getStaff();
        //when
        List<Researcher> researchers = researcher.deleteResearcherFromFaculty(researcher, faculty);
        //then
        Assertions.assertEquals(staff, researchers);
    }

    //  VerificationUtils class in tests
//    private Researcher buildResearcher(List<String> subjectsTaught) {
//        subjectsTaught.add("statistics");
//        subjectsTaught.add("algebra");
//        Employee employee = VerificationUtils.buildEmployee("Adam", "Miauczek", "Warszawa", 777, JobPosition.RESEARCHER);
//        return new Researcher(employee.getFirstName(),employee.getLastName(),employee.getAddress(),"PhD",subjectsTaught);
//    }

//    List<String> subjects = List.of("Statistics", "Algebra", "Algorithms", "Economics", "Mathematics for Computer Science", "Data Analysis",
//            "Programming", "Software Engineering", "Modelling", "Network Technologies");

    private Researcher buildResearcherFromEmployee(Employee employee, List<String> subjectsTaught) {
        return new Researcher(employee.getFirstName(), employee.getLastName(), employee.getAddress(), "PhD", subjectsTaught);
    }

//    private Researcher buildResearcherFromEmployee(Employee employee, List<String> subjectsTaught) {
//        subjectsTaught.add("statistics");
//        subjectsTaught.add("algebra");
//        subjectsTaught.add("hydrology");
//        return new Researcher(employee.getFirstName(),employee.getLastName(),employee.getAddress(),"PhD",subjectsTaught);
//    }

    private Subject buildSubjects() {
        List<Researcher> researchersWhoTeachTheSubjects = new ArrayList<>();
        researchersWhoTeachTheSubjects.add(VerificationUtils.buildListOfResearchers().get(0));
        researchersWhoTeachTheSubjects.add(VerificationUtils.buildListOfResearchers().get(1));
        return new Subject("Algebra", researchersWhoTeachTheSubjects, 5);
    }
}
