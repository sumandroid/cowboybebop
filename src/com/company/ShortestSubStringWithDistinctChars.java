package com.company;

import java.util.HashMap;
import java.util.Map;

public class ShortestSubStringWithDistinctChars {

    public static void main(String []args){
        String sampleString = "abbcadefgeh";
        char[] charArray = sampleString.toCharArray();
        Map<Character, Boolean> charExists = new HashMap<>();
        int count = 0;
        for(int i = 0; i < charArray.length; i++){
            if(charExists.get(charArray[i]) == null){
                charExists.put(charArray[i], true);
                count++;
            }
        }
        System.out.println("Length of smallest substring is:" + "\t" + count);
    }
}
