package Array;

/**
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:

 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 示例:

 输入: numbers = [2, 7, 11, 15], target = 9
 输出: [1,2]
 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 */
public class L167_Easy {

    public static int[] twoSum(int[] numbers, int target) {

        int first = 0;

        for(int i=0;i<numbers.length;i++){
            int firstNum  = numbers[i];
            int ret = target - firstNum;


            //[l,r]
            int l = i+1,r=numbers.length-1;

            while(l<=r){
                int middle = (l+r)/2;
                if(ret==numbers[middle]){
                    return new int[]{i+1,middle+1};
                }else if(ret>numbers[middle]){
                    l = middle+1;
                }else {
                    r = middle -1;
                }
            }
        }

        return null;
    }


    //双指针
    public static int[] twoSum2(int[] numbers,int target){
        int l = 0;
        int r  = numbers.length-1;

        while(l<r){
            if(numbers[l]+numbers[r]>target){
                r--;
            }else if(numbers[l]+numbers[r]<target){
                l++;
            }else{
                return new int[]{l,r};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(twoSum(arr,9));
    }
}
