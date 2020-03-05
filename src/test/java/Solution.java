import model.Tuple;

import java.io.BufferedWriter;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.System.out;

/** Created by johnlim on 10/2/16. */
public class Solution {


  public static void main(String args[]) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    
    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      System.out.println(~1);
    }
  }
  String curiousClock(String s, String l) throws Exception{
    //DateFormat f = new SimpleDateFormat("y-MM-dd HH:mm");
    DateFormat f = new SimpleDateFormat("y-MM-dd HH:mm");
    return f.format(2*f.parse(s).getTime()-f.parse(l).getTime());
  }
}
