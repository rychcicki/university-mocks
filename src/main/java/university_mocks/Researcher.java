package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class Researcher extends Employee {
    private String degree;
    private List<String> subjectsTaught;

    public Researcher(String firstName, String lastName, String address, String degree, List<String> subjectsTaught) {
        super(firstName, lastName, address);
        this.degree = degree;
        this.subjectsTaught = subjectsTaught;
    }

    public boolean checkResearcherMayBeFired(@NonNull Researcher researcher, Subject subject) {
        Researcher anotherResearcher = null;
        if (researcher.getSubjectsTaught().size() > 0) {
            anotherResearcher = replaceResearcherByAnotherResearcher(researcher, subject);
            // other methods
        }
        return anotherResearcher != null;
    }

    // doesn't replace, just return another Researcher
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
