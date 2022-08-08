package project.io;


import util.Config;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 実装クラスは以下の通り
 * 　FileInputStream/FileOutputStream：ファイルからの読み書き
 * 　DataInputStream/DataOutputStream：基本データ型の読み書き
 * 　ByteArrayInputStream/ByteArrayOutputStream
 * 　ZipInputStream/ZipOutputStream
 * 　BufferedInputStream/BufferedOutputStream
 */
public class MyIOStream {

    public static void bis() throws IOException {
        List<String> lines = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(Config.PATH_FILE_TEST);// String/Fileどっちも可
                BufferedInputStream bis = new BufferedInputStream(fis);
        ) {
            byte[] byteArray = bis.readAllBytes();
            System.out.println(new String(byteArray));
        }
        lines.forEach(System.out::println);
    }

    public static void dis() throws IOException {
        List<String> lines = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(Config.PATH_FILE_TEST);// String/Fileどっちも可
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bis);
        ) {
//            int data = 0;
//            while ((data = bis.read()) != -1) {
//                System.out.println(data);
//            }
        }
        lines.forEach(System.out::println);
    }

    public static void ois() throws IOException {
        try (
                FileInputStream fis = new FileInputStream(Config.PATH_FILE_TEST);
                ObjectInputStream ois = new ObjectInputStream(fis);

        ) {
            SerUser user1 = (SerUser)ois.readObject();
            System.out.println(user1);
        }catch (ClassNotFoundException e){
        }
    }

        // ================================================================================================

    public static void bos() throws IOException {
        File file = new File(Config.PATH_FILE_TEST);
        try (
                FileOutputStream fos = new FileOutputStream(file);// String/Fileどっちも可
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            bos.write("BufferedOutputStream".getBytes());// バイト変換
            bos.write(0);
            bos.flush();
        }
    }

    public static void dos() throws IOException {
        File file = new File(Config.PATH_FILE_TEST);
        try (
                FileOutputStream fos = new FileOutputStream(file);// String/Fileどっちも可
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos);
        ) {
            dos.write("DataOutputStream".getBytes());// バイト変換
            dos.write(99);
            dos.flush();
        }
    }

    public static void oos() throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(Config.PATH_FILE_TEST);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            SerUser user1 = new SerUser(100,"ユーザ100",150);
            oos.writeObject(user1);// Serializableを実装する必要がある
        }
    }
}
