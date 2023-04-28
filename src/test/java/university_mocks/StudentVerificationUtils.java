package university_mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static university_mocks.PersonVerificationUtils.faker;

public class StudentVerificationUtils {
    public static final List<Student> finalListOfStudents = buildListOfFakeStudents();

    private static List<Student> buildListOfFakeStudents() {
        List<Person> listOfPersons = PersonVerificationUtils.finalListOfRandomPersons;
        List<Student> listOfStudents = new ArrayList<>();
        Student myStudent = new Student();
        myStudent.setFirstName("Marcin ");
        myStudent.setLastName("Kowalski");
        myStudent.setAddress("Wiedeń");
        myStudent.setIndexNumber(254);
        myStudent.setCourse("Math");
        myStudent.setYear(2);
        myStudent.setSemester(4);
        myStudent.setSubjectsAndGrades(makeMapOfSubjectsAndGrades(makeListOfSubjects(), makeListOfGrades()));
        myStudent.setSubjectsForConditionalExam(makeListOfSubjectsForConditionalExam());
        listOfStudents.add(myStudent);
        for (Person person : listOfPersons) {
            Student student = new Student();
            student.setFirstName(person.getFirstName());
            student.setLastName(person.getLastName());
            student.setAddress(person.getAddress());
            student.setIndexNumber(faker.number().numberBetween(1, 3000));
            student.setCourse(faker.educator().course());
            student.setYear(faker.number().numberBetween(1, 5));
            student.setSemester(faker.number().numberBetween(1, 10));
            student.setSubjectsAndGrades(makeMapOfSubjectsAndGrades(makeListOfSubjects(), makeListOfGrades()));
            student.setSubjectsForConditionalExam(makeListOfSubjectsForConditionalExam());
            listOfStudents.add(student);
        }
        return listOfStudents;
    }

    private static Map<String, Double> makeMapOfSubjectsAndGrades(List<String> subjects, List<Double> grades) {
        Map<String, Double> subjectsAndGrades = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            subjectsAndGrades.put(subjects.get(i), grades.get(i));
        }
        return subjectsAndGrades;
    }

    static List<String> makeListOfSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Math");
        for (int i = 0; i < 10; i++) {
            subjects.add(faker.educator().course());
        }
        return subjects;
    }

    private static List<Double> makeListOfGrades() {
        List<Double> grades = new ArrayList<>();
        grades.add(4d);
        for (int i = 0; i < 10; i++) {
            grades.add(faker.number().randomDouble(1, 2, 5));
        }
        return grades;
    }

    // okazało się, że to dlatego test nie działał — wcześniej lista zawsze spełniła warunek wyrzucenia studenta z uczelni
    private static List<String> makeListOfSubjectsForConditionalExam() {
        List<String> subjectsForConditionalExam = new ArrayList<>();
//        int limit =  faker.number().numberBetween(0,6);
        for (int i = 0; i < 4; i++) {   // 'i < limit' for random conditional exams' list
            subjectsForConditionalExam.add(faker.educator().course());
        }
        return subjectsForConditionalExam;
    }
}
