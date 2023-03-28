package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
//@NoArgsConstructor
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
}
