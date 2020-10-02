package jp.co.zzz.userInterface;

import javax.swing.*;
import java.awt.*;

public class GuiFrame extends JFrame {
    public GuiFrame(){
        //フォントサイズ設定
        UIManager.put("Button.font", new Font("Meiryo", Font.PLAIN, 22));
        UIManager.put("Label.font", new Font("Meiryo", Font.PLAIN, 18));
        UIManager.put("TextField.font", new Font("Meiryo", Font.PLAIN, 18));
        UIManager.put("ComboBox.font", new Font("Meiryo", Font.PLAIN, 18));
        UIManager.put("List.font", new Font("Meiryo", Font.PLAIN, 18));

        // 閉じるで終了、ソフトタイトル設定
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Project_Zzz");

        JPanel panel = new GuiGridLayout();
        this.setContentPane(panel);
    }
}
