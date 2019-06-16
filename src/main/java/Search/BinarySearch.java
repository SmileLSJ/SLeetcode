package Search;

/**
 * Created by smile on 2019/6/13.
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1,2,3,5,6,7,89,100};

        System.out.println(binarySearch(arr,0,arr.length,4));

        System.out.println(binarySearch2(arr,arr.length,4));

    }

    public static int binarySearch(int[] arr,int start,int end,int target){
        int index = -1;

        if(arr.length==0) return index;
        if(start>end) return index;
        if(start==end){
            return (arr[start]==target)?start:index;
        }

        int middle = (start+end)/2;

        if(arr[middle]>target){
            return binarySearch(arr,start,middle-1,target);
        }else if(arr[middle]<target){
            return binarySearch(arr,middle+1,end,target);
        }else {
            return middle;
        }
    }

    public static int binarySearch2(int[] arr,int len ,int target){
        //明确两个变量，一个是二分查找法的左边界，一个是右边界
        //范围是在[left,right]之间进行查找，而且是可以取到，
        //right为len-1而不是len
        int left = 0;
        int right = len -1;

        //此处存在是否设置为等于
        //    因为left代表的是左边界，right代表的是右边界，当左右相等时，仍然说明存在用于比较的节点，
        //    所以，此处应为<=而不是<，如果小于，则将等于的节点去掉
        while(left<=right){

            int middle = (left+right)/2;

            if(arr[middle]==target) return middle;

            if(arr[middle]<target){
                //因为left代表的含义是左边界，没有进行过比较的左边界，
                //所以必须是middle+1，middle已经访问过
                left = middle+1;
            }

            if(arr[middle]>target){
                //同样的
                right = middle-1;
            }
        }

        return -1;
    }



    public static int binarySearch3(int[] arr,int len ,int target){
        //明确两个变量，一个是二分查找法的左边界，一个是右边界
        //范围是在[left,right)之间进行查找，而且是可以取到，
        //right为开区间即不是不在此处获取值
        int left = 0;
        int right = len;

        //此处存在是否设置为等于
        //    因为left代表的是左边界，right代表的是右边界，但是获取不到的边界，
        //    是在[left,right)中进行判断，所以left<right
        while(left<right){

            int middle = (left+right)/2;

            if(arr[middle]==target) return middle;

            if(arr[middle]<target){
                //左边界仍然可以获取，与上面的方法一直，所以不进行改变
                left = middle+1;
            }

            if(arr[middle]>target){
                //但是右边界是表示已经获取过的值，但是不能获取到
                right = middle-1;
            }
        }

        return -1;
    }

}
