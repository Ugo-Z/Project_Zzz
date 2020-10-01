package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.*;

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
        if (contents.getLines().get(0) == "101"){
            // ファイルぬるぽのフレーム生成、エラーダイアログ表示
            JFrame errorFrame = new JFrame();
            JOptionPane.showMessageDialog(errorFrame, "ファイルが見つかりません", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //指定ファイルのタブチェックの実行
        ArrayList<String> lines = new ArrayList<>();
        TextAnalyzer textAnalyzer = new TextAnalyzer(contents.getLines(), keyWord);
        lines = textAnalyzer.textAnalyze();

        //単語数、文字数カウントのラベル
        String wordCounter = Integer.toString(textAnalyzer.getWordCounter());
        String charCounter = Integer.toString(textAnalyzer.getCharCounter());

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
        JOptionPane.showMessageDialog(null, scrollPane, "Result", JOptionPane.PLAIN_MESSAGE);
    }
}
