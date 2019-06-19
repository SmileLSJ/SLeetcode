package Array;

import java.util.Arrays;

/**
 * Created by smile on 2019/6/19.
 */
public class L238_Middle {

    public static int[] productExceptSelf(int[] nums) {

        //记录之前的乘机，preArr[0]表示左边的第一个乘机
        int[] preArr  = new int[nums.length];

        System.arraycopy(nums,0,preArr,0,nums.length);


        //必须设置第一项左边的乘积为1,维护preArr的语义
        preArr[0]=1;

        //第一个数没有左边的值
        for(int i=1;i<nums.length;i++){
            preArr[i]=preArr[i-1]*nums[i-1];
        }

        //记录右边数的乘机
        int rightSum = nums[nums.length-1];

        for (int i=nums.length-2;i>=0;i--){

            //因为后面仍然使用num[i]，所以此处只能将结构放到preArr数组中
            //否则下面进行迭代相乘的时候，无法获取到后面数的乘机
            preArr[i] = preArr[i]*rightSum;

            rightSum = rightSum * nums[i];
        }

        return preArr;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        productExceptSelf(arr);
    }
}
