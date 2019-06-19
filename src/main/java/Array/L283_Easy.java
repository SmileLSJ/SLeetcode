package Array;

import java.util.Set;

/**
 * Created by smile on 2019/6/14.
 */
public class L283_Easy {


    //覆盖方法
    public static void moveZeroes2(int[] nums){

        int k = 0;
        for(int i= 0;i<nums.length;i++){
            if(nums[i]!=0)
                nums[k++]=nums[i];
        }

        for (int i=k;i<nums.length;i++){
            nums[i]=0;
        }
    }


    //对调方法
    public static void moveZeros4(int[] nums){

        int k = 0; //[0,k)保存非0的数值

        for(int i = 0;i<nums.length;i++){

            if(nums[i]!=0){
                swap(nums,k++,i);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }


    public static void main(String[] args) {
        int[] arr = {0,1,0,2,7};

        moveZeroes2(arr);

    }
}
