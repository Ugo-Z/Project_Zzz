package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.CharCount;
import jp.co.zzz.userInterface.util.LineGet;

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
    private int counter;

    // [コンストラクタ] 操作するテキストをメンバ変数へ渡す
    public LoadFile(){
        lines = loadNewFile();
        counter = CharCount.countChar(lines);
    }

    public ArrayList getLines(){
        return lines;
    }

    public int getCounter(){
        return counter;
    }

    private String getPath(){
        return LineGet.getLine("ファイルパスを入力してください：");
    }

    // ファイルの内容をArrayListに変換
    public ArrayList loadNewFile(){
        ArrayList<String> lines = new ArrayList<>();
        Path path = Paths.get(getPath());
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
