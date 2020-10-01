package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class TabCheck {
    public static ArrayList<String> checkTab(ArrayList<String> lines){
        int lineIndex = 0;
        for (String line : lines){

            // タブをHTMLエンティティに書き換えて色付け
            line = line.replace("\t", Color.HTML_BG_RED + "&#9;" + Color.HTML_BG_RESET);
            lines.set(lineIndex, line);
            lineIndex++;

        }
        return lines;
    }

}
