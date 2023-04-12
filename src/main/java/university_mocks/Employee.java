package university_mocks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Employee extends Person {
    private double salary;
    private JobPosition jobPosition;
    private LocalDate dateOfEmployment;
    private boolean isEmployed;

    public Employee(String firstName, String lastName, String address, double salary, JobPosition jobPosition, LocalDate dateOfEmployment, boolean isEmployed) {
        super(firstName, lastName, address);
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.dateOfEmployment = dateOfEmployment;
        this.isEmployed = isEmployed;
    }
}
