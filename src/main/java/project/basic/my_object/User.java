package project.basic.my_object;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
public class User{
    private int id;
    private String name;
    private int age;
}
