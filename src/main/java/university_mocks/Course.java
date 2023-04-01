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


    public void tem(){
        Map<Integer, String> yearsAndSubjects = new HashMap<>();
        yearsAndSubjects.put(1,"Algebra");
        yearsAndSubjects.put(2,"Statistics");
        yearsAndSubjects.put(3,"Algorithms");
        yearsAndSubjects.put(4,"Data Analysis");

        /**
         * Czy tutaj też można (i jak) skorzystać z klasy 'VerificationUtils', która znajduje sie w testach????????
         */
//        buildListOfResearchers().


//    Course course = new Course("Mathematics",);

//        subjectsTaught1.add("Statistics");
//        subjectsTaught1.add("Algebra");
//        subjectsTaught2.add("Algebra");
//        subjectsTaught2.add("Algorithms");
//        subjectsTaught3.add("Economics");
//        subjectsTaught3.add("Data Analysis");
    }

}
