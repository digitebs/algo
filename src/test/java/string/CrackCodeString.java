package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/** Created by johnlim on 13/1/17. */
public class CrackCodeString {

  @Test
  public void findPerm() {
    System.out.println(findPerm("ID", 3));
    System.out.println(findPerm("IDIDI", 6));
    System.out.println(
        findPerm(
            "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD",
            354));

    System.out.println(
        findPerm(
            "IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII",
            903));

    System.out.println(
        findPerm(
            "DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDID",
            818));

    System.out.println(
        findPerm(
            "DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDI",
            817));

    System.out.println(
        findPerm(
            "IIIDDDDDDDDIDDDIDDIIDDDDDDIIIIDIIIDDDIDIIIDDDIDDDDDDIIIDDDIIDDIIDIDIIIDIDIDIIIDDIIIIIDIIIIIDDIDDIDDDDIDIIDDIDIIDDIIDDIDDIDDDIIIIDIDDIDDDIIDDDDDIIDDDDDDDIIIIIDDIDIDDDIIDDIDIDIIDDDDIIIDDIDDIIIIDDDDIIDIDDDDDDDIIIDIDDDIDIDIDIIIDIDDIDDDIIIDDDIDDDDIDIIIDIIIIDIDDIIDDIIDIIDIDDDIIDDDDDIIDIIDDDIIDDDIDDDDDIDIDDDIIIDDDDIDIIIDDDIIIDIDDIIIIIDIDIIDIDIDDIIDDDIIIIDIIDDDDDDIDIIIIIDIDIIIIIDDDIIDIDDIIIDIIDIDDIIIIDIDDIIIDDDIDDIIIDIDIIDIDDDIDDIDDDIIDIIIIIDDDDDIIIDIIIIDDIDIDIDIDDDIIDDIDIDDDDDDDIIDIIIDIDDIDIIIDDDDDIDIIDDDIIIDIIIIDIDDDIDDIIDIDIDIIDDIIIDIDIDDIDIDDDDIIIDIIDIIDIIIDDIDIIDDIIIIDIIIIDIIDIIIDDIIDIIIIDDIDIDDIDDDIDDIIDIIDIIIDIDIIDIIIDIDDDIDDIIDDDDIDDIIDIDDIIDIDIDIDDDDDIIIIDDDIIDDDDIIDDDDDDIIDDIIIIDDIIDIDIDDIDDDIDIIIDDDIDDDIIIDIDIIDIIIIDIDIDIDIIDIIID",
            743));
  }

  public ArrayList<Integer> findPerm(final String A, int B) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    int start = 0;
    int end = 0;
    ArrayList<Integer> num = new ArrayList<Integer>();
    for (int i = 0; i < B; i++) {
      if (i < A.length() && A.charAt(i) == 'D') {
        start++;
      }
      num.add(i + 1);
    }

    end = start - 1;
    res.add(num.get(start++));

