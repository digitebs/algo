package string;

public class IndexOf {
    public int indexOf(String haystack, String needle) {
        int n = needle.length();
        if (haystack.length() == 0 && n == 0) return 0;
        for (int i = 0, o = 0; i <= haystack.length() - n; i++) {
            while (o < n && haystack.charAt(i + o) == needle.charAt(o)) o++;
            if (o == n) return i;
            o = 0; // resets;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new IndexOf().indexOf("hello", "ll"));
    }
}
