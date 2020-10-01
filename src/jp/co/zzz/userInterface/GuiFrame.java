package jp.co.zzz.userInterface;

import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame {
    public GuiFrame(){
        //Buttonのフォント設定
        UIManager.put("Button.font",new Font("Meiryo", Font.PLAIN, 22));
        //Labelのフォント設定
        UIManager.put("Label.font",new Font("Meiryo", Font.PLAIN, 18));
        //TextFieldのフォント設定
        UIManager.put("TextField.font",new Font("Meiryo", Font.PLAIN, 12));
        // 閉じるで終了、ソフトタイトル設定
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Project_Zzz");

        JPanel panel = new GuiGridLayout();
        this.setContentPane(panel);
    }
}