    for (int j = 0; j < A.length(); j++) {
      if (A.charAt(j) == 'I') {
        res.add(num.get(start++));
      } else {
        res.add(num.get(end--));
      }
    }
    return res;
  }

  @Test
  public void hotel() {

    System.out.println(
        hotel(
            new ArrayList<Integer>(
                Arrays.asList(47, 4, 0, 12, 47, 31, 15, 49, 29, 33, 7, 22, 26, 24, 16)),
            new ArrayList<Integer>(
                Arrays.asList(95, 4, 26, 16, 51, 79, 43, 58, 32, 80, 30, 27, 29, 54, 16)),
            10));

    System.out.println(
        hotel(
            new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
            new ArrayList<Integer>(Arrays.asList(2, 3, 4)),
            1));
    System.out.println(
        hotel(
            new ArrayList<Integer>(Arrays.asList(1, 3, 7)),
            new ArrayList<Integer>(Arrays.asList(2, 6, 8)),
            1));

    System.out.println(
        hotel(
            new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),
            new ArrayList<Integer>(Arrays.asList(10, 2, 6, 14)),
            2));
    System.out.println(
        hotel(
            new ArrayList<Integer>(
                Arrays.asList(
                    9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11,
                    27)),
            new ArrayList<Integer>(
                Arrays.asList(
                    32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19,
                    38)),
            16));
  }

  public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

    Collections.sort(
        arrive,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
          }
        });

    Collections.sort(
        depart,
        new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
          }
        });

    int last = depart.get(depart.size() - 1);
    int a = 0;
    int d = 0;
    int ctr = 0;
    // System.out.println("weak");
    for (int i = 0; i < last; i++) {

      System.out.println(ctr + " " + i + " " + K + " " + a + " " + d);
      if (d != depart.size() && depart.get(d) == i) {
        d++;
        ctr--;
      }

      if (a != arrive.size() && arrive.get(a) == i) {
        if (ctr >= K) return false;
        a++;
        ctr++;
        // System.out.println("FAA:"+ ctr+" "+i+" "+K);
      }
    }
    /*Integer[] idx = new Integer[arrive.size()];
    for (int i = 0; i < idx.length; i++) {
        idx[i]=i;
    }

    Arrays.sort(idx, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return arrive.get(idx[o1]).compareTo(arrive.get(idx[o2]));
        }
    });


    for (int i = 0; i < idx.length; i++) {
        Collections.swap(arrive,i,idx[i]);
        Collections.swap(depart,i,idx[i]);

    }

    for (int i = 0; i < arrive.size(); i++) {

        if(idx[i]+1 == arrive.size())
            continue;

        //try to remove
        if(ctr.remove(depart.get(idx[i])) ){
        }else{
            ctr.add(depart.get(idx[i]));
        }

        System.out.println(ctr);
        if(ctr.size()-1==K){
            return false;
        }

    }*/
    return true;
  }

  @Test
  public void repeatedNumberY() {

    double k = (Math.sqrt(2) * Math.sqrt(2) * Math.sqrt(3));
    double p = (Math.sqrt(2) * Math.sqrt(2) * Math.sqrt(3)) / (Math.sqrt(2) * Math.sqrt(2));
    System.out.println(Math.sqrt(3));
    System.out.println(p);
    // System.out.println( k / ( Math.sqrt(2) *   Math.sqrt(2)) +" "+ k % ( Math.sqrt(2) *
    // Math.sqrt(2)));
    System.out.println(repeatedNumberY(Arrays.asList(2, 5, 3, 2, 2)));
  }

  public int repeatedNumberY(final List<Integer> a) {

    HashMap<Integer, Integer> m = new HashMap();
    double multiple = 1;
    for (int i = 0; i < a.size(); i++) {

      if (m.get(a.get(i)) == null) {
        m.put(a.get(i), 1);
      } else {
        m.put(a.get(i), m.get(a.get(i)) + 1);

        if (m.get(a.get(i)) == 3) return m.get(a.get(i));
      }
    }
    System.out.println(m);

    return -1;
  }

  @Test
  public void repeatedNumberX() {
    System.out.println(repeatedNumberX(Arrays.asList(2, 3, 4, 1, 4, 1)));
  }

  public int repeatedNumberX(final List<Integer> a) {
    double sum = 0;
    for (int i = 0; i < a.size(); i++) {
      if (sum != 0) {
        double sumw = sum - Math.sqrt(a.get(i));

        // System.out.println(i+" "+ sum+" "+ sumw+" "+(sum + Math.sqrt(a.get(i))) +" "+ (sumw + 2 *
        // (Math.sqrt(a.get(i)))));

        if (sum + Math.sqrt(a.get(i)) == sumw + 2 * (Math.sqrt(a.get(i)))) {
          return a.get(i);
        }
      }

      sum += Math.sqrt(a.get(i));
    }

    return -1;
  }


  @Test
  public void insert() {
    ArrayList<Interval> a = new ArrayList();
    a.add(new Interval(1, 3));
    a.add(new Interval(6, 9));

    System.out.println(insert(a, new Interval(2, 5)));

    ArrayList<Interval> b = new ArrayList();
    b.add(new Interval(1, 2));
    b.add(new Interval(3, 5));
    b.add(new Interval(6, 7));
    b.add(new Interval(8, 10));
    b.add(new Interval(12, 16));
    System.out.println(insert(b, new Interval(4, 9)));

    ArrayList<Interval> c = new ArrayList();
    c.add(new Interval(1, 2));
    c.add(new Interval(10, 11));
    c.add(new Interval(12, 15));
    System.out.println(insert(c, new Interval(4, 13)));

    ArrayList<Interval> k = new ArrayList();
    k.add(new Interval(31935139, 38366404));
    k.add(new Interval(54099301, 76986474));
    k.add(new Interval(87248431, 94675146));
    System.out.println(insert(k, new Interval(43262807, 68844111)));

    ArrayList<Interval> d = new ArrayList();
    d.add(new Interval(1, 2));
    d.add(new Interval(10, 13));
    d.add(new Interval(15, 18));
    d.add(new Interval(19, 22));
    System.out.println(insert(d, new Interval(14, 16)));

    ArrayList<Interval> e = new ArrayList();
    e.add(new Interval(1, 2));
    e.add(new Interval(10, 13));
    e.add(new Interval(15, 18));
    System.out.println(insert(e, new Interval(16, 21)));

    ArrayList<Interval> g = new ArrayList();
    g.add(new Interval(1, 2));
    g.add(new Interval(10, 13));
    g.add(new Interval(15, 18));
    System.out.println(insert(e, new Interval(12, 21)));

    ArrayList<Interval> h = new ArrayList();
    h.add(new Interval(3, 5));
    h.add(new Interval(8, 10));
    System.out.println(insert(h, new Interval(10, 3)));

    ArrayList<Interval> f = new ArrayList();
    f.add(new Interval(1, 2));
    f.add(new Interval(10, 13));
    f.add(new Interval(15, 18));
    System.out.println(insert(f, new Interval(19, 21)));

    ArrayList<Interval> i = new ArrayList();
    i.add(new Interval(1, 2));
    i.add(new Interval(10, 13));
    i.add(new Interval(15, 18));
    System.out.println(insert(f, new Interval(3, 4)));

    ArrayList<Interval> j = new ArrayList();
    j.add(new Interval(1, 2));
    j.add(new Interval(10, 13));
    j.add(new Interval(15, 18));
    j.add(new Interval(19, 20));
    j.add(new Interval(21, 22));
    System.out.println(insert(j, new Interval(14, 17)));

    ArrayList<Interval> l = new ArrayList();
    l.add(new Interval(3, 5));
    l.add(new Interval(8, 10));
    System.out.println(insert(l, new Interval(1, 12)));
    /**/

  }

  public class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }

    @Override
    public String toString() {
      return "{" + start + "," + end + "}";
    }
  }

  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

    ArrayList<Interval> res = new ArrayList<>();

    boolean merge = false;

    if (newInterval.start > newInterval.end) {
      int temp = newInterval.start;
      newInterval.start = newInterval.end;
      newInterval.end = temp;
    }
    if (intervals.size() == 0) {
      res.add(newInterval);
      return res;
    }
    for (int i = 0; i < intervals.size(); i++) {
      if (newInterval.start > intervals.get(i).end) {
        res.add(intervals.get(i));
      } else if (newInterval.start >= intervals.get(i).start && !merge) {

        Interval temp = new Interval(intervals.get(i).start, newInterval.end);
        int j = i;
        while (j + 1 != intervals.size() && newInterval.end >= intervals.get(j + 1).start) {
          j++;
        }
        temp.end = Math.max(newInterval.end, intervals.get(j).end);

        newInterval = temp;
        res.add(temp);
        merge = true;
      } else if (intervals.get(i).start > newInterval.end) {
        if (!merge) {
          res.add(newInterval);
          merge = true;
        }
        res.add(intervals.get(i));
      } else if (newInterval.end >= intervals.get(i).start && !merge) {
        // if(newInterval.end <= intervals.get(i).end && !merge){

        Interval tmp = new Interval(newInterval.start, newInterval.end);
        int j = i;
        while (j != intervals.size() && newInterval.end >= intervals.get(i).end) {
          j++;
        }

        if (j == intervals.size()) continue;
        tmp.end = Math.max(newInterval.end, intervals.get(j).end);

        newInterval = tmp;
        res.add(tmp);
        merge = true;
      }
      System.out.println(
          "debug: intervals:"
              + intervals
              + " res: "
              + res
              + " interval:"
              + intervals.get(i)
              + " newinterval:"
              + newInterval);
    }

    /** special case outside the loop */
    if (merge == false && newInterval.end > intervals.get(intervals.size() - 1).end) {
      res.add(newInterval);
    }

    return res;
  }

  @Test
  public void maxset() {
    ArrayList a =
        Arrays.stream(new int[] {1, 2, 5, -7, 2, 3})
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    a =
        Arrays.stream(
                new int[] {
                  336465782,
                  -278722862,
                  -2145174067,
                  1101513929,
                  1315634022,
                  -1369133069,
                  1059961393,
                  628175011,
                  -1131176229,
                  -859484421
                })
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    System.out.println(maxset(a));
  }

  public ArrayList<Integer> maxset(ArrayList<Integer> a) {

    ArrayList<Integer> arr = new ArrayList<>();
    ArrayList<Integer> arrMax = arr;
    long sum = 0;
    long maxSum = 0;
    for (int i = 0; i < a.size(); i++) {

      if (a.get(i) >= 0) {
        arr.add(a.get(i));
        sum += a.get(i);
      } else {
        if (sum > maxSum) {
          arrMax = arr;
          maxSum = sum;
        }
        sum = 0;
        arr = new ArrayList<>();
      }
    }

    if (arr.size() != 0) {
      if (sum > maxSum) {
        arrMax = arr;
      }
    }

    return arrMax;
  }

  @Test
  public void flip() {
    System.out.println(flip("1101010001"));
    System.out.println(flip("011"));
    System.out.println(flip("110"));
    System.out.println(flip("010"));
    System.out.println(flip("0011101"));
    System.out.println(flip("10010"));
  }

  public ArrayList<Integer> flip(String A) {
    int zero = 0, one = 0;
    int start = 0, end = 0;

    int mostZ = 0;

    ArrayList<Integer> res = new ArrayList<>();
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '1' && zero != 0) {
        one++;
      }
      if (A.charAt(i) == '0') {
        if (zero == 0) {
          start = i + 1;
        }
        zero++;
      }
      if (one > zero) {
        zero = 0;
        one = 0;
      } else {
        end = i + 1;
        if (zero - one > mostZ) {
          mostZ = zero - one;
          res.clear();
          res.add(start);
          res.add(end);
        }
      }
      // System.out.println(i + ": one:" + one + " zero:" + zero + " start:" + start + " end:" +
      // end);
    }

    return res;
  }

  @Test
  public void repeatedNumber() {
    ArrayList a =
        Arrays.stream(new int[] {3, 1, 2, 5, 3})
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    // a = Arrays.stream(new int[]{1,1,2}).boxed().collect(Collectors.toCollection(ArrayList::new));
    a =
        Arrays.stream(
                new int[] {
                  389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218,
                  143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106,
                  246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471,
                  225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355,
                  243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421,
                  313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482,
                  222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137,
                  62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317,
                  383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77,
                  129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432,
                  418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408,
                  131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325,
                  472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362,
                  374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477,
                  136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127,
                  444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297,
                  405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140,
                  104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259,
                  397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73,
                  440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493,
                  150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350,
                  251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201,
                  398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494,
                  42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449,
                  8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242,
                  86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45,
                  529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283,
                  216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372,
                  363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269,
                  428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149,
                  160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249,
                  72, 410, 3, 21, 200, 260
                })
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
    //  a = Arrays.stream(new
    // int[]{6,5,1,6,4,2,7,8}).boxed().collect(Collectors.toCollection(ArrayList::new));
    System.out.println(repeatedNumber(a));
  }

  public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
    ArrayList<Integer> result = new ArrayList<>();

    long sum = 0;
    long orig = 0;

    long noSum = 0;
    long noOrig = 0;
    for (int i = 0; i < a.size(); i++) {
      long x = (long) a.get(i) * (long) a.get(i);
      long y = (long) (i + 1) * (long) (i + 1);

      sum += x;
      orig += y;

      noSum += a.get(i);
      noOrig += i + 1;
      System.out.println(x + " " + y);
    }

    System.out.println(a.size() + " " + sum + " " + orig + " " + noSum + " " + noOrig);

    long diffSquare = orig - sum;

    long diff = noOrig - noSum;

    long duplicate = Math.abs((diffSquare - (diff * diff)) / (2 * diff));

    System.out.println(diffSquare + " " + diff + " " + duplicate);

    result.add((int) duplicate);
    result.add((int) Math.abs(duplicate + diff));
    // System.out.println(sum.divide(gdc).subtract(orig.divide(gdc)) +" "+
    // Math.abs(noOrig-(noSum-dup)));

    return result;
  }

  public ArrayList<Integer> repeatedNumber2(final List<Integer> a) {
    ArrayList<Integer> result = new ArrayList<>();
    TreeSet<Integer> ht = new TreeSet();

    for (int i = 0; i < a.size(); i++) {
      if (ht.contains(a.get(i))) result.add(a.get(i));
      else ht.add(a.get(i));
    }

    for (int i = 1; i <= a.size(); i++) {
      if (!ht.contains(i)) {
        result.add(i);
        break;
      }
    }

    return result;
  }

  @Test
  public void maxrray() {
    // System.out.println(maxSubArray(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4)));

    System.out.println(
        maxSubArray4(
            Arrays.asList(
                -120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138, -167, -465,
                -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53, -488,
                -327, -182, -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320,
                -371, -5, 36, 89, -194, -140, -278, -65, -38, -144, -407, -235, -426, -219, 62,
                -299, 1, -454, -247, -146, 24, 2, -59, -389, -77, -19, -311, 18, -442, -186, -334,
                41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365, -249, -454, -226,
                -473, 91, -412, -30, -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429,
                -215, -102, -63, 80, 65, 63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68,
                -472, -463, -212, -267, -302, -471, -245, -165, 43, -288, -379, -243, 35, -288, 62,
                23, -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13, -459,
                -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60, 35,
                -107, -389, -427, -210, -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267,
                -270, -432, -272, -26, -327, -409, -353, -475, -210, -14, -145, -164, -300, -327,
                -138, -408, -421, -26, -375, -263, 7, -201, -22, -402, -241, 67, -334, -452, -367,
                -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415,
                -273, -200, -146, -437, -457, 75, 84, -233, -54, -292, -319, -99, -28, -97, -435,
                -479, -255, -234, -447, -157, 82, -450, 86, -478, -58, 9, -500, -87, 29, -286, -378,
                -466, 88, -366, -425, -38, -134, -184, 32, -13, -263, -371, -246, 33, -41, -192,
                -14, -311, -478, -374, -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211,
                -276, -190, -68, -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329,
                40, -341, -476, 28, -313, -78, -165, -310, -496, -450, -318, -483, -22, -84, 83,
                -185, -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2,
                81, -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256, -388,
                75, 40, -37, -449, -485, -487, -376, -262, 57, -321, -364, -246, -330, -36, -473,
                -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293, -298, -416, -222,
                -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163, -28, -210,
                -18, -484, 45, 10, 79, -441, -197, -16, -145, -422, -124, 79, -464, -60, -214, -457,
                -400, -36, 47, 8, -151, -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18,
                -474, -426, -162, -79, 25, -361, -88, -241, -225, -367, -440, -200, 38, -248, -429,
                -284, -23, 19, -220, -105, -81, -269, -488, -204, -28, -138, 39, -389, 40, -263,
                -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230,
                -410, -66, 67, -396, -146, -158, -264, -13, -15, -425, 58, -25, -241, 85, -82, -49,
                -150, -37, -493, -284, -107, 93, -183, -60, -261, -310, -380)));
    System.out.println(maxSubArray4(Arrays.asList(2, 6, 2, -1, 8, -9, 0, -3)));
    System.out.println(maxSubArray4(Arrays.asList(-500, 1, 2)));

    System.out.println(maxSubArray4(Arrays.asList(-89, -277, -475, -480, -420)));
  }

  Integer max = null;

  private int sum(final List<Integer> a) {

    if (a.size() == 0) return 0;
    if (a.size() == 1) return a.get(0);

    int m = 0;
    for (int i = 1; i < a.size(); i++) {

      m = sum(a.subList(0, i)) + sum(a.subList(i, a.size()));
      System.out.println("size: " + a + " i:" + i + " " + m);

      if (max == null || m > max) {
        max = m;
        System.out.println("qqqq" + max);
      }

      /*
      m = sum(a.subList(0, 1))+ sum(a.subList(1, a.size()-i));
      System.out.println("size: "+a+" i:"+i);
      if(max==null || m > max){
          max =m;
          System.out.println("qqqq"+max);
      }*/
    }

    System.out.println("bbb" + m);
    return m;
  }

  public int maxrray2(final List<Integer> a) {
    sum(a);
    return max;
  }

  // kadane algorithm

  @Test
  public void maxArr() {
    ArrayList arr =
        Arrays.stream(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4})
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    System.out.println(maxArr(arr));
  }

  public int maxArr(ArrayList<Integer> A) {
    int maxFar = A.get(0);
    int maxEnd = A.get(0);

    for (int i = 1; i < A.size(); i++) {
      maxEnd = Math.max(A.get(i) + maxEnd, A.get(i));
      maxFar = Math.max(maxEnd, maxFar);
    }

    return maxFar;
  }

  public int maxSubArray4(final List<Integer> a) {

    Integer maxSum = null;
    int sum = 0;
    int endPtr = 0;
    for (int i = a.size() - 1; i >= 0; i--) {
      if (maxSum == null) {
        maxSum = a.get(i);
      }
      if ((sum + a.get(i)) > maxSum) {
        sum += a.get(i);
      } else {
        if (sum == 0) sum = a.get(i);
        else sum -= endPtr;
        endPtr = a.get(i);
      }

      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }

  public int maxSubArray3(final List<Integer> a) {

    Integer maxSum = null;
    for (int i = a.size(); i >= 0; i--) {
      if ((i - 1) >= 0 && maxSum != null && Math.abs(a.get(i - 1) + maxSum) < maxSum)
        continue; // dont even continue this loops waste to time
      int sum = 0;
      for (int j = i - 1; j >= 0; j--) {
        sum += a.get(j);
        if (maxSum == null || sum > maxSum) {
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  public int maxSubArray(final List<Integer> a) {
    int sum = 0;
    Integer maxSum = null;
    for (int i = 0; i < a.size(); i++) {
      for (int j = i; j < a.size(); j++) {
        sum += a.get(j);
        if (maxSum == null || sum > maxSum) {
          maxSum = sum;
        }
      }
      sum = 0;
    }

    return maxSum;
  }

  @Test
  public void coverPoints() {

    ArrayList a =
        Arrays.stream(new int[] {4, 8, -7, -5, -13, 9, -7, 8})
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    ArrayList b =
        Arrays.stream(new int[] {4, 8, -7, -5, -13, 9, -7, 8})
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));

    System.out.println("pp" + coverPoints(a, b));
  }

  /**
   * (x,y) to (x+1, y), (x - 1, y), (x, y+1), (x, y-1), (x-1, y-1), (x+1,y+1), (x-1,y+1), (x+1,y-1)
   *
   * @param X
   * @param Y
   * @return
   */
  public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
    int m = 0;
    for (int i = 0; i < X.size() - 1; i++) {
      m += move(X.get(i), Y.get(i), X.get(i + 1), Y.get(i + 1));
    }

    return m;
  }

  /**
   * 0,0 1,1
   *
   * @param x
   * @param y
   * @param xdest
   * @param ydest
   */
  private int move(int x, int y, int xdest, int ydest) {
    int moves = 0;
    System.out.println("next: " + x + " " + y + " " + xdest + " " + ydest);
    while (x < xdest && y < ydest) {
      x++;
      y++;
      moves++;
      System.out.println("++ " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (x < xdest && y > ydest) {
      x++;
      y--;
      moves++;
      System.out.println("+- " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (x > xdest && y < ydest) {
      x--;
      y++;
      moves++;
      System.out.println("-+ " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (x > xdest && y > ydest) {
      x--;
      y--;
      moves++;
      System.out.println("-- " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (x < xdest) {
      x++;
      moves++;
      System.out.println("+  " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (x > xdest) {
      x--;
      moves++;
      System.out.println("-  " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (y < ydest) {
      y++;
      moves++;
      System.out.println(" + " + x + " " + y + " " + xdest + " " + ydest);
    }

    while (y > ydest) {
      y--;
      moves++;
      System.out.println(" - " + x + " " + y + " " + xdest + " " + ydest);
    }

    return moves;
  }
}
