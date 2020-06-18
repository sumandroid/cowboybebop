package leetCodeTopInterview.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String []args){
        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        String digits = "23";
        List<String> res = new ArrayList<>();
        String[] digitsArr = digits.split("");
        computeStrings(map, digitsArr, res, 0, "");
        System.out.println(res);
    }

    private static void computeStrings(HashMap<String, String> map, String[] digitsArr, List<String> res, int i, String current){
        if(i == digitsArr.length){
            res.add(current);
            return;
        }
        String alphas = map.get(digitsArr[i]);
        String[] alphasA = alphas.split("");
        for(int j = 0; j < alphasA.length; j++){
            computeStrings(map, digitsArr, res, i+1, current + alphasA[j]);
        }
    }
}
