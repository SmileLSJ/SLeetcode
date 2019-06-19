package Array;

/**
 * Created by smile on 2019/6/19.
 */
public class L7_Easy {

    public  static  int reverse(int x) {

        int sum = 0;//记录反过来的值

        while(x!=0){

            int pop = x%10;

            if(sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10 && pop>Integer.MAX_VALUE%10)){
                return 0;
            }
            if(sum<Integer.MIN_VALUE/10 || (sum==Integer.MIN_VALUE/10 && pop<Integer.MIN_VALUE%10)){
                return 0;
            }

            sum = sum * 10 + pop;
            //计算余数
            x = x/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));

        System.out.println(Integer.MAX_VALUE);
    }
}
