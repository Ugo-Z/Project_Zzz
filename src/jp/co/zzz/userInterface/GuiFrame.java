package jp.co.zzz.userInterface;

import javax.swing.*;
import jp.co.zzz.userInterface.util.TabCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GuiFrame extends JFrame {
    public GuiFrame(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("TestGridBagLayout");
        JPanel panel = new GuiGridLayout();
        this.setContentPane(panel);
        this.setBounds(0, 0, 200, 150);
        this.setVisible(true);
    }
}
