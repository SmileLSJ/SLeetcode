package Array;

/**
 * Created by smile on 2019/6/14.
 */
public class FastSort {

    public static void fastSort(int[] arr,int start,int end){

        if(start<end) {

            int l = start, r = end;//两个都是可以获取到

            //保存中间值
            int middle = arr[start];


            while (l < r) {

                while (l < r && arr[r] >= middle) r--;

                if (l < r) arr[l++] = arr[r];

                while (l < r && arr[l] <= middle) l++;

                if (l < r) arr[r--] = arr[l];

            }

            arr[l] = middle;

            fastSort(arr, start, l);

            fastSort(arr, l + 1, end);
        }

    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};

        fastSort(arr,0,arr.length-1);

    }

}
