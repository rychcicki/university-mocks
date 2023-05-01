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
        Student myStudent = Student.builder()
                .firstName("Marcin")
                .lastName("Kowalski")
                .address("Wiedeń")
                .indexNumber(254)
                .course("Math")
                .year(2)
                .semester(4)
                .subjectsAndGrades(makeMapOfSubjectsAndGrades(makeListOfSubjects(), makeListOfGrades()))
                .subjectsForConditionalExam(makeListOfSubjectsForConditionalExam())
                .build();
        listOfStudents.add(myStudent);
        for (Person person : listOfPersons) {
            Student student = Student.builder()
                    .firstName(person.getFirstName())
                    .lastName(person.getLastName())
                    .address(person.getAddress())
                    .indexNumber(faker.number().numberBetween(1, 3000))
                    .course(faker.educator().course())
                    .year(faker.number().numberBetween(1, 5))
                    .semester(faker.number().numberBetween(1, 10))
                    .subjectsAndGrades(makeMapOfSubjectsAndGrades(makeListOfSubjects(), makeListOfGrades()))
                    .subjectsForConditionalExam(makeListOfSubjectsForConditionalExam())
                    .build();
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
