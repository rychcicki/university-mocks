package university_mocks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
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

    public Researcher(String firstName, String lastName, String address, String degree, List<String> subjectsTaught) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.degree = degree;
        this.subjectsTaught = subjectsTaught;
    }

    public boolean checkResearcherMayBeFired(@NonNull Researcher researcher, Subject subject) {
        Researcher anotherResearcher = null;
        if (researcher.getSubjectsTaught().size() > 0) {
            anotherResearcher = replaceResearcherByAnotherResearcher(researcher, subject);
        }
        return anotherResearcher != null;
    }

    public Researcher replaceResearcherByAnotherResearcher(Researcher researcher, Subject subject) {
        if (subject.getResearchersWhoTeachTheSubjects().contains(researcher) &&
                subject.getResearchersWhoTeachTheSubjects().size() > 1) {
            subject.getResearchersWhoTeachTheSubjects().remove(researcher);
        }
        return subject.getResearchersWhoTeachTheSubjects()
                .get(new Random().nextInt(0, subject.getResearchersWhoTeachTheSubjects().size()));
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
