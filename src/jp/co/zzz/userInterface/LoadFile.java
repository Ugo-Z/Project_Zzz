package jp.co.zzz.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoadFile {
    // ファイルパスの入力受付
    private ArrayList<String> lines = new ArrayList<>();
    // [コンストラクタ] 操作するテキストをメンバ変数へ渡す
    public LoadFile(String Path){
        lines = loadNewFile(Path);
    }

    public ArrayList getLines(){
        return lines;
    }
    // ファイルの内容をArrayListに変換
    public ArrayList loadNewFile(String Path){
        ArrayList<String> lines = new ArrayList<>();
        Path path = Paths.get(Path);
        try (BufferedReader contents = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            for (String ln; (ln = contents.readLine()) != null; ){
                lines.add(ln);
            }

        } catch (IOException e) {
            System.out.println("ファイルが見つかりません。");
            e.printStackTrace();
            lines.add("101");
            return lines;
        }
        return lines;
    }
}
