package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.Highlight;
import jp.co.zzz.userInterface.util.LineGet;
import jp.co.zzz.userInterface.util.TabCheck;

public class Zzz {
    public static void main(String[] args){
        // 複数ファイルに対応するためインスタンス生成
        LoadFile contents = new LoadFile();

        // 指定したファイルの内容を渡す
        Highlight highlight = new Highlight(contents.getLines());
        TabCheck.checkTab(contents.getLines());

        // ハイライト対象文字列の取得、ハイライト処理
        //highlight.highlightView(LineGet.getLine("ハイライトする文字列："));

        //文字数、単語数を表示
        //System.out.printf("文字数:%d\n", contents.getCharCounter());
        //System.out.printf("単語数:%d\n", contents.getWordCounter());
    }
}