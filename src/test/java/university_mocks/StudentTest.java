package university_mocks;

import java.util.List;
import java.util.Map;

class StudentTest {

   // public final Student student = new Student();


//    @Test
//    public void shouldReturnNullWhenFired() {
//        //given
//        // Student student1 = new Student("Marcin","Kowalskki","Vienna",0123, "Law",2,3,);
////        Student student1 = new Student();
//
//        //when
//        boolean check = student.checkSubjectsForConditionalExam(student1.getSubjectsForConditionalExam());
//
//        //then
//        Assertions.assertTrue(check);
//    }
//
//    @Test
//    public void shouldReturnTrueWhenFired2() {
//        //given
//
//        //when
//        Student check = student.checkIfStudentIsFired(student.getSubjectsForConditionalExam());
//
//        //then
//        Assertions.assertNull(check);
//    }

    private Student buildStudent(Map<String, Double> subjectsAndGrades, List<String> subjectsForConditionalExam) {
        return new Student("Marcin", "Kowalskki", "Vienna", 123, "Law", 2, 3, subjectsAndGrades, subjectsForConditionalExam);
    }
}
