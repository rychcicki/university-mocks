package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ResearcherTest {
    @Test
    public void shouldReturnListOfTaughtSubjects() {
        //given
        Researcher researcher = buildResearcher();


        //when
//        List<String> subjectsTaughtCheck = researcher.listOfTaughtSubjectsVerifier(researcher);

        //then
//        Assertions.assertEquals(List.of("Law"), subjectsTaughtCheck);
    }

    @Test
    public void shouldReturnTrueWhenResearcherIsFired() {
        //given - arrange
        Researcher researcher = buildResearcher();
        Subjects subjects = buildSubjects();
        List<Researcher> staff = new ArrayList<>();


        //when - act
        boolean checkSubjects = researcher.checkResearcherMayBeFired(researcher, subjects);
        boolean checkStaffList = researcher.deleteResearcherFromStaff(researcher, staff);


        //then - assert
        Assertions.assertTrue(checkSubjects);
        Assertions.assertTrue(checkStaffList);
//        Assertions.assertAll();
    }

    @Test
    public void shouldCheckWhenResearcherReplacesAnother() {
        //given
        Researcher researcher = buildResearcher();
        Subjects subjects = buildSubjects();

        //when
        Researcher anotherResearcher = researcher.replaceResearcherByAnotherResearcher(researcher, subjects);


        //then
        Assertions.assertNotNull(anotherResearcher);

    }

    //  VerificationUtils class in tests
    private Researcher buildResearcher() {
        List<String> subjectsTaught = new ArrayList<>();
        subjectsTaught.add("statistics");
        subjectsTaught.add("algebra");
        return new Researcher("Phd", subjectsTaught);
    }

    private Subjects buildSubjects() {
        List<Researcher> researchersWhoTeachTheSubjects = new ArrayList<>();
        researchersWhoTeachTheSubjects.add(buildResearcher());
        researchersWhoTeachTheSubjects.add(buildResearcher());
        researchersWhoTeachTheSubjects.add(buildResearcher());
        return new Subjects("statictics", researchersWhoTeachTheSubjects, 5);
    }

}
