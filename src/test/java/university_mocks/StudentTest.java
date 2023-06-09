package university_mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static university_mocks.StudentVerificationUtils.finalListOfStudents;
import static university_mocks.StudentVerificationUtils.makeListOfSubjects;

class StudentTest {
    private final List<Student> listOfStudents = finalListOfStudents;
    private final StudentService studentService = mock(StudentService.class, RETURNS_SMART_NULLS);
    private final SubjectService subjectService = mock(SubjectService.class, RETURNS_SMART_NULLS);

    @Test
    public void shouldReturnFalseWhenStudentIsFired() {
        //given
        when(studentService.addAll()).thenReturn(finalListOfStudents);
        List<Student> listOfStudents = studentService.addAll();
        Student student1 = listOfStudents.get(0);
        student1.setSubjectsForConditionalExam(Collections.emptyList());
        Student student2 = listOfStudents.get(1);
        //when
        List<Student> notFiredStudents1 = student1.checkSubjectsForConditionalExam(listOfStudents, student1);
        List<Student> notFiredStudents2 = student2.checkSubjectsForConditionalExam(listOfStudents, student2);
        boolean check1 = notFiredStudents1.contains(student1);
        boolean check2 = notFiredStudents2.contains(student2);
        //then
        Assertions.assertAll(
                () -> Assertions.assertTrue(check1),
                () -> Assertions.assertFalse(check2)
        );
    }

    @Test
    public void shouldReturnValidResearcherWhenStudentPromotedToPhDStudent() {
        //given
        when(studentService.addAll()).thenReturn(listOfStudents);
        SubjectRepository subjectRepository = mock(SubjectRepository.class);
        when(subjectRepository.isTrue()).thenCallRealMethod();
        Student student = studentService.addAll().get(0);
        when(subjectService.addAllStringSubjects()).thenReturn(makeListOfSubjects());
        List<String> subjectsTaught = subjectService.addAllStringSubjects();
        //when
        Employee employee = student.studentToEmployeePromotion(student);
        Researcher researcher = student.studentToPhDStudentPromotion(employee, subjectsTaught);
        JobPosition jobPosition = employee.getJobPosition();
        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(JobPosition.PHD_STUDENT, jobPosition),
                () -> Assertions.assertEquals(employee.getLastName(), researcher.getLastName()),
                () -> Assertions.assertTrue(subjectsTaught.contains(researcher.getSubjectsTaught().get(0)))
        );
    }
}
