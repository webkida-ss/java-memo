package project.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class SerUser implements Serializable {
    private int id;
    private String name;
    private int age;
}
