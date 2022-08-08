package project.io;

import java.io.IOException;


/**
 * https://zenn.dev/kawakawaryuryu/articles/8924849b88590cda4e22
 * <p>
 * InputStream/OutputStream
 * 　バイト単位でデータを扱う、バイナリデータの読み書き
 * 　テキストデータの読み書きにも使えるが、
 * 　日本語のようなマルチバイト文字を読み出す場合にちぎれて文字化けを起こす可能性がある
 * 　→ そもそもこっちをテキストデータ読み込みに使うメリットはない
 * <p>
 * Reader/Writer
 * 　文字単位でデータを扱う
 * 　基本的に文字を扱う場合はこちら
 * <p>
 * InputStream/OutputStream、Reader/WriterのどちらもBufferedを使用し
 * バッファリングしてある程度データを貯めてからファイルに一気に書き出すのがベター（IO回数を減らす）
 * 1文字ずつとか書き出していると遅い！
 * <p>
 * Facadeパターン
 * FileReaderなどをベースにドンドン機能を追加していくパターンにより、BufferedReaderなどをは実装されている
 */
public class Main {

    public static void main(String[] args) throws IOException {

//        MyIOStream.bis();
//        MyIOStream.bos();

        MyIOStream.ois();
//        MyIOStream.oos();

//        MyReaderWriter.br();
//        MyReaderWriter.bw();
//        MyReaderWriter.pw();

    }
}
