import java.util.Stack;

/**
 * Created by smile on 2019/6/15.
 */
public class L224_Hard {

    public int calculate(String s) {

        Stack<Integer> stack= new Stack<>();

        int sign = 1;

        int sum = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int cur = c-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))){
                    cur  = cur * 10 + s.charAt(++i) - '0';
                }
                sum =  sum+sign*cur;
            }else if(c=='+'){
                sign=1;
            }else if(c=='-') {
                sign = -1;
            }else if(c=='('){
                stack.push(sum);
                sum=0;
                stack.push(sign);
                sign=1;
            }else if(c==')'){
                sum  = sum*stack.pop()+stack.pop();
            }

        }

        return sum;

    }
}
