package project.io;

import util.Config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 実装クラスは以下の通り
 * 　FileReader/FileWriter
 * 　InputStreamReader/OutputStreamWriter
 * 　BufferedReader/BufferedWriter
 * 　StringReader/StringWriter
 * 　PrintWriter
 * <p>
 * Bufferedのデフォルトのバッファサイズは8KB
 * コンストラクタでバッファサイズを変更する事もできる
 */
public class MyReaderWriter {
    public static void br() throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(Config.PATH_FILE_TEST);
        try (
                FileReader rw = new FileReader(file);
                BufferedReader br = new BufferedReader(rw);// バッファサイズを指定することも可能（デフォルト8KB）
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {// readLine：1行ずつテキストを読み込む
                lines.add(line);
            }
        }
        lines.forEach(System.out::println);
    }

    public static void bw() throws IOException {
        File file = new File(Config.PATH_FILE_TEST);
        try (
                FileWriter fw = new FileWriter(file, false);// 第2引数：追記モード（false：追記にせず新規）
                BufferedWriter bw = new BufferedWriter(fw);// バッファサイズを指定することも可能（デフォルト8KB）
        ) {
            bw.write("BufferedWriter");
            bw.newLine();
            bw.write("1行目テスト中");
            bw.newLine();
            bw.write("2行目テスト中");
            bw.newLine();
            bw.flush();// 明示的に書き込み実施
            bw.write("3行目テスト中");
            bw.newLine();
            bw.write("4行目テスト中");
            /*
             * flushなくても書き込みはされる
             * flushありだとそのタイミングで明示的に書き込みを実施し、
             * ない場合はバッファサイズがいっぱいになった際やcloseされた時に書き込みされる。
             */
        }
    }

    /**
     * PrintWriter：BufferedWriterの拡張
     * いろんなデータ型毎にメソッドが用意されている
     * フォーマットなどもできる
     * @throws IOException
     */
    public static void pw() throws IOException {
        File file = new File(Config.PATH_FILE_TEST);
        try (
                FileWriter fw = new FileWriter(file, false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
        ) {
            pw.println("PrintWriter");
            pw.println("1行目");
            pw.println(2);
            pw.format("%d行目",3);
            pw.flush();
        }
    }
}
