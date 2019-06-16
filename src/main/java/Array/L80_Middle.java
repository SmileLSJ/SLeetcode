package Array;

/**
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定 nums = [1,1,1,2,2,3],

 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

 你不需要考虑数组中超出新长度后面的元素。

 */
public class L80_Middle {

    public static int removeDuplicates(int[] nums) {

        int k = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){

            if(i==0||nums[i]==nums[i-1]) count++;
            if(nums[i]!=nums[i-1])  count=1;

            if(count<=2){
                nums[k++]=nums[i];
            }
        }
        return k;
    }

    public int removeDuplicates2(int[] nums) {

        // 标记用来替换的位置
        int index = 0;
        // 标记相同的数字个数
        int count = 0;

        // 一遍遍历
        for(int i = 0; i< nums.length; i++){
            if(i == 0 || nums[i] == nums[i-1]){
                count++;
            }else if(nums[i] != nums[i-1]){
                count = 1;
            }

            // 小于二，标记指针移动
            if(count <= 2){
                nums[index++] = nums[i];
            }
        }

        return index;
    }




    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        removeDuplicates(arr);
    }
}
