package jp.co.zzz.userInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadFile {
    public ArrayList getContents(){
        ArrayList<String> lines = new ArrayList<>();
        lines = loadNewFile(getPath());
        return lines;

    }
    private String getPath(){
        System.out.print("ファイルパスを入力してください：");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();
        System.out.println(filePath);
        return filePath;
    }
    private ArrayList loadNewFile(String filePath){
        ArrayList<String> lines = new ArrayList<>();
        Path path = Paths.get(filePath);
        try (BufferedReader contents = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            for (String ln; (ln = contents.readLine()) != null; ){
                lines.add(ln);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
