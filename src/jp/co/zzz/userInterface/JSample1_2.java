package jp.co.zzz.userInterface;
import javax.swing.JFrame;

class JSample1_2{
    public static void main(String args[]){
        JFrame frame = new JFrame("MyTitle");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
