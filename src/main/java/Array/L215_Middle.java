package Array;

/**
 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4

 */
public class L215_Middle {

    //hash算法
    /** Hash思想 */
    public int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        int max = nums[0], min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        int[] arr = new int[max - min + 1];
        for (int n : nums) arr[max - n]++;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum >= k) {
                return max - i;
            }
        }
        return 0;
    }

    /** 分治 */
    public int findKthLargest(int[] nums, int k) {

       return  fastSort(nums,0,nums.length-1,k);
    }


    //使用快排来进行获取
    public int fastSort(int[] arr,int start,int end ,int k){
        int l = start,r = end;
        int index = arr[start];

        while(l<r){
            while(l<r && arr[r]>=index){
                r--;
            }

            if(l<r){
                arr[l++] = arr[r];
            }

            while (l<r && arr[l]<=index){
                l++;
            }

            if(l<r){
                arr[r--]=arr[l];
            }
        }

        arr[l]=index;

        if(l==k) {
            return index;
        }
        else  if(l<k){
            return fastSort(arr,l+1,end,k);
        }else{
            return fastSort(arr,start,l-1,k);
        }

    }



    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
