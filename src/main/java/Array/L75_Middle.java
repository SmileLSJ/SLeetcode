package Array;

/**
 * Created by smile on 2019/6/14.
 */
public class L75_Middle {




    public static void main(String[] args) {

    }


    public static void  sortColors(int[] nums){

        int zero = -1;//[0,zero]中是0
        int two = nums.length;//[two,n-1]是2

        for(int i=0;i<two;){
            if(nums[i]==1){
                i++;
            }else if(nums[i]==2){
                two--;
                swap(nums,i,two);
            }else {//i==0
                zero++;
                swap(nums,i,zero);
                i++;
            }
        }

    }

    public static void swap(int[] arr,int s ,int e){
        int tmp = arr[s];
        arr[s]=arr[e];
        arr[e]= tmp;
    }
}
