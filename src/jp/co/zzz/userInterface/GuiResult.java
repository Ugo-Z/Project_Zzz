package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.CharCount;
import jp.co.zzz.userInterface.util.Highlight;
import jp.co.zzz.userInterface.util.TabCheck;
import jp.co.zzz.userInterface.util.WordCount;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GuiResult {
    private String path;
    private String keyWord;
    public GuiResult(String path, String keyWord){
        this.path = path;
        this.keyWord = keyWord;
    }
    public void result(){
        //指定ファイルの読み込み
        LoadFile contents = new LoadFile(path);
        //指定ファイルのタブチェックの実行
        ArrayList<String> lines = new ArrayList<>();
        if (keyWord != null){
            Highlight highlight = new Highlight(TabCheck.checkTab(contents.getLines()));
            lines = highlight.textHighlight(keyWord);
        }else {
            lines = TabCheck.checkTab(contents.getLines());
        }

        //単語数、文字数カウントのラベル
        String wordCounter = Integer.toString(WordCount.countWord(lines));
        String charCounter = Integer.toString(CharCount.countChar(lines));

        //表示用のHTML文字列を宣言、先頭に<html>タグの追加
        StringBuilder htmlLine = new StringBuilder();
        htmlLine.append("<html>");
        htmlLine.append("パス：" + path + "<br>");
        htmlLine.append("単語数：" + wordCounter);
        htmlLine.append("文字数：" + charCounter);
        htmlLine.append("<br><br>");
        //タブチェックから出力されたArrayListの全行末尾に<br>を追加し、連結
        for(String line : lines) {
            htmlLine.append(line + "<br>");
        }
        //末尾に</HTML>タグの追加
        htmlLine.append("</html>");
        //表示用のJEditorPaneオブジェクトのコンストラクタにhtmlLineをHTMLテキストとして渡す
        JEditorPane pushLines = new JEditorPane("text/html", htmlLine.toString());
        //pushLinesの編集を無効化
        pushLines.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(pushLines);
        scrollPane.setPreferredSize(new Dimension(1200, 800));

        //pushLinesをウィンドウに表示
        JOptionPane.showConfirmDialog(null, scrollPane, "Result", JOptionPane.PLAIN_MESSAGE);
    }
}