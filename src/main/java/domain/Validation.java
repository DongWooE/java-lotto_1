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
}
