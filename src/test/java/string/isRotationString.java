package string;

public class isRotationString {
    private static boolean isRotation(String s1, String s2){
        return (!s1.isEmpty() && s1.length() == s2.length()) && (s1 + s1).contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("erbottlewat","waterbottle"));
    }
}
