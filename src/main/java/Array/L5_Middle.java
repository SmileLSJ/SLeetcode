package Array;

import java.util.Arrays;

/**
 * Created by smile on 2019/6/19.
 */
public class L5_Middle {

    public String longestPalindrome(String s) {


        if(s.equalsIgnoreCase("")) return "";

        StringBuffer reverse = new StringBuffer(s).reverse();

        int maxLen = 0;
        int endIndex = 0;

        int[][] digit = new int[s.length()][s.length()];

        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){

                if(s.charAt(i)==reverse.charAt(j)){


                    if(i==0 || j==0){
                        digit[i][j]=1;
                    }else{
                        digit[i][j]=digit[i-1][j-1]+1;
                    }

                }else{
                    digit[i][j]=0;
                }

                if(digit[i][j]>maxLen){
                    endIndex = i;
                    maxLen = digit[i][j];
                }
            }
        }

        return s.substring(endIndex-maxLen,endIndex);

    }



    public String longestPalindrome2(String s){

        if(s==null || s.length()==0)return "";
        //回文的开始和结束
        int start = 0;
        int end = 0;


        for(int i=0;i<s.length();i++){


            int len1 = longestPalindrome(s,i,i);
            int len2 = longestPalindrome(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len>(end-start)){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }

        return s.substring(start,end+1);

    }

    public int longestPalindrome(String s, int l,int r){
        while(l>=0 && r<=s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l+1;
    }



//    public String longestPalindrome(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }
//
//    private int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }

}
