package project.basic.my_object;

import util.MyLog;

/**
 * equalsメソッド
 *  本来は 同値性！ を検証するもの
 *  ただし、Objectクラスのequalsのデフォルトの振る舞いは、同一性判定しているのと同じ（==）！
 *  Stringクラスではオーバーライドされていて、equalsは文字列が一緒であればtrueを返す
 *  [ルール]
 *  　hashCodeがfalseの場合はequalsもfalse
 *
 * hashCodeメソッド：オブジェクトのハッシュコード
 *  equalsを実装した場合は、hashCodeも実装する必要がある
 *  HashSetなど、ハッシュアルゴリズムに依存するものに対して影響がある
 *  → 適切なルール通りに実装しない場合は期待した動作にならない場合もある
 *  ※ ハッシュ値はint値であり、オブジェクトの同一検証にかかるコストが低い
 *    そのため、まずはハッシュ値で比較してその後に、equalsで更にふるいにかけたりする
 *    → パフォーマンスのためにやっている
 *  [ルール]
 *  　equalsがtrueな場合は必ずhashCodeもtrue
 *  　equalsがfalseな場合はhashCodeもtrue、falseどっちも可
 *
 * 独自定義したクラスにおいて、参照先は異なっても、
 * 保持する値が同じ場合は等価であると判断したい場合などに定義する必要がある。
 * それを独自に決めたい場合は自ら明示的に定義すればよい。
 *
 * lombokを使うメリット
 *  @Dataでequals、hashCodeを実装可能
 *   equals：インスタンスの参照が一致 or 全てのフィールドが一致 で true、 その他はfalse を返す
 *    → デフォルトだとインスタンスの参照が一致のみtrue
 *    → このルールではだめな場合は独自拡張が必要
 *   hashCode：ルールに則った形でハッシュコードを生成する
 *   toString：全値のKey = value形式で出力してくれる
 *
 * containsメソッドなどで内部的に使用されている
 *
 * https://qiita.com/yachinco/items/b1a3602d6aa261f5f7c4
 * https://penguinlabo.hatenablog.com/entry/java/EqualsAndHashCode
 */
public class Main {

    public static void main(String[] args) {
        normal();
        custom();
        dataAnnotation();
    }

    private static void normal(){
        MyLog.logSeparator();
        User user1 = new User(1,"名前1",10);
        User user2 = user1;
        User user3 = new User(1,"名前1",10);
        System.out.println(user1.equals(user2));// 同じ参照：true
        System.out.println(user1.equals(user3));// 同じ値だが、参照が異なる：false
    }

    /**
     * 名前で一致していたら同一と判定するようになっている前提
     */
    private static void custom(){
        MyLog.logSeparator();
        UserCustom userCustom1 = new UserCustom(1,"名前XXXXX",10);
        UserCustom userCustom2 = userCustom1;
        UserCustom userCustom3 = new UserCustom(100,"名前XXXXX",100);
        System.out.println(userCustom1.equals(userCustom2));// 同じ参照（名前が一致するため）：true
        System.out.println(userCustom1.equals(userCustom3));// 名前が一致：true
    }

    private static void dataAnnotation(){
        MyLog.logSeparator();
        UserDataAnnotation userDataAnnotation1 = new UserDataAnnotation(1,"名前1",10);
        UserDataAnnotation userDataAnnotation2 = userDataAnnotation1;
        UserDataAnnotation userDataAnnotation3 = new UserDataAnnotation(1,"名前1",10);
        UserDataAnnotation userDataAnnotation4 = new UserDataAnnotation(1,"名前1",11);
        System.out.println(userDataAnnotation1.equals(userDataAnnotation2));// 同じ参照：true
        System.out.println(userDataAnnotation1.equals(userDataAnnotation3));// インスタンスは異なるが1と同じ値：true
        System.out.println(userDataAnnotation1.equals(userDataAnnotation4));// 値が1つ異なる：false
    }
}
