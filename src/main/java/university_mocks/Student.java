package university_mocks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person {
    private int indexNumber;
    private String course;
    private int year;
    private int semester;
    private Map<String, Double> subjectsAndGrades;
    private List<String> subjectsForConditionalExam;

    public Student(String firstName, String lastName, String address, int indexNumber, String course, int year, int semester,
                   Map<String, Double> subjectsAndGrades, List<String> subjectsForConditionalExam) {
        super(firstName, lastName, address);
        this.indexNumber = indexNumber;
        this.course = course;
        this.year = year;
        this.semester = semester;
        this.subjectsAndGrades = subjectsAndGrades;
        this.subjectsForConditionalExam = subjectsForConditionalExam;
    }

    public Employee studentToEmployeePromotion(Student student) {
        //similar to buildEmployee() in VerificationUtils class;
        Employee employee = new Employee();
        employee.setFirstName(student.getFirstName());
        employee.setLastName(student.getLastName());
        employee.setAddress(student.getAddress());
        employee.setSalary(3800);
        employee.setJobPosition(JobPosition.PHD_STUDENT);
        employee.setDateOfEmployment(LocalDate.now());
        employee.setEmployed(true);
        return employee;
    }

    public Researcher studentToPhDStudentPromotion(Employee employee, List<String> subjectsTaught) {
        int index = new Random().nextInt(0, subjectsTaught.size());
        return new Researcher(employee.getFirstName(), employee.getLastName(), employee.getAddress(), "MSc", List.of(subjectsTaught.get(index)));
    }

    public List<Student> checkSubjectsForConditionalExam(List<Student> listOfStudents, Student student) {
        int countOfSubjectsForConditionalExam = student.getSubjectsForConditionalExam().size();
        if (countOfSubjectsForConditionalExam > 3) {
            List<Student> newListOfStudents = new ArrayList<>(listOfStudents);
            newListOfStudents.remove(student);
            return newListOfStudents;
        }
        return listOfStudents;
    }
}
