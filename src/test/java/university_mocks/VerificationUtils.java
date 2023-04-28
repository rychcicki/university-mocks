package university_mocks;

import java.util.ArrayList;
import java.util.List;

import static university_mocks.PersonVerificationUtils.faker;

public class VerificationUtils {
    private final ResearcherVerificationUtils researcherVerificationUtils = new ResearcherVerificationUtils();
    private final List<Researcher> finalListOfResearcher = researcherVerificationUtils.buildListOfFakeResearchers();
    private final List<String> subjects = List.of("Statistics", "Algebra", "Algorithms", "Economics", "Mathematics for Computer Science", "Data Analysis",
            "Programming", "Software Engineering", "Modelling", "Network Technologies");

    public Faculty buildFacultyOfMathematics(String address) {

        String name = "Faculty of Mathematic";
        List<String> studyCourses = List.of("Algebra", "Algorithms", "Mathematics for Computer Science", "Data Analysis");

        List<Researcher> staff = new ArrayList<>(finalListOfResearcher);
        return new Faculty(name, studyCourses, address, staff);
    }

    public List<String> makeListOfTaughtSubjects() {
        List<String> subjectsTaughtList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            subjectsTaughtList.add(faker.educator().course());
        }
        return subjectsTaughtList;
    }
}
