package Array;

/**
 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
 如果不存在符合条件的连续子数组，返回 0。

 示例: 

 输入: s = 7, nums = [2,3,1,2,4,3]
 输出: 2
 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

 */
public class L209_Middle {

    public int minSubArrayLen(int s, int[] nums) {

        //窗口左右，初始不包含元素
        int l = 0,r=-1;
        int count = nums.length+1;
        int sum= 0;

        while(l<nums.length && r<nums.length){
            if(sum<s && r+1<nums.length){
                sum+=nums[++r];
            }else{
                sum-=nums[l++];
            }

            if(sum>=s){
                count = count<(r-l+1)?count:(r-l+1);
            }
        }


        if(count==nums.length+1) return 0;
        return count;
    }
}
