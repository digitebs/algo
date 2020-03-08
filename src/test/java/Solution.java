import model.Tuple;
import time.Time;

import java.io.BufferedWriter;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

/** Created by johnlim on 10/2/16. */
public class Solution {
  public static void main(String args[]) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");

    System.out.println(1e0);
    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      System.out.println(string);
    }

    // "2016-08-29 10:00".
    // DateFormat.
   // DateFormat f = new SimpleDateFormat("y-MM-dd HH:mm");

    String s="2016-08-26 22:40";
    String l = "2016-08-29 10:00";

    // out.println(str);


    /*DateFormat  f = DateFormat.getInstance();
    try{
      out.println(    java.time.LocalDateTime.parse(s+":0"));
    out.println(f.format(new Date(2*f.parse(s).getTime()-f.parse(l).getTime())));
    }catch (Exception e){e.printStackTrace();}*/

     (new java.sql.Timestamp(2*p(s)-p(l))+"").substring(0,16);
  }

  static java.time.LocalDateTime x(String s){
    return java.time.LocalDateTime.parse(s.replace(" ","T"));
  }
  static long p(String s){
    return java.sql.Timestamp.valueOf(s+":0").getTime();
  }
}
