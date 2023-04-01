package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Subject {
    private String nameOfSubject;
    private List<Researcher> researchersWhoTeachTheSubjects;
    private int ECTS_PointsForSubject;

//    List<Subjects> listOfSubjects(){
//        List<Subjects> listOfSubjects = new ArrayList<>();
//        listOfSubjects.add()
//    }
//    Subjects sub = new Subjects();
}
