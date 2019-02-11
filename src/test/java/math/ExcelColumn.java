package math;

public class ExcelColumn {
    static public String convertToTitle(int a) {
        String str = "ZABCDEFGHIJKLMNOPQRSTUVWXY";
        StringBuilder sb = new StringBuilder();
        for(int t = a; t > 0; t/=26){ //26 letters
            sb.append(str.charAt(t%26));
            if(t%26 == 0) t-=1; // backtrack!
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(5));
    }
}
