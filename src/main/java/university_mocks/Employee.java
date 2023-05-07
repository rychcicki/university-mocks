package university_mocks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@SuperBuilder
public class Employee extends Person {
    private double salary;
    private JobPosition jobPosition;
    private LocalDate dateOfEmployment;
    @Setter
    private boolean isEmployed;
}
