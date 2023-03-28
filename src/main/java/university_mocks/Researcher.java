package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
//@NoArgsConstructor
@AllArgsConstructor
public class Researcher extends Employee {
    private String degree;
    private List<String> subjectsTaught;

    private enum Status {
        PHD_STUDENT, RESEARCHER, PROFESSOR
    }

    public boolean checkResearcherMayBeFired(Researcher researcher, Subjects subjects) {
        Researcher anotherResearcher = null;
        if (researcher != null && researcher.getSubjectsTaught().size() > 0) {
            anotherResearcher = replaceResearcherByAnotherResearcher(researcher, subjects);
        }
        return anotherResearcher != null;
    }

    // doesn't replace, just return another Researcher
    public Researcher replaceResearcherByAnotherResearcher(Researcher researcher, Subjects subjects) {
        if (subjects.getResearchersWhoTeachTheSubjects().contains(researcher) &&
                subjects.getResearchersWhoTeachTheSubjects().size() > 1) {
            subjects.getResearchersWhoTeachTheSubjects().remove(researcher);
        }
        return subjects.getResearchersWhoTeachTheSubjects()
                .get(Researcher.pseudoRandomInt(subjects.getResearchersWhoTeachTheSubjects()));
    }

    public boolean deleteResearcherFromStaff(Researcher researcher, List<Researcher> staff) {
        boolean remove = false;
        if (staff.contains(researcher)) {
            remove = staff.remove(researcher);
        }
        return remove;
    }

    public boolean checkFlagOfEmployee(Researcher researcher) {
        // Employee employee = new Employee();
//        if (researcher.getFirstName().equals()){
//
//        }
        return false;
    }


    // czy tutaj dopuszczalne jest użycie raw type of List?
    public static int pseudoRandomInt(List list) {
        return ThreadLocalRandom.current().nextInt(0, list.size() - 1);
    }
}
