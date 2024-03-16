package domain;

import util.CheckUtil;

import java.util.List;


public class Validation {

    private static boolean beforeState = true;
    private static boolean isFirst = true;
    private static List<String> Splitters = List.of("+", "-", "*", "/");
    public static void validate(String[] input){
        if(input.length <= 0) throw new IllegalArgumentException();
        checkSplitterPosition(input);
        isFirst = false;
        for(int i =1; i < input.length; i++){
            handle(input[i]);
        }
    }

    private static void handle(String str){
        if(CheckUtil.isNumber(str)) {
            checkIfNumberDuplicate();
            beforeState = true;
            return;
        }
        checkValidSplitter(str);
        checkIfSplitterDuplicate();
        beforeState = false;
    }

    private static void checkIfNumberDuplicate(){
        if(beforeState && !isFirst){
            throw new IllegalArgumentException();
        }
    }

    private static void checkIfSplitterDuplicate(){
        if(!beforeState){
            throw new IllegalArgumentException();
        }
    }

    public static void checkSplitterPosition(String[] input) {
        String firstData = input[0];
        String lastData = input[input.length - 1];

        if (!CheckUtil.isNumber(firstData) || !CheckUtil.isNumber(lastData)) {
            throw new IllegalArgumentException();
        }

    }

    public static void checkValidSplitter(String str) {
        if (!Splitters.contains(str)) {
                throw new IllegalArgumentException();
            }
    }
}
