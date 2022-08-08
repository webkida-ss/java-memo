package project.basic.object;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDataAnnotation {
    private int id;
    private String name;
    private int age;
}
