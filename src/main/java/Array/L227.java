package Array;

import java.util.Stack;

/**
 * Created by smile on 2019/6/15.
 */
public class L227 {

    public static int calculate(String s) {
        int result=0,len=s.length(),num=0;
        char op='+';  //初始上一个运算符为加法 上个数字为0
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(c>='0'){
                num=num*10+s.charAt(i)-'0';
            }

            //当前为符号的前提下，通过判断上一次符号是什么进行入栈或者弹栈操作
            if(c<'0'&&c!=' '||i==len-1){

                //上一次是 +  ，入栈为正数
                if(op=='+') stack.push(num);

                //上一次是 -  ，入栈为负数
                if(op=='-') stack.push(-num);

                //如果前面是  x  或者是  /，弹出上次的数，与当前数进行操作，计算完成后压栈
                if(op=='*'||op=='/'){
                    int temp=(op=='*')?stack.pop()*num:stack.pop()/num;
                    stack.push(temp);
                }

                //保留上一次的符号位
                op=s.charAt(i);

                //将前面的数字压栈后，更新需要压栈的数字
                num=0;
            }
        }

        //对栈中的   正数  负数进行相加操作
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "2+3*3";
        calculate(s);

    }
}
