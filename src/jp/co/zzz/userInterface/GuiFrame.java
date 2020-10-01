package jp.co.zzz.userInterface;

import javax.swing.*;

public class GuiFrame extends JFrame {
    public GuiFrame(){
        // 閉じるで終了、ソフトタイトル設定
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Project_Zzz");

        JPanel panel = new GuiGridLayout();
        this.setContentPane(panel);
        this.setBounds(0, 0, 200, 150);
        this.setVisible(true);
    }
}
