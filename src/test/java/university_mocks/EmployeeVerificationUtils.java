package university_mocks;

import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static university_mocks.PersonVerificationUtils.faker;
import static university_mocks.PersonVerificationUtils.finalListOfRandomPersons;

public class EmployeeVerificationUtils {
    private static EmployeeVerificationUtils instance = null;

    private EmployeeVerificationUtils(List<Employee> employees) {
        if (instance != null) {
            throw new RuntimeException("Not allowed. Please use getInstance() method");
        }
        this.finalListOfEmployees = employees;
    }

    public static EmployeeVerificationUtils getInstance() {
        if (instance == null) {
            instance = new EmployeeVerificationUtils(buildListOfFakeEmployees());
        }
        return instance;
    }

    @Getter
    private final List<Employee> finalListOfEmployees;
    private final Integer a = 5;

    private static List<Employee> buildListOfFakeEmployees() {
        List<Person> listOfRandomPersons = new ArrayList<>(finalListOfRandomPersons);
        List<Employee> listOfEmployees = new ArrayList<>();

        Employee myEmployee = Employee.builder()
                .firstName("Andrzej")
                .lastName("Sienkiewicz")
                .address("Kraków")
                .salary(5200)
                .jobPosition(JobPosition.OTHER)
                .dateOfEmployment(LocalDate.now())
                .isEmployed(true)
                .build();
        listOfEmployees.add(myEmployee);

        for (Person person : listOfRandomPersons) {
            Employee employee = Employee.builder()
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .address(person.getAddress())
                    .salary(faker.number().numberBetween(3500, 17000))
                    .jobPosition(JobPosition.RESEARCHER)
                    .dateOfEmployment(LocalDate.now())
                    .isEmployed(true)
                    .build();
            listOfEmployees.add(employee);
        }
        return listOfEmployees;
    }
}
