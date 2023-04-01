package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class University {
    private String name;
    private String address;
    private List<String> faculties;
    private int priceFor1ECTS_Point;

}
