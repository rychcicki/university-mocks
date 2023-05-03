package university_mocks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class Employee extends Person {
    private double salary;
    private JobPosition jobPosition;
    private LocalDate dateOfEmployment;
    private boolean isEmployed;


    public Employee(String firstName, String lastName, String address, double salary, JobPosition jobPosition,
                    LocalDate dateOfEmployment, boolean isEmployed) {
        super();
        this.salary = salary;
        this.jobPosition = jobPosition;
        this.dateOfEmployment = dateOfEmployment;
        this.isEmployed = isEmployed;
    }
}
