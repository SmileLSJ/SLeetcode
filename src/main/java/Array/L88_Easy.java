package Array;

/**
 * Created by smile on 2019/6/14.
 */
public class L88_Easy {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        while (n > 0) {

            //此处必须是m>0，m为nums1的有效长度，大于0才有意义往数组中插入元素
            //m==0，表示第一个数组的有效长度为0，需要第二个数组来进行插入，所以不能放到while循环外面
            if (m>0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[pos--] = nums1[--m];
            }else {
                nums1[pos--] = nums2[--n];
            }
        }
    }
}
