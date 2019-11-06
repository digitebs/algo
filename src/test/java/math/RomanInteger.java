package math;

import java.util.HashMap;

public class RomanInteger {

    public int toRom(int f,int b, int num, StringBuilder sb,  HashMap<Integer,Character> hm){
        while(num-f >= 0){
            sb.append(hm.get(f));
            num-=f;
        }

        if(num / (f - b)  == 1){
            sb.append(hm.get(b)+""+hm.get(f));
            num -= (f-b);
        }
        return num;
    }
    public String intToRoman(int num) {
        HashMap<Integer,Character> hm = new HashMap<>();
        hm.put(1,'I');
        hm.put(5,'V');
        hm.put(10,'X');
        hm.put(50,'L');
        hm.put(100,'C');
        hm.put(500,'D');
        hm.put(1000,'M');

        StringBuilder sb = new StringBuilder();
        num = toRom(1000,100,num,sb,hm);
        num = toRom(500,100,num,sb,hm);
        num = toRom(100,10,num,sb,hm);
        num = toRom(50,10,num,sb,hm);
        num = toRom(10,1,num,sb,hm);
        num =  toRom(5,1,num,sb,hm);
        num =  toRom(1,0,num,sb,hm);

        return sb.toString();
    }

    public static void main(String args[]){
        RomanInteger rm = new RomanInteger();
        System.out.println(rm.intToRoman(1500));
    }
}
