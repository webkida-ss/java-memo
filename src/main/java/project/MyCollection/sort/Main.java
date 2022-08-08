package project.MyCollection.sort;

import util.MyInstance;
import util.MyLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ソート
 * https://qiita.com/KevinFQ/items/09c73cc76cb646ae63f4
 * <p>
 * comparable：デフォルトソートを定義
 *
 * @FunctionalInterface Comparator
 * int compare(T o1, T o2);
 * <p>
 * compareTo
 * 引数よりも自分が大きいときは1
 */
/*

 */
public class Main {


    public static void main(String[] args) {
        comparableSorted();
        ComparatorSorted();
    }

    /**
     * comparable
     */
    private static void comparableSorted() {
        List<ComparableUser> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            userList.add(new ComparableUser(i, String.valueOf("name" + i), MyInstance.rand.nextInt(10) + 10));
        }
        userList.stream()// 新たなストリームを返す
                .sorted()// Comparable を実装している必要がある
                .forEach(System.out::println);
    }

    /**
     * ComparatorSorted
     */
    private static void ComparatorSorted() {
        // 都市リスト =====================================================================
        List<String> cityList = Arrays.asList("Tokyo", "Osaka", "Kanagawa", "Fukuoka");
        cityList.sort(// 新たなストリームを返すわけではない
                Comparator.comparingInt(String::length)// 文字の長さでソート
                        .thenComparing(Comparator.naturalOrder())// 文字列の昇順でソート
        );
        cityList.forEach(System.out::println);

        MyLog.logSeparator();

        // 名前リスト =====================================================================
        List<String> nameList = Arrays.asList("Takashi", "Satoshi", "Yuta", "Kosuke");
        Comparator<String> nameComparator = (s1, s2) -> s1.compareTo(s2);// アルファベット昇順
        nameList.stream()
                .sorted(nameComparator)
                .forEach(System.out::println);
        // 匿名クラスで書くと
        Comparator<String> nameComparator2 = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        };

        MyLog.logSeparator();

        // ユーザリスト作成 =====================================================================
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            userList.add(new User(i, String.valueOf("name" + i), MyInstance.rand.nextInt(10) + 10));
        }
        userList.stream().forEach(System.out::println);

        // Comparator =====================================================================
        Comparator<User> con1 = Comparator.comparing(User::getAge);
        Comparator<User> con2 =
                Comparator.comparing(User::getAge)
                        .thenComparing(User::getName)
                        .thenComparing(e -> e.getName())
                        .thenComparing(e -> e.getAge())
                        .thenComparingInt(e -> e.getAge())
                        .thenComparingInt(User::getAge)
                        .reversed();
    }

}
