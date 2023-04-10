package university_mocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static university_mocks.PersonVerificationUtils.faker;
import static university_mocks.PersonVerificationUtils.finalListOfRandomPersons;

public class EmployeeVerificationUtils {
    public static void main(String[] args){
        /**     Jak drukuję listę Employees to nie mam pól z klasy Person.
         *      Jak wywołam je tak jak poniżej, to są.... Jak zrobić, żeby zwracane były wszystkie pola - także te dziedziczone po Person??   */
        System.out.println(buildListOfFakeEmployees());
        Employee employee = buildListOfFakeEmployees().get(0);
        System.out.println("firstName: " + employee.getFirstName() + ", lastName: " +       employee.getLastName() + ", address: " + employee.getAddress());
    }

    /**   Jak zrobić, żeby pola finalne były rzeczywiście finalne?? Singleton zwraca instancję klasy, więc nie o to chodzi.../       */
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
            listOfEmployees.add(employee);
        }
        return listOfEmployees;
    }
}
