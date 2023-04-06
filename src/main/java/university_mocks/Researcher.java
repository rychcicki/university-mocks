package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Researcher extends Employee {
    private String degree;
    private List<String> subjectsTaught;


    public Researcher(String firstName, String lastName, String address, String degree, List<String> subjectsTaught) {
        super(firstName, lastName, address);
        this.degree = degree;
        this.subjectsTaught = subjectsTaught;

//        double random = Math.random();
//        int random2 = (int) (Math.random() * 50 + 1);
        /**
         *         Random rand = new Random();
         *         rand.nextInt(subjectsTaught.size());
         */
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
                .get(Researcher.pseudoRandomInt(subject.getResearchersWhoTeachTheSubjects()));
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


//    public boolean checkFlagOfEmployee(Employee employee) {
//        // Employee researcherEmployee = new Researcher("PhD",new ArrayList<String>());
//        return employee.isEmployed();
//    }


    // czy tutaj dopuszczalne jest użycie raw type of List?
    public static int pseudoRandomInt(List<Researcher> list) {
        return ThreadLocalRandom.current().nextInt(0, list.size() - 1);
    }
}
