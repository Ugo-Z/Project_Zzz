package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class TabCheck {
    public static ArrayList<String> checkTab(ArrayList<String> lines){
        int lineIndex = 0;
        for (String line : lines){
            //line = line.replace("\t", Color.BG_RED + "\t" + Color.RESET);
            line = line.replace("\t", "<span style='background-color:red'>" + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</span>");
            //System.out.println(line);
            lines.set(lineIndex, line);
            lineIndex++;
        }

        return lines;

    }

    public static void TebView(ArrayList<String> lines){
        for (String line : lines){
            //line = line.replace("\t", Color.BG_RED + "\t" + Color.RESET);
            System.out.println(line);
        }
    }
}
