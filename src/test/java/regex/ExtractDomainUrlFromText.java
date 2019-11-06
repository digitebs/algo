package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDomainUrlFromText {

    // url extractor for a bunch of text
    public static List<String> extractUrls(String text)
    {
        List<String> containedUrls = new ArrayList<>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }

    static void getUrlDomain(String str){
        Pattern p = Pattern.compile("https*:\\/\\/(www.|ww2.|web.)?(.*)");
        Matcher m = p.matcher(str);

        m.find();
        System.out.println(m.group(2).split("\\/")[0]);
    }

    public static void main(String args[]){
        getUrlDomain("https://web.xyz.com");
    }
}
