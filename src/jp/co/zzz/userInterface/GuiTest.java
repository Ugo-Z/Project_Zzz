package jp.co.zzz.userInterface;

import jp.co.zzz.userInterface.util.TabCheck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
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
        LoadFile contents = new LoadFile("./test.c");
        JLabel labels = new JLabel();
        ArrayList<String> lines = TabCheck.checkTab(contents.getLines());
        int linesMax = 0;
        for(String line : lines) {
            if(linesMax <= line.length()){
                linesMax = line.length();
            }
        }
        //JTextArea textArea = new JTextArea(linesMax, lines.size());
        String check = new String();
        for(String line : lines) {
            /*JLabel label = new JLabel(line);
            textArea.add(label);
            System.out.println(textArea);*/
            check += line + "\n";
        }
        JTextArea textArea = new JTextArea(check, linesMax, lines.size());
        JPanel panel = new JPanel();
        panel.add(textArea);
    }
}
