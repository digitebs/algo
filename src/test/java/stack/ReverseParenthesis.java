package stack;

import java.util.Stack;

public class ReverseParenthesis {
    public static void main(String[] args) {
        reverse("ad(oi(love)ew)jkl(bnm)");
    }
    public static void reverse(String s){
        Stack<String> stack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            //n * S) where S is the numeber parenthsies n == character
            char c = s.charAt(i);
            if(c == ')'){
                StringBuilder sb = new StringBuilder();
                String p=stack.pop();
                while(!p.isEmpty() && !p.equals("(")){
                    sb.append(p);
                    p=stack.pop();
                }
                for(char ch: sb.toString().toCharArray()){
                    stack.push(ch+"");//
                }

            }else{
                stack.push(c +"");
            }
        }
        System.out.println(stack);
    }
}
