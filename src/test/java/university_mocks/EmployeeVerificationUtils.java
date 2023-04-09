package university_mocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static university_mocks.PersonVerificationUtils.faker;
import static university_mocks.PersonVerificationUtils.finalListOfRandomPersons;

public class EmployeeVerificationUtils {
    public static final List<Employee> finalListOfEmployees = buildListOfFakeEmployees();

    public static List<Employee> buildListOfFakeEmployees() {
        List<Person> listOfRandomPersons = new ArrayList<>(finalListOfRandomPersons);
        List<Employee> listOfEmployees = new ArrayList<>();

        Employee myEmployee = new Employee();
        myEmployee.setFirstName("Andrzej");
        myEmployee.setLastName("Sienkiewicz");
        myEmployee.setAddress("Kraków");
        myEmployee.setSalary(5200);
        myEmployee.setJobPosition(JobPosition.OTHER);
        myEmployee.setDateOfEmployment(LocalDate.now());
        myEmployee.setEmployed(true);
        listOfEmployees.add(myEmployee);

        for (Person person : listOfRandomPersons) {
            Employee employee = new Employee();
            employee.setFirstName(person.getFirstName());
            employee.setLastName(person.getLastName());
            employee.setAddress(person.getAddress());
            employee.setSalary(faker.number().numberBetween(3500, 17000));
            employee.setJobPosition(JobPosition.RESEARCHER); // jak tutaj zrobić losowo??
            employee.setDateOfEmployment(LocalDate.now());
            employee.setEmployed(true);
        }
        return listOfEmployees;
    }
}
