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

/** Created by johnlim on 10/2/16. */
public class Solution {
  public static void main(String args[]) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");

  //  System.out.println(Arrays.asList(new int[]{1},new int[]{2}));
    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      System.out.println(string);
    }
  }

  public static void shit(int... a){
    System.out.println(Arrays.toString(a));
  }

}
