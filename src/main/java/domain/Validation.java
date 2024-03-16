package domain;

import util.CheckUtil;


public class Validation {

    private static boolean beforeState = true;
    private static boolean isFirst = true;

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

    public static void checkSpliterPosition(String[] input) {
        String firstData = input[0];
        String lastData = input[input.length - 1];

        if (CheckUtil.isNumber(firstData) || CheckUtil.isNumber(lastData)) {
            throw new IllegalArgumentException();
        }

    }
}
