package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Subjects {
    private String nameOfSubject;
    private List<Researcher> researchersWhoTeachTheSubjects;
    private int ECTS_PointsForSubject;

}
