package string;

import java.util.Arrays;

import static java.lang.Math.min;
import static java.lang.System.out;

public class VersionCompare {
    public String cropZero(String s){
        for(int i = 0; i< s.length(); i++)
            if(s.charAt(i) != '0')
                return s.substring(i);
        return s.substring(s.length());
    }

    public String[] clearZero(String[] arr){
        int i =  arr.length;
        while(i >0 && cropZero(arr[i-1]).isEmpty()) i--;
        return Arrays.copyOf(arr,i); // also known as slice
    }

    public int compareVersion(String a, String b) {
        String[] arr1 =a.split("\\.");
        String[] arr2 =b.split("\\.");

        arr1 = (arr1.length == 0) ? new String[]{a} : clearZero(arr1);
        arr2 = (arr2.length == 0) ? new String[]{b} : clearZero(arr2);

        for(int i =0 ; i < min(arr1.length,arr2.length); i++){
            arr1[i] = cropZero(arr1[i]);
            arr2[i] = cropZero(arr2[i]);

            if(arr1[i].length() > arr2[i].length()) return 1;
            else if(arr1[i].length() < arr2[i].length()) return -1;
            else{
                int c =  arr1[i].compareTo(arr2[i]);
                if(c > 0) return 1;
                else if(c < 0) return -1;
            }
        }

        if(arr1.length > arr2.length) return 1;
        else if(arr1.length < arr2.length) return -1;
        return 0;
    }

    public static void main(String args[]){
        out.println(new VersionCompare().compareVersion("1","0"));
        out.println(new VersionCompare().compareVersion("13.0","13.0.8"));
        out.println(new VersionCompare().compareVersion("13.0","13.0.0"));
        out.println(new VersionCompare().compareVersion("13.1.2","13.2"));
        out.println(new VersionCompare().compareVersion("1.0","1"));
        out.println(new VersionCompare().compareVersion("01","1"));
        out.println(new VersionCompare().compareVersion("13.1.2","13.1"));
        out.println(new VersionCompare().compareVersion("4444371174137455","5.168"));
        out.println(new VersionCompare().compareVersion("2","4"));
    }
}
