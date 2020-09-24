package jp.co.zzz.userInterface;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class LoadFile {
    public static String getPath(){
        System.out.print("ファイルパスを入力してください：");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        System.out.println(filePath);
        return filePath;
    }
    public static void loadNewFile(String filePath){
        Path path = Paths.get(filePath);
        try (InputStream contents = Files.newInputStream(path)){
            for (int ch; (ch = contents.read()) != -1; ){
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
