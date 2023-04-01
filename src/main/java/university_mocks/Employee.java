package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    private JobPosition jobPosition;
    private LocalDate dateOfEmployment;
    private boolean isEmployed;

    public Employee(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    void setIsEmployed(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }


}
