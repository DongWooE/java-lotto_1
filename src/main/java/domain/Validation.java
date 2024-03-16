package domain;

import util.CheckUtil;

import java.util.ArrayList;
import java.util.List;


public class Validation {

    private static boolean beforeState = true;
    private static boolean isFirst = true;
    private static List<String> Splitters = List.of("+", "-", "*", "/");

    public static void process(String[] input) {
        for(String s : input){
            if(CheckUtil.isNumber(s)){
                if(beforeState && isFirst){
                    isFirst = false;
                }
                if(beforeState){
                   throw new IllegalArgumentException();
                }
                beforeState = true;
                continue;
            }
            if(!beforeState){
                throw new IllegalArgumentException();
            }
            beforeState = false;
        }
    }

    public static void checkSplitterPosition(String[] input) {
        String firstData = input[0];
        String lastData = input[input.length - 1];

        if (CheckUtil.isNumber(firstData) || CheckUtil.isNumber(lastData)) {
            throw new IllegalArgumentException();
        }

    }

    public static void checkValidSplitter(String[] input) {
        for (String str : input) {
            if (!CheckUtil.isNumber(str)) {
                if (!Splitters.contains(str)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }
}
