package university_mocks;

import java.util.ArrayList;
import java.util.List;

import static university_mocks.PersonVerificationUtils.faker;


public class ResearcherVerificationUtils {
    public static final List<Researcher> finalListOfResearcher =  buildListOfFakeEResearchers();

    public static List<Researcher> buildListOfFakeEResearchers() {
        List<Employee> listOfEmployees = EmployeeVerificationUtils.buildListOfFakeEmployees();
        List<Researcher> listOfResearchers = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            Researcher researcher = new Researcher();
            researcher.setFirstName(employee.getFirstName());
            researcher.setLastName(employee.getLastName());
            researcher.setAddress(employee.getAddress());
            researcher.setDegree("PhD");
            researcher.setSubjectsTaught(makeListOfFakeSubjectsTaught());
            listOfResearchers.add(researcher);
        }
        return listOfResearchers;
    }

    private static List<String> makeListOfFakeSubjectsTaught(){
        List<String> subjectsTaught = new ArrayList<>();
        subjectsTaught.add("Math");
        for (int i = 0; i < 4; i++) {
            subjectsTaught.add(faker.educator().course());
        }
        return subjectsTaught;
    }
}
