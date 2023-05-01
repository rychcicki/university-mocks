package university_mocks;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static university_mocks.EmployeeVerificationUtils.getInstance;
import static university_mocks.PersonVerificationUtils.faker;

public class ResearcherVerificationUtils {
    @Getter
    private final EmployeeVerificationUtils employeeVerificationUtils = getInstance();

    @Builder
    public List<Researcher> buildListOfFakeResearchers() {
        List<Employee> listOfEmployees = employeeVerificationUtils.getFinalListOfEmployees();
        List<Researcher> listOfResearchers = new ArrayList<>();
        for (Employee employee : listOfEmployees) {
            Researcher researcher = Researcher.builder()
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .address(employee.getAddress())
                    .degree("PhD")
                    .subjectsTaught(makeListOfFakeSubjectsTaught())
                    .build();
            Employee employee1 = Employee.builder()
                    .salary(faker.number().numberBetween(3000, 25000))
                    .jobPosition(JobPosition.RESEARCHER)
                    .dateOfEmployment(LocalDate.now())
                    .isEmployed(true)
                    .build();
            researcher.setFirstName(employee.getFirstName());
            researcher.setLastName(employee.getLastName());
            researcher.setAddress(employee.getAddress());
            researcher.setDegree("PhD");
            researcher.setSubjectsTaught(makeListOfFakeSubjectsTaught());
            researcher.setSalary(employee1.getSalary());
            researcher.setJobPosition(employee1.getJobPosition());
            researcher.setDateOfEmployment(employee1.getDateOfEmployment());
            researcher.setEmployed(employee1.isEmployed());
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
