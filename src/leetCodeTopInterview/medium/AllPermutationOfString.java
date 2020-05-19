package leetCodeTopInterview.medium;

public class AllPermutationOfString {

    public static void main(String []args){
        String s = "abc";
        int n = s.length();
        permute(s, 0, n-1);

    }

    private static void permute(String s, int l, int r){
        if(l == r){
            System.out.println(s);
        }else{
            for(int i = l; i <= r; i++){
                 s = swap(s, i, l);
                 permute(s, l+1, r);
                 s = swap(s, i, l);
            }
        }
    }

    private static String swap(String s, int i, int j){
        char temp = s.charAt(i);
        char[] chArr = s.toCharArray();
        chArr[i] = s.charAt(j);
        chArr[j] = temp;
        return String.valueOf(chArr);
    }
}
