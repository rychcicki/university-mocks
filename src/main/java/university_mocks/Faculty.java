package university_mocks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
public class Faculty {
    private String name;
    private List<String> studyCourses;
    @Getter
    private String address;
    @Getter
    private List<Researcher> staff;
}
