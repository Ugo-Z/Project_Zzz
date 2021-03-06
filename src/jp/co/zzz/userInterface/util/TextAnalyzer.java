package jp.co.zzz.userInterface.util;

import java.util.ArrayList;

public class TextAnalyzer {
    private ArrayList<String> lines = new ArrayList<>();
    private int charCounter = 0;
    private int wordCounter = 0;
    private String keyWord;

    public TextAnalyzer(ArrayList<String> lines, String keyWord){
        this.lines = lines;
        keyWord = keyWord.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#39;").replace(" ", "&nbsp;");;
        this.keyWord = keyWord;
    }

    public ArrayList<String> textAnalyze(){
        int lineIndex = 0;
        for(String line : lines){
            charCounter += line.length();
            wordCounter += line.split("[,\\s]+").length;
            line = line.replace("&", "&amp;").replace("\"", "&quot;").replace("<", "&lt;").replace(">", "&gt;").replace("'", "&#39;").replace(" ", "&nbsp;");
            if (keyWord.length() >= 1) {
                textHighlight(line, keyWord, lineIndex);
                line = lines.get(lineIndex);
            }
            checkTab(line, lineIndex);
            lineIndex++;
        }
        return lines;
    }

    public int getCharCounter() {
        return charCounter;
    }

    public int getWordCounter() {
        return wordCounter;
    }

    private void textHighlight(String line, String keyWord, int lineIndex) {
        line = line.replace(keyWord, Color.HTML_RED + keyWord + Color.HTML_RESET);
        lines.set(lineIndex, line);
    }
    private void checkTab(String line, int lineIndex){
        // タブをHTMLエンティティに書き換えて色付け
        line = line.replace("\t", Color.HTML_BG_RED + "&#9;" + Color.HTML_BG_RESET);
        lines.set(lineIndex, line);
    }
}
