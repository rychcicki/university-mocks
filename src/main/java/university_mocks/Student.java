package university_mocks;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Student extends Person {
    private int indexNumber;
    private String course;
    private int year;
    private int semester;
    private Map<String, Double> subjectsAndGrades;
    private List<String> subjectsForConditionalExam;
    private final int maxCountOfSubjectsForConditionalExam = 3;

    public Employee studentToEmployeePromotion(Student student) {
        return Employee.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .address(student.getAddress())
                .salary(3800)
                .jobPosition(JobPosition.PHD_STUDENT)
                .dateOfEmployment(LocalDate.now())
                .isEmployed(true).build();
    }

    public Researcher studentToPhDStudentPromotion(Employee employee, List<String> subjectsTaught) {
        int index = new Random().nextInt(0, subjectsTaught.size());
        return Researcher.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .address(employee.getAddress())
                .degree("MSc")
                .subjectsTaught(List.of(subjectsTaught.get(index)))
                .build();
    }

    public List<Student> checkSubjectsForConditionalExam(List<Student> listOfStudents, Student student) {
        int countOfSubjectsForConditionalExam = student.getSubjectsForConditionalExam().size();
        if (countOfSubjectsForConditionalExam > maxCountOfSubjectsForConditionalExam) {
            List<Student> studentsWithoutConditionalExam = new ArrayList<>(listOfStudents);
            studentsWithoutConditionalExam.remove(student);
            return studentsWithoutConditionalExam;
        }
        return listOfStudents;
    }
}
