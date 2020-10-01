package jp.co.zzz.userInterface;
import jp.co.zzz.userInterface.util.CharCount;
import jp.co.zzz.userInterface.util.Highlight;
import jp.co.zzz.userInterface.util.TabCheck;
import jp.co.zzz.userInterface.util.WordCount;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuiGridLayout extends JPanel implements ActionListener{
    protected JTextField inputPath;
    protected JTextField inputKeyWord;

    public GuiGridLayout(){
        UIManager.put("Button.font",new Font("MMeiryo", Font.PLAIN, 12)); //Buttonのフォント設定
        UIManager.put("Label.font",new Font("Meiryo", Font.PLAIN, 12)); //Labelのフォント設定
        UIManager.put("TextField.font",new Font("Meiryo", Font.PLAIN, 12)); //Listのフォント設定

        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        JButton button = new JButton("読み込み & 解析");
        button.addActionListener(this);
        setPreferredSize(new Dimension(1024, 768));
        JTextField input = new JTextField();
        JLabel inputPathMessage = new JLabel("ファイルのパスを入力してください");
        JLabel inputKeywordMessage = new JLabel("ハイライトするキーワードを入力してください");
        inputPath = new JTextField(16);
        inputKeyWord = new JTextField(16);

        GridBagConstraints constraints = new GridBagConstraints();//制約に使うオブジェクト
        constraints.fill = GridBagConstraints.BOTH;//【1】縦横にコンポーネットサイズを満たすように配置
        constraints.weightx = 1.0;//余分の水平スペースを分配
        constraints.weighty = 1.0;//余分の垂直スペースを分配
        constraints.insets = new Insets(10, 10, 10, 10);//上隙間,左隙間,下隙間,右隙間

        constraints.gridx = 0;	//位置x
        constraints.gridy = 0;	//位置y
        constraints.gridwidth = 3;	//コンポーネントの表示領域のセル数 横
        constraints.gridheight = 1;	//コンポーネントの表示領域のセル数 縦
        layout.setConstraints(button, constraints);//現在の制約を使い
        this.add(button);


        constraints.gridx = 0;	//位置x
        constraints.gridy = 1;	//位置y
        constraints.gridwidth = 1;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(inputPathMessage, constraints);//現在の制約を使い
        this.add(inputPathMessage);


        constraints.gridx = 3;	//位置x
        constraints.gridy = 1;	//位置y
        constraints.gridwidth = 2;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(inputPath, constraints);//現在の制約を使い
        this.add(inputPath);

        constraints.gridx = 0;	//位置x
        constraints.gridy = 2;	//位置y
        constraints.gridwidth = 1;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(inputKeywordMessage, constraints);//現在の制約を使い
        this.add(inputKeywordMessage);

        constraints.gridx = 3;	//位置x
        constraints.gridy = 2;	//位置y
        constraints.gridwidth = 2;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(inputKeyWord, constraints);//現在の制約を使い
        this.add(inputKeyWord);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //指定ファイルの読み込み
        LoadFile contents = new LoadFile(inputPath.getText());
        //指定ファイルのタブチェックの実行
        ArrayList<String> lines = new ArrayList<>();
        if (inputKeyWord.getText() != null){
            Highlight highlight = new Highlight(TabCheck.checkTab(contents.getLines()));
            lines = highlight.textHighlight(inputKeyWord.getText());
        }else {
            lines = TabCheck.checkTab(contents.getLines());
        }

        //単語数、文字数カウントのラベル
        String wordCounter = Integer.toString(WordCount.countWord(lines));
        String charCounter = Integer.toString(CharCount.countChar(lines));

        //表示用のHTML文字列を宣言、先頭に<html>タグの追加
        StringBuilder htmlLine = new StringBuilder();
        htmlLine.append("<html>");
        htmlLine.append("パス：" + inputPath.getText() + "<br>");
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
