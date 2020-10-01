package jp.co.zzz.userInterface;

import java.awt.*;

class GuiMain{
    public static void main(String args[]){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int displayWidth = screenSize.width;
        int displayHeight = screenSize.height;

        //フレーム生成
        GuiFrame layout = new GuiFrame();
        layout.setBounds(displayWidth / 4, displayHeight / 4, displayWidth / 2, displayHeight / 2);
        layout.setVisible(true);
    }
}
