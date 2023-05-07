package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Subject {
    private String nameOfSubject;
    @Getter
    private List<Researcher> researchersWhoTeachTheSubjects;
    @Getter
    private int ectsPointsForSubject;
}
