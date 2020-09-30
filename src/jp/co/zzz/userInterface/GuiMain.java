package jp.co.zzz.userInterface;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;

class GuiMain{
    public static void main(String args[]){
        GuiFrame layout = new GuiFrame();
        layout.setBounds(100, 150, 550, 250);
        layout.setVisible(true);
    }
}
