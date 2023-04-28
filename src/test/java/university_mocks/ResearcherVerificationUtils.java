package university_mocks;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static university_mocks.EmployeeVerificationUtils.getInstance;
import static university_mocks.PersonVerificationUtils.faker;

public class ResearcherVerificationUtils {
    @Getter
    private final EmployeeVerificationUtils employeeVerificationUtils = getInstance();

    public List<Researcher> buildListOfFakeResearchers() {
        List<Employee> listOfEmployees = employeeVerificationUtils.getFinalListOfEmployees();
        List<Researcher> listOfResearchers = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            Researcher researcher = new Researcher();
            researcher.setFirstName(employee.getFirstName());
            researcher.setLastName(employee.getLastName());
            researcher.setAddress(employee.getAddress());
            researcher.setDegree("PhD");
            researcher.setSubjectsTaught(makeListOfFakeSubjectsTaught());
            researcher.setSalary(faker.number().numberBetween(3000, 25000));
            researcher.setJobPosition(JobPosition.RESEARCHER);
            researcher.setDateOfEmployment(LocalDate.now());
            researcher.setEmployed(true);
            listOfResearchers.add(researcher);
        }
        return listOfResearchers;
    }

    private List<String> makeListOfFakeSubjectsTaught() {
        List<String> subjectsTaught = new ArrayList<>();
        subjectsTaught.add("Math");
        for (int i = 0; i < 4; i++) {
            subjectsTaught.add(faker.educator().course());
        }
        return subjectsTaught;
    }
}
