package jp.co.zzz.userInterface;
import jp.co.zzz.userInterface.util.TabCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiGridLayout extends JPanel {
    private JTextField inputPath;

    public GuiGridLayout(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        JButton button = new JButton("Push");
        JTextField input = new JTextField();
        JLabel iPMessage = new JLabel("ファイルのパスを入力してください");
        JLabel iKMessage = new JLabel("ハイライトするキーワードを入力してください");
        inputPath = new JTextField(100);

        GridBagConstraints constraints = new GridBagConstraints();//制約に使うオブジェクト
        //constraints.fill = GridBagConstraints.BOTH;//【1】縦横にコンポーネットサイズを満たすように配置
        constraints.weightx = 1.0;//余分の水平スペースを分配
        constraints.weighty = 1.0;//余分の垂直スペースを分配
        constraints.insets = new Insets(10, 0, 5, 1);//上隙間,左隙間,下隙間,右隙間

        constraints.gridx = 0;	//位置x
        constraints.gridy = 0;	//位置y
        constraints.gridwidth = 3;	//コンポーネントの表示領域のセル数 横
        constraints.gridheight = 1;	//コンポーネントの表示領域のセル数 縦
        layout.setConstraints(iPMessage, constraints);//現在の制約を使い
        this.add(iPMessage);

        constraints.gridx = 3;	//位置x
        constraints.gridy = 0;	//位置y
        constraints.gridwidth = 1;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(button, constraints);//現在の制約を使い
        this.add(button);


        constraints.gridx = 0;	//位置x
        constraints.gridy = 1;	//位置y
        constraints.gridwidth = 400;	//コンポーネントの表示領域のセル数 横
        layout.setConstraints(inputPath, constraints);//現在の制約を使い
        this.add(inputPath);
    }

}
