package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class Highlight{
    // 操作するテキストの内容（1行毎に配列）￥
    ArrayList<String> lines = new ArrayList<>();

    // [コンストラクタ] 操作するテキストをメンバ変数へ渡す
    public Highlight(ArrayList<String> lines){
        this.lines = lines;
    }

    // 受け取ったキーワードをハイライト
    public void highlightView(String keyWord){
        for (String line : lines) {
            // 正規表現でマッチしたらハイライト（置き換え）
            if(line.matches("^(?=.*" + keyWord + ").*$")){
                line = line.replace(keyWord, Color.RED + keyWord + Color.RESET);
            }
            System.out.println(line);
        }
    }

}
