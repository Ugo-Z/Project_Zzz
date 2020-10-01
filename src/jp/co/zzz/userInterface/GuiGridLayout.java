package jp.co.zzz.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGridLayout extends JPanel implements ActionListener{
    protected JTextField inputPath;
    protected JTextField inputKeyWord;

    public GuiGridLayout(){

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
        GuiResult result = new GuiResult(inputPath.getText(), inputKeyWord.getText());
        result.result();
    }
}
