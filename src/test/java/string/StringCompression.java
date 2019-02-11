package string;

public class StringCompression {
    static String compression(String s1){
        StringBuilder res =   new StringBuilder().append(s1.charAt(0));
        int cons = 0;
        for(int i = 1; i < s1.length(); i++){
            cons++;
            if(s1.charAt(i)!= s1.charAt(i-1)){
                res.append(cons).append(s1.charAt(i));
                cons=0;//set it to1
            }
        }
        res.append(++cons);
        return res.length() < s1.length() ? res.toString() : s1;
    }

    public static void main(String[] args) {
        System.out.println(compression("aabcccccaaa"));
    }
}
