package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    static void testUrl(String str){
        Pattern p = Pattern.compile("https*:\\/\\/(www.|ww2.|web.)?(.*)");
        Matcher m = p.matcher(str);

        m.find();
        System.out.println(m.group(2).split("\\/")[0]);
    }

    public static void main(String args[]){
        testUrl("https://web.xyz.com");
    }
}
