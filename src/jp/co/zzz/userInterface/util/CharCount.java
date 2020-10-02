package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class CharCount {
    //受け取った文字列配列の全文字数を返す
    public static int countChar(ArrayList<String> lines){
        int counter = 0;
        for (String line : lines) {
            //文字列の文字数を足し合わせ
            counter += line.length();
        }
        return counter;
    }
}
