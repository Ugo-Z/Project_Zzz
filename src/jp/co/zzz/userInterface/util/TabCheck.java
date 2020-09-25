package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class TabCheck {
    public static void checkTab(ArrayList<String> lines){

        for (String line : lines){
            line = line.replace("\t", Color.BG_RED + "\t" + Color.RESET);
            System.out.println(line);
        }

    }
}
