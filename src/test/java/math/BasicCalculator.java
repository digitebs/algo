package math;

import java.util.Stack;

public class BasicCalculator {
  public int calculate(String s) {
    char[] c = s.toCharArray();

    StringBuilder num= new StringBuilder(5);
    Stack<Integer> nums = new Stack();
    Stack<Character> ops = new Stack();
    for(int i = 0; i < c.length; i++){
      //  System.out.println(nums+" "+ops);
      switch(c[i]){
        case ' ': break;
        case '*':
        case '/':
        case '+':
        case '-':
          eval(ops,nums,c[i],num); break;
        default:
          num.append(c[i]);
      }
    }

    eval(ops,nums,'\u0000',num);
    return nums.pop();
  }

  public void eval(Stack<Character> ops, Stack<Integer> nums, char c, StringBuilder num){
    nums.push(Integer.parseInt(num.toString()));
    num.setLength(0);

    while(!ops.isEmpty() && p(ops.peek()) >= p(c))
      switch(ops.pop()){
        case '*' : nums.push(multiply(nums.pop(),nums.pop()));break;
        case '/': nums.push(divide(nums.pop(),nums.pop()));break;
        case '+' : nums.push(add(nums.pop(),nums.pop()));break;
        case '-': nums.push(subtract(nums.pop(),nums.pop()));break;
      }

    if(c!='\u0000') ops.push(c);
  }


  public int p(char c){
    switch(c){
      case '*' :
      case '/' : return 2;
      case '+' :
      case '-' : return 1;
    }
    return -1;
  }
  public int add(int a, int b){

    return a+b;
  }

  public int subtract(int b, int a){
    return a-b;
  }
  public int divide(int b, int a){
    return a/b;
  }

  public int multiply(int a, int b){
    return a*b;
  }
}
