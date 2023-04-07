package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@AllArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String address;
    private int indexNumber;
    private String course;
    private int year;
    private int semester;
    private Map<String, Double> subjectsAndGrades;
    private List<String> subjectsForConditionalExam;

    public Employee studentToEmployeePromotion(Student student) {
        //similar to buildEmployee() in VerificationUtils class;
        return new Employee(student.getFirstName(), student.getLastName(), student.getAddress(), 3500,
                JobPosition.PHD_STUDENT, LocalDate.now(), true);
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
