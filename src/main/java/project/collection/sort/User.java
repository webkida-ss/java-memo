package project.collection.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // setter/getter/hashCode/equals/toString
@AllArgsConstructor
public class User{
    private int id;
    private String name;
    private int age;
}
