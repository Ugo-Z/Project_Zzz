package jp.co.zzz.userInterface.util;

import java.util.Scanner;

public class LineGet {
    // 出力するメッセージを引数で取得し、入力すべき内容を説明&標準入力
    public static String getLine(String instruct){
        System.out.print(instruct);
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();

        // [DEBUG] 入力した文字確認用
        //System.out.println(line);

        return line;
    }
}
