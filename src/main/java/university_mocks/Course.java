package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class Course {
    private String name;
    private Map<Integer, String> yearsAndSubjects;
    private Map<String, List<String>> subjectsAndStaff;


    public void temp() {
        Map<Integer, String> yearsAndSubjects = new HashMap<>();
        yearsAndSubjects.put(1, "Algebra");
        yearsAndSubjects.put(2, "Statistics");
        yearsAndSubjects.put(3, "Algorithms");
        yearsAndSubjects.put(4, "Data Analysis");
    }

}
