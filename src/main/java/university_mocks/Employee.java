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
}
