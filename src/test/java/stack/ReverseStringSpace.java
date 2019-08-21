package stack;

import java.util.Stack;

public class ReverseStringSpace {

    static void reverse(String s){
        
        Stack<Character> letter = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            letter.push(s.charAt(i));
        }

        Stack<String> words = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while(!letter.isEmpty()){
            Character c = letter.pop();
            if(c == ' '){
                words.push(sb.toString());
                sb=new StringBuilder();
            }else sb.append(c);
        }

        words.push(sb.toString());
        // System.out.print(words);
        while(!words.isEmpty()){
            System.out.print(words.pop()+" ");
        }


        
    }
    public static void main(String[] args) {
        reverse("the boy run");
    }
}
