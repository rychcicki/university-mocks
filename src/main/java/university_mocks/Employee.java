package university_mocks;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Employee {
    private String firstName;
    private String lastName;
    private String address;
    private double salary;
    private String jobPosition;
    private LocalDate dateOfEmployment;
    private boolean isEmployed;
}
