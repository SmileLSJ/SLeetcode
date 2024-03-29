package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class L3_Middle {

    public int lengthOfLongestSubstring(String s) {

        int l  = 0;int r  = -1;
        Map<Character,Integer> chars  = new HashMap<>();

        int maxLen  = -1;
        while(l<s.length()){

            if(r+1 <s.length() && !chars.containsKey(s.charAt(r+1))){
                chars.put(s.charAt(r+1),r+1);
                r++;
            }else {
                chars.remove(s.charAt(l++));
            }
            maxLen = maxLen>(r-l+1)?maxLen:(r-l+1);
        }

        return  maxLen;

    }
}
