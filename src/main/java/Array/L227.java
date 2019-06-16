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
            if(c<'0'&&c!=' '||i==len-1){
                if(op=='+') stack.push(num);
                if(op=='-') stack.push(-num);
                if(op=='*'||op=='/'){
                    int temp=(op=='*')?stack.pop()*num:stack.pop()/num;
                    stack.push(temp);
                }
                op=s.charAt(i);
                num=0;
            }
        }
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
