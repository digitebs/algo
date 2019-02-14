package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {
    static int compute(List<String> tokens){
        Stack<Integer> stack = new Stack<>();
        for (String t: tokens) {
            if(t.equals("*") || t.equals("+") || t.equals("-") || t.equals("/") ){
                int a = stack.pop();
                int b =stack.pop();
                switch (t) {
                    case "*":
                        stack.push(b * a);
                        break;
                    case "-":
                        stack.push(b - a);
                        break;
                    case "+":
                        stack.push(b + a);
                        break;
                    default:
                        stack.push(b/a);
                        break;
                }
            }else stack.push(Integer.parseInt(t));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>(Arrays.asList("10","10","/","5","5","*","-"));
        System.out.println(compute(arr));
    }
}
