package Array;

/**
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 */
public class L26_Easy {

    public static int removeDuplicates(int[] nums) {

        int k = 0;//【0，k）
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=nums[k]) {
                if (i != k) {
                    swap(nums, i, k++);
                } else {
                    k++;
                }
            }else{
                k++;
            }
        }

        return k;
    }

    public static void swap(int[] nums,int s,int e){
        int tmp = nums[s];
        nums[s]=nums[e];
        nums[e] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
    }
}
