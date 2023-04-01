package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Faculty {
    private String name;
    private List<String> studyCourses;
    private String address;
    private List<Researcher> staff;

}
