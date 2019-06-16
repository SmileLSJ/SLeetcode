package Array;

/**
 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1:

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。

 */
public class L27_Easy {

    public  static int removeElement(int[] nums, int val) {

        int k = 0;//[0,k）都是非删除的元素

        for(int i = 0;i<nums.length;i++){

            if(nums[i]!=val){
                if(i!=k){
                    swap(nums,i,k++);
                }else{
                    k++;
                }
            }
        }
        return nums.length-k;
    }

    public static void swap(int[] nums,int s,int e){
        int tmp = nums[s];
        nums[s]=nums[e];
        nums[e] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        removeElement(arr,2);
    }
}
