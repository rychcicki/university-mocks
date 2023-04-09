package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static university_mocks.StudentVerificationUtils.finalListOfStudents;
import static university_mocks.StudentVerificationUtils.makeListOfSubjects;

class StudentTest {
    List<Student> listOfStudents = finalListOfStudents;

    @Test
    public void shouldReturnFalseWhenStudentIsFired() {
        //given
        Student student1 = listOfStudents.get(0);
        Student student2 = listOfStudents.get(1);
        //when
        List<Student> students1 = student1.checkSubjectsForConditionalExam(listOfStudents, student1);
        List<Student> students2 = student2.checkSubjectsForConditionalExam(listOfStudents, student2);
        boolean check1 = students1.contains(student1);
        boolean check2 = students2.contains(student2);
        //then
        Assertions.assertTrue(check1);
        Assertions.assertFalse(check2);
    }

    @Test
    public void shouldReturnValidResearcherWhenStudentPromotedToPhDStudent() {
        //given
        Student student = listOfStudents.get(0);
        List<String> subjectsTaught = makeListOfSubjects();
        //when
        Employee employee = student.studentToEmployeePromotion(student);
        Researcher researcher = student.studentToPhDStudentPromotion(employee, subjectsTaught);
        JobPosition jobPosition = employee.getJobPosition();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(JobPosition.PHD_STUDENT, jobPosition),
                () -> Assertions.assertEquals(employee.getLastName(), researcher.getLastName()),
                () -> Assertions.assertTrue(subjectsTaught.contains(researcher.getSubjectsTaught().get(0))));
    }
}
