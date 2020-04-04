package string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*
Given a string of digits S,
 insert a minimum number of opening and closing parentheses into it such that the resulting string
  is balanced and each digit d is inside exactly d pairs of matching parentheses.

  Input:
  0000
  101
  111000
  1

  Output:
  0000
  (1)0(1)
  (111)000
  (1)
 */
public class NestingDepth {
  public static String nestingDepth(String s){
    StringBuilder sb = new StringBuilder();
    int curr = Character.digit(s.charAt(0),10);
   sb.append(padOpen(curr)).append(s.charAt(0));
    for(int i = 0; i < s.length()-1; i++){
      curr = Character.digit(s.charAt(i),10);
      int next = Character.digit(s.charAt(i+1),10);
      if(next > curr ) sb.append(padOpen(next -curr));
      else if(next == curr );
      else sb.append(padClose(curr-next));
      sb.append(next);
    }
    curr=  Character.digit(s.charAt(s.length()-1),10);
    sb.append(padClose(curr));
    return sb.toString();
  }


  static String padClose(int n){
    return IntStream.range(0,n).mapToObj(x->")").collect(Collectors.joining());
  }

  static String padOpen(int n){
    return IntStream.range(0,n).mapToObj(x->"(").collect(Collectors.joining());
  }
  public static void main(String[] args) {
    System.out.println(nestingDepth("000"));
  }
}
