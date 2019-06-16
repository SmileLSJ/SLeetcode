package Array;

/**
 * Created by smile on 2019/6/14.
 */
public class L283_Easy {


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

    public static void moveZeroes(int[] nums) {

        if(nums==null) return;
        int i = 0;//第一个为0的位置

        for(;i<nums.length;i++){

            if(nums[i]!=0) continue;

            int j = i+1;//第一个非0的位置
            while (j<nums.length){
                if(nums[j]!=0)break;
                else j++;

            }

            if(j==nums.length) break;

            swap(nums,i,j);
        }

    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    public static void main(String[] args) {
//        int[] arr = {1,3,0,5,4,0,7};
        int[] arr = {0,1,0,2,7};

        moveZeroes(arr);
    }
}
