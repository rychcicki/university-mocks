package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class StudentTest {
    // public final Student student = new Student();

    @Test
    public void shouldReturnFalseWhenStudentIsFired() {
        //given
        Map<String, Double> subjectsAndGrades = new HashMap<>();
        subjectsAndGrades.put("Statistics", 4.5);
        List<String> threeSubjectsForConditionalExam = new ArrayList<>(List.of("Statistics", "Algebra", "Algorithms"));
        List<String> fourSubjectsForConditionalExam = new ArrayList<>(List.of("Statistics", "Algebra", "Algorithms", "Economics"));
        Student student1 = buildStudent(subjectsAndGrades, threeSubjectsForConditionalExam);
        Student student2 = buildStudent2(subjectsAndGrades, fourSubjectsForConditionalExam);
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        //when
        List<Student> students1 = student1.checkSubjectsForConditionalExam(listOfStudents, student1);
        List<Student> students2 = student2.checkSubjectsForConditionalExam(listOfStudents, student2);
        boolean check1 = students1.contains(student1);
        boolean check2 = students2.contains(student2);
        //then
        Assertions.assertTrue(check1);
        Assertions.assertFalse(check2);
    }
//
//    @Test
//    public void shouldReturnTrueWhenFired2() {
//        //given

    //        //when
//        Student check = student.checkIfStudentIsFired(student.getSubjectsForConditionalExam());
//
//        //then
//        Assertions.assertNull(check);
//    }
    @Test
    public void shouldReturnValidResearcherWhenStudentPromotedToPhDStudent() {
        //given
        Map<String, Double> subjectsAndGrades = new HashMap<>();
        subjectsAndGrades.put("Statistics", 4.5);
        List<String> subjectsForConditionalExam = Collections.emptyList();
        Student student = buildStudent(subjectsAndGrades, subjectsForConditionalExam);
        List<String> subjectsTaught = new ArrayList<>(List.of("Statistics", "Algebra"));
        //when
        Employee employee = student.studentToEmployeePromotion(student);
        Researcher researcher = student.studentToPhDStudentPromotion(employee, subjectsTaught);
        JobPosition jobPosition = employee.getJobPosition();
        //then
        Assertions.assertAll(() -> Assertions.assertEquals(JobPosition.PHD_STUDENT, jobPosition), () -> Assertions.assertEquals(employee.getLastName(), researcher.getLastName()), () -> Assertions.assertTrue(subjectsTaught.contains(researcher.getSubjectsTaught().get(0))));
    }

    private Student buildStudent(Map<String, Double> subjectsAndGrades, List<String> subjectsForConditionalExam) {
        return new Student("Marcin", "Kowalski", "Vienna", 123, "Law", 2, 3, subjectsAndGrades, subjectsForConditionalExam);
    }

    private Student buildStudent2(Map<String, Double> subjectsAndGrades, List<String> subjectsForConditionalExam) {
        return new Student("Adam", "Nowak", "Warszawa", 158, "Math", 3, 5, subjectsAndGrades, subjectsForConditionalExam);
    }
}
