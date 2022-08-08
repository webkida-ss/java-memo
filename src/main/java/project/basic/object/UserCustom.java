package project.basic.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data//
public class UserCustom {
    private int id;
    private String name;
    private int age;

    /*
     * 個別に定義すれば、@Dataよりも優先される
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        UserCustom userCustom = (UserCustom)obj;
        String userName = userCustom.getName();
        return this.name.equals(userName);
    }
}
