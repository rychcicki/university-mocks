package university_mocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VerificationUtils {
    public static List<Employee> buildListOfEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee("Jan", "Kolwaski", "Warszawa", 5000,
                JobPosition.OTHER, LocalDate.of(1985, 5, 24), true));
        listOfEmployees.add(new Employee("Janusz", "Nowak", "Gdańsk", 3000,
                JobPosition.RESEARCHER, LocalDate.of(1998, 1, 21), true));
        listOfEmployees.add(new Employee("Andrzej", "Sienkiewicz", "Kraków", 4000,
                JobPosition.RESEARCHER, LocalDate.of(1995, 7, 4), true));
        listOfEmployees.add(new Employee("Anna", "Mickiewicz", "Łódź", 8000,
                JobPosition.OTHER, LocalDate.of(2001, 11, 12), true));
        listOfEmployees.add(new Employee("Bolesław", "Bierut", "Warszawa", 7300,
                JobPosition.RESEARCHER, LocalDate.of(2010, 6, 30), true));
        listOfEmployees.add(new Employee("Katarzyna", "Bomba", "Wrocław", 6400,
                JobPosition.PHD_STUDENT, LocalDate.of(2020, 12, 24), true));
        listOfEmployees.add(new Employee("Jan", "Mickiewicz", "Poznań", 5000,
                JobPosition.PHD_STUDENT, LocalDate.of(2015, 2, 7), true));
        listOfEmployees.add(new Employee("Andrzej", "Ptaszkowski", "Katowice", 9100,
                JobPosition.PROFESSOR, LocalDate.of(2003, 8, 19), true));
        listOfEmployees.add(new Employee("Hanna", "Kowalska", "Szczecin", 5000,
                JobPosition.RESEARCHER, LocalDate.of(1999, 5, 30), true));
        listOfEmployees.add(new Employee("Teresa", "Valessa", "Warszawa", 14250,
                JobPosition.PROFESSOR, LocalDate.of(1985, 10, 11), true));
        return listOfEmployees;
    }

    public static Employee buildEmployee(String firstName, String lastName, String address, double salary, JobPosition jobPosition) {
        return new Employee(firstName, lastName, address, salary, jobPosition, LocalDate.now(), true);
    }

    private final List<String> subjects = List.of("Statistics", "Algebra", "Algorithms", "Economics", "Mathematics for Computer Science", "Data Analysis",
            "Programming", "Software Engineering", "Modelling", "Network Technologies");

    public static List<Researcher> buildListOfResearchers() {
        List<String> subjectsTaught1 = new ArrayList<>(List.of("Statistics", "Algebra"));
        List<String> subjectsTaught2 = new ArrayList<>(List.of("Algebra", "Algorithms"));
        List<String> subjectsTaught3 = new ArrayList<>(List.of("Economics", "Data Analysis"));

        List<Employee> employees = buildListOfEmployees();
        Researcher researcher1 = buildResearcherFromEmployee(employees.get(1), subjectsTaught1);
        Researcher researcher2 = buildResearcherFromEmployee(employees.get(2), subjectsTaught2);
        Researcher researcher3 = buildResearcherFromEmployee(employees.get(4), subjectsTaught3);
        return new ArrayList<>(List.of(researcher1, researcher2, researcher3));
    }

    private static Researcher buildResearcherFromEmployee(Employee employee, List<String> subjectsTaught) {
        return new Researcher(employee.getFirstName(), employee.getLastName(), employee.getAddress(), "PhD", subjectsTaught);
    }

    public static List<Researcher> buildListOfResearchersFromEmployees(List<Employee> listOfEmployees, List<String> listOfSubjects) {
        return listOfEmployees.stream()
                .map(employee -> buildResearcherFromEmployee(employee, listOfSubjects))
                .collect(Collectors.toList());
    }

    public static Faculty buildFacultyOfMathematics(String address) {
        String name = "Faculty of Mathematic";
        List<String> studyCourses = List.of("Algebra", "Algorithms", "Mathematics for Computer Science", "Data Analysis");

        List<Researcher> staff = new ArrayList<>(buildListOfResearchers());
        return new Faculty(name, studyCourses, address, staff);
    }
}
