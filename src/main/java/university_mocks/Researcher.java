package university_mocks;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Researcher extends Employee {
    private String degree;
    private List<String> subjectsTaught;

    public boolean checkResearcherMayBeFired(@NonNull Researcher researcher, List<Researcher> researchersWhoTeachThisSubject) {
        Researcher anotherResearcher = null;
        if (!researcher.getSubjectsTaught().isEmpty()) {
            anotherResearcher = replaceResearcherByAnotherResearcher(researcher, researchersWhoTeachThisSubject);
        }
        return anotherResearcher != null;
    }

    public Researcher replaceResearcherByAnotherResearcher(Researcher researcher, List<Researcher> researchersWhoTeachDesiredSubject) {
        researchersWhoTeachDesiredSubject.remove(researcher);
        return researchersWhoTeachDesiredSubject
                .get(new Random().nextInt(0, researchersWhoTeachDesiredSubject.size()));
    }

    public List<Researcher> deleteResearcherFromStaffAndSetFalseAsEmployee(Researcher researcher, List<Researcher> staff) {
        if (staff.contains(researcher)) {
            staff.remove(researcher);
            researcher.setEmployed(false);
        }
        return staff;
    }

    public List<Researcher> deleteResearcherFromFaculty(@NonNull Researcher researcher, Faculty faculty) {
        List<Researcher> staff = faculty.getStaff();
        staff.remove(researcher);
        return staff;
    }
}
