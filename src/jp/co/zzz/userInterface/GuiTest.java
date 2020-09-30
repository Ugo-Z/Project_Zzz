package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.TabCheck;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GuiTest extends JFrame implements ActionListener {

    public static void main(String args[]){
        GuiTest frame = new GuiTest("MyTitle");
        frame.setVisible(true);
    }

    GuiTest(String title){
        setTitle(title);
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton button = new JButton("Push");

        button.addActionListener(this);

        panel.add(button);

        getContentPane().add(panel, BorderLayout.WEST);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //指定ファイルの読み込み
        LoadFile contents = new LoadFile("./test.c");
        //指定ファイルのタブチェックの実行
        ArrayList<String> lines = TabCheck.checkTab(contents.getLines());
        //表示用のHTML文字列を宣言、先頭に<html>タグの追加
        StringBuilder htmlLine = new StringBuilder();
        htmlLine.append("<html>");
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
