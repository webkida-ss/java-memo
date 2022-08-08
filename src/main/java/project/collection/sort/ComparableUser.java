package project.collection.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComparableUser implements Comparable<ComparableUser> {
    private int id;
    private String name;
    private int age;

    /**
     * Comparableの抽象メソッド
     * <br>ソート順（自然順序）を定義
     * <br>年齢でソート
     *
     * @param o 比較対象のオブジェクト
     * @return このオブジェクトが多き場合は正の数
     */
    @Override
    public int compareTo(ComparableUser o) {
        int age = o.getAge();
        return (this.age > age) ? 1 : ((this.age == age) ? 0 : -1);
    }
}
