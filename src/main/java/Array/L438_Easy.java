package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

 说明：

 字母异位词指字母相同，但排列不同的字符串。
 不考虑答案输出的顺序。
 示例 1:

 输入:
 s: "cbaebabacd" p: "abc"

 输出:
 [0, 6]

 解释:
 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。

 */
public class L438_Easy {

    public static List<Integer> findAnagrams(String s, String p) {

        int l = 0;int r = -1;
        Set<Character> c = new HashSet<>(p.length());
        List list  = new ArrayList();


        while(l<p.length()){

            if(r+1<p.length() && p.indexOf(s.charAt(r+1))!=-1){
                if(!c.contains(s.charAt(r+1))){
                    c.add(s.charAt(r+1));
                    r++;
                }
            }else if(r+1<p.length()){
                r++;
            }

            //左边界移动
            if((r-l+1)>p.length()){
                c.remove(s.charAt(l++));
            }
            if(c.size()==p.length()) list.add(l);

        }

        return list;
    }


}
