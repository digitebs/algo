package string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    @Test
    public void testPermute() throws Exception{
        ArrayList<String> arr = new ArrayList();
        permute("","apple",arr);
        System.out.println(arr);
    }

    public static void permute(String front, String back, List result){

        if(back.length()==0) {
            result.add(front);
        }else {
            for (int i = 0; i < back.length(); i++) {
                permute(front + back.charAt(i), back.substring(0,i) + back.substring(i + 1, back.length()),result);
            }
        }
    }
}
