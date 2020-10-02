package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class WordCount {
    // 文字列を半角スペースとカンマで分割して単語数を産出し返す
    public static int countWord(ArrayList<String> lines){
        int counter = 0;
        ArrayList<String> work = new ArrayList<>();
        for (String line : lines) {
            counter += line.split("[,\\s]+").length;
        }
        return counter;
    }
}
