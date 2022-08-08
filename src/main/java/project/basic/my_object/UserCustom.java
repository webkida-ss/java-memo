package project.basic.my_object;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserCustom {
    private int id;
    private String name;
    private int age;

    @Override
    public boolean equals(Object obj) {
        UserCustom userCustom = (UserCustom)obj;
        String userName = userCustom.getName();
        return this.name.equals(userName);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
