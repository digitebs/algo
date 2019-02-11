package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Created by johnlim on 13/1/17.
 */
public class CrackCodeString {

    @Test
    public void maximumGap2() {
        System.out.println(maximumGap2(Arrays.asList(1, 10, 5)));
        System.out.println(maximumGap2(Arrays.asList(100, 100, 100)));
        System.out.println(maximumGap2(Arrays.asList( 1, 10, 21, 33, 45)));
    }

    public int maximumGap2(final List<Integer> a) {

        int min=0;
        int max=0;
        for (int i = 0; i < a.size(); i++) {
            min = Math.min(a.get(i),min);
            max = Math.max(a.get(i),max);
        }

        HashSet<Integer> i = new HashSet<>(max-min);


        for (int j = 0; j < a.size(); j++) {
            i.add(a.get(j));
        }

        int diffMax=0;
        int prev=0;
        for (Integer x:i){
            if(prev!=0 && x-prev >= diffMax){
                diffMax=x-prev;
            }

            prev=x;

        }

        return (diffMax);


/*
        if(a.size()==1){
            return 0;
        }

        int min=0;
        int max=0;
        for (int i = 0; i < a.size(); i++) {
            min = Math.min(a.get(i),min);
            max = Math.max(a.get(i),max);
        }

        int[] sorter = new int[max+1];

        for (int i = 0; i < a.size(); i++) {
            sorter[a.get(i)]= 1;
        }

        int diffMax=0;
        int prev=0;
        for (int i = min; i <= max; i++) {

            if(sorter[i]!=0) {
                if(i-prev > diffMax){
                    diffMax=i-prev;
                }
                prev=i;
            }
        }

        return (diffMax);*/
    }


    @Test
    public void maximumGap1() {
        System.out.println(maximumGap1(Arrays.asList(1, 10, 5)));
    }

    public int maximumGap1(final List<Integer> a) {
        TreeSet<Integer> t = new TreeSet<>(a);

        if(t.size()==1){
            return 0;
        }
        int diffMax=0;
        int prev=0;
       for (Integer x:t){
           if(x-prev > diffMax){
               diffMax=x-prev;
           }

           prev=x;

       }

       return (diffMax);
    }
    @Test
    public void findPerm() {
        System.out.println(findPerm("ID",3));
       System.out.println(findPerm("IDIDI",6));
       System.out.println(findPerm("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD",
               354));

        System.out.println(findPerm("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII",
                903));

        System.out.println(findPerm("DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDID",
                818));

        System.out.println(findPerm("DIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDIDI",
                817));

        System.out.println(findPerm("IIIDDDDDDDDIDDDIDDIIDDDDDDIIIIDIIIDDDIDIIIDDDIDDDDDDIIIDDDIIDDIIDIDIIIDIDIDIIIDDIIIIIDIIIIIDDIDDIDDDDIDIIDDIDIIDDIIDDIDDIDDDIIIIDIDDIDDDIIDDDDDIIDDDDDDDIIIIIDDIDIDDDIIDDIDIDIIDDDDIIIDDIDDIIIIDDDDIIDIDDDDDDDIIIDIDDDIDIDIDIIIDIDDIDDDIIIDDDIDDDDIDIIIDIIIIDIDDIIDDIIDIIDIDDDIIDDDDDIIDIIDDDIIDDDIDDDDDIDIDDDIIIDDDDIDIIIDDDIIIDIDDIIIIIDIDIIDIDIDDIIDDDIIIIDIIDDDDDDIDIIIIIDIDIIIIIDDDIIDIDDIIIDIIDIDDIIIIDIDDIIIDDDIDDIIIDIDIIDIDDDIDDIDDDIIDIIIIIDDDDDIIIDIIIIDDIDIDIDIDDDIIDDIDIDDDDDDDIIDIIIDIDDIDIIIDDDDDIDIIDDDIIIDIIIIDIDDDIDDIIDIDIDIIDDIIIDIDIDDIDIDDDDIIIDIIDIIDIIIDDIDIIDDIIIIDIIIIDIIDIIIDDIIDIIIIDDIDIDDIDDDIDDIIDIIDIIIDIDIIDIIIDIDDDIDDIIDDDDIDDIIDIDDIIDIDIDIDDDDDIIIIDDDIIDDDDIIDDDDDDIIDDIIIIDDIIDIDIDDIDDDIDIIIDDDIDDDIIIDIDIIDIIIIDIDIDIDIIDIIID",
                743));

    }
    public ArrayList<Integer>  findPerm(final String A, int B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int start=0;
        int end=0;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < B; i++) {
            if(i < A.length() && A.charAt(i) == 'D'){
                start++;
            }
            num.add(i+1);
        }

        end= start-1;
        res.add(num.get(start++));

        for (int j = 0; j <A.length() ; j++) {
            if(A.charAt(j) == 'I'){
                res.add(num.get(start++));
            }else {
                res.add(num.get(end--));
            }
        }
        return res;
    }

    @Test
    public void hotel() {

        System.out.println(
                hotel(new ArrayList<Integer>(Arrays.asList(47, 4, 0, 12, 47, 31, 15, 49, 29, 33, 7, 22, 26, 24, 16)),
                        new ArrayList<Integer>(Arrays.asList( 95, 4, 26, 16, 51, 79, 43, 58, 32, 80, 30, 27, 29, 54, 16)),
                        10));

        System.out.println(
                hotel(new ArrayList<Integer>(Arrays.asList(1,2,3)),
                        new ArrayList<Integer>(Arrays.asList(2,3,4)),
                        1));
        System.out.println(
        hotel(new ArrayList<Integer>(Arrays.asList(1,3,7)),
                new ArrayList<Integer>(Arrays.asList(2,6,8)),
                1));

        System.out.println(
        hotel(new ArrayList<Integer>(Arrays.asList(1,2,3,4)),
                new ArrayList<Integer>(Arrays.asList(10,2,6,14)),
                2));
        System.out.println(
        hotel(new ArrayList<Integer>(Arrays.asList( 9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27)),
                new ArrayList<Integer>(Arrays.asList(32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38)),
                16));
    }

    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        Collections.sort(arrive, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(depart, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        int last=depart.get(depart.size()-1);
        int a=0;
        int d=0;
        int ctr=0;
       // System.out.println("weak");
        for (int i = 0; i < last; i++) {

            System.out.println(ctr+" "+i+" "+K+" "+a +" "+d);
            if(d!=depart.size() && depart.get(d)==i){
                d++;
                ctr--;
            }

            if(a!=arrive.size() && arrive.get(a)==i){
                if(ctr>=K)
                    return false;
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
        return  true;
    }

@Test
    public void maximumGap() {
        System.out.println(maximumGap(Arrays.asList(3,5,4,2)));
    System.out.println(maximumGap(Arrays.asList(100,100,100,100,100)));
    System.out.println(maximumGap(Arrays.asList(1)));
    System.out.println(maximumGap(Arrays.asList(3,5,2,10,4)));
    System.out.println(maximumGap(Arrays.asList( 69953237, 59183787, 16962742, 53647827, 80157178, 51106992, 58228227, 45131842, 70499719, 70765861, 43961028, 6698667, 99911553, 79107222, 67571988, 39721137, 78088316, 3759045, 19395856, 29387266, 68084358, 62564561, 24736359, 13212412, 66665326, 38724565, 61088241, 21263259, 89291805, 88650356, 58518225, 86449553, 78979492, 39596282, 43927666, 35451400, 80068197, 23391371, 25433080, 5888423, 67042527, 15586432, 57608751, 75903078, 95593533, 15702947, 39691466, 92690796, 18015358, 95172428, 72245309, 15424690, 41199673, 71322081, 27606512, 2347516, 1354382, 9924819, 63458285, 13170098, 40075662, 31237137, 45236128, 74375452, 92722404, 80087546, 23399482, 86945189, 3780890, 1963037, 76980637, 41676736, 74194802, 64788125, 88954508, 95737994, 21365859, 71092491, 67365387, 62345424, 77276892, 53193048, 30131824, 5365626, 66817225, 64511810, 46917019, 80497257, 20853093, 26175229, 85887940, 85764880, 78262084, 609284, 92269014, 46385693, 53718740, 17486900, 98427277, 92911988, 32225164, 72512163, 88678886, 65347756, 40460802, 33132933, 88603373, 26890724, 87077147, 99305881, 55925130, 83289365, 54166373, 50920143, 4427534, 29179799, 91572049, 95103705, 56304651, 69828935, 76914922, 33694020, 15575017, 77664401, 91393916, 96189668, 82107391, 95777779, 22244308, 65701218, 23227429, 98614556, 43407558, 67137144, 34515594, 89248417, 47520685, 14084016, 91725069, 94236666, 61860638, 82315091, 88113674, 31949150, 11718471, 51617813, 41754631, 15588021, 8130184, 52515921, 20663946, 70850137, 85578292, 93271926, 46273611, 27972346, 16865457, 94763722, 28780820, 52198047, 39535546, 9854737, 56888868, 82035778, 88667377, 71915993, 23061619, 71237088, 38215964, 99455111, 84338139, 9438659, 87387886, 35325804, 36964271, 40598041, 83828315, 30761279, 26893177, 19907874, 70129736, 62700567, 91806797, 11958671, 98578052, 8205009, 47197783, 53336153, 36819554, 47426225, 60695466, 55323353, 23435249, 16782401, 37928333, 19599390, 39797644, 9436396, 69658044, 45212110, 48265238, 14183162, 74865579, 58521415, 21894773, 65729368, 91458346, 39977875, 42236097, 12766362, 92049518, 13196912, 18064381, 89025324, 18154460, 77179251, 84814940, 3021813, 25547069, 65821055, 64653709, 94102131, 68518939, 46556175, 82058200, 80932197, 46454512, 62876026, 59675187, 4157064, 56677982, 76761579, 58446935, 51180436, 16416645, 65330136, 39435329, 81388109, 15522197, 78011106, 67617066, 34445170, 75555584, 87940550, 29128931, 61824105, 63418827, 21298249, 19352955, 91556471, 92675461, 888811, 61724633, 69153235, 83033789, 60689257, 54479401, 27546578, 66335535, 38378169, 6852142, 76001740, 64337900, 84778273, 7063943, 20469454, 8897942, 81095011, 89277538, 89473685, 13442135, 54332314, 99428305, 49227963, 1550084, 58626108, 3149845, 9592847, 63553909, 64442175, 52746464, 71731610, 68109474, 12014994, 28405025, 342244, 77415207, 6554496, 29199336, 24816541, 86021818, 93254912, 70091579, 24906579, 50431415, 92218181, 96921595, 70001355, 69278435, 48183386, 4909222, 9784895, 59239264, 82952057, 54807579, 85365017, 10747717, 36328910, 99503949, 25462804, 1948980, 54007615, 93059997, 96143890, 87526013, 36668467, 6585021, 59026699, 42437483, 49977217, 10735602, 29201394, 54519214, 94548380, 46479340, 50083557, 9899537, 43429844, 62002345, 57109791, 15539611, 37100828, 96624737, 58882555, 18287280, 73908899, 58094409, 31628808, 7279505, 87539497, 35968234, 73051936, 9182618, 6399914, 85644731, 13422910, 6027207, 40194013, 49063637, 47973273, 98583990, 4494264, 54221620, 99760871, 52094275, 44298611, 98771831, 39244836, 20234483, 63104483, 17667669, 77220658, 97536077, 67203516, 9567573, 96789571, 6954478, 9245869, 82742448, 72371341, 57459624, 25406080, 52099423, 49750024, 77497879, 16327199, 39571526, 14570597, 76246637, 93751329, 86339423, 97188050, 48457113, 52455837, 77244782, 81308324, 74575702, 31144906, 30685803, 21269958, 31958563, 20917120, 52658082, 33778983, 85532378, 6177062, 35138461, 27377273, 68310047, 27164914, 24236293, 90140894, 26903650, 31650250, 45975378, 10537609, 11918603, 92943222, 77479401, 42865540, 50885917, 57892395, 55161914, 82804155, 16502312, 25439804, 2105003, 52617639, 69471748, 48335908, 17352118, 36510341, 55222894, 6319593, 79662620, 37402118, 68949184, 48515926, 12224685, 8095432, 36227103, 37292769, 79979610, 78482598, 23728343, 26166144, 41593189, 44829841, 44241275, 43522523, 63777807, 3827324, 2683674, 3824814, 35307572, 1837804, 12651831, 24382914, 44014481, 16990793, 41894672, 33681016)));
    }
    public int maximumGap(final List<Integer> a) {
        int maxgap=-1;


      //  if(a.size()==1)
        //    return 0;

        for (int i = a.size()-1; i >=0 ; i--) {
            for (int j = 0, k=i; j <= k; j++,k--) {
               // System.out.println(i+" "+" "+ j +" "+ k+" "+maxgap);
                if(a.get(k)>= a.get(j)){
                    if( k-j >= maxgap){
                       // System.out.println("shit"+" i:"+i+" "+" j:"+ j +" k:"+ k +" "+maxgap);
                        maxgap= k-j;
                    }
                }
            }
        }


        for (int i = 0; i < a.size()-1 ; i++) {
            for (int j = a.size()-1, k=i; j >= k; j--,k++) {
                // System.out.println(i+" "+" "+ j +" "+ k+" "+maxgap);
                if(a.get(k)<= a.get(j)){
                    if( j-k >= maxgap){
                        // System.out.println("shit"+" i:"+i+" "+" j:"+ j +" k:"+ k +" "+maxgap);
                        maxgap= j-k;
                    }
                }
            }
        }
        return maxgap;
    }
    @Test
    public void repeatedNumberY() {

        double k =  (Math.sqrt(2) *   Math.sqrt(2)  *   Math.sqrt(3));
       double p =  (Math.sqrt(2)  *   Math.sqrt(2) *   Math.sqrt(3))/( Math.sqrt(2) *   Math.sqrt(2));
        System.out.println( Math.sqrt(3));
        System.out.println(p);
        //System.out.println( k / ( Math.sqrt(2) *   Math.sqrt(2)) +" "+ k % ( Math.sqrt(2) *   Math.sqrt(2)));
            System.out.println(repeatedNumberY(Arrays.asList(2,5,3,2,2)));
    }

    public int repeatedNumberY(final List<Integer> a) {

            HashMap<Integer,Integer> m = new HashMap();
            double multiple=1;
        for (int i = 0; i < a.size(); i++) {

           if (m.get(a.get(i))==null){
                m.put(a.get(i),1);
            }else{
                m.put(a.get(i),m.get(a.get(i))+1);

               if( m.get(a.get(i))==3)
                return m.get(a.get(i));
            }

        }
        System.out.println(m);

        return -1;
    }

    @Test
    public void repeatedNumberX() {
        System.out.println(repeatedNumberX(Arrays.asList(2,3,4,1,4,1)));
    }




    public int repeatedNumberX(final List<Integer> a) {
        double sum=0;
        for (int i = 0; i < a.size(); i++) {
            if(sum!=0) {
                double sumw = sum - Math.sqrt(a.get(i));

                //System.out.println(i+" "+ sum+" "+ sumw+" "+(sum + Math.sqrt(a.get(i))) +" "+ (sumw + 2 * (Math.sqrt(a.get(i)))));

                if (sum + Math.sqrt(a.get(i)) == sumw + 2 * (Math.sqrt(a.get(i)))) {
                    return a.get(i);
                }

            }

            sum += Math.sqrt(a.get(i));
        }

        return -1;
    }

    @Test
    public void largestNumber() {


        String a ="99799599398980975969969943923911910884880866838814785722694692689684674664657623599563515496494470444438437426400399379377369365363359358341329324302302250231230204176168161152143126124121113106";
        String b ="99799599398098975969969943923911910884880866838814785722694692689684674664657623599563515496494470444438437426400399379377369365363359358341329324302302250231230204176168161152143126124121113106";


        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!= b.charAt(i))
                System.out.println("wwwww"+ i + " "+a.charAt(i));

        }
        System.out.println(largestNumber(Arrays.asList(3, 305,340,0,98,9890, 3139, 5, 9)));
        System.out.println(largestNumber(Arrays.asList( 472, 663, 964, 722, 485, 852, 635, 4, 368, 676, 319, 412)));

        System.out.println(largestNumber(Arrays.asList( 12, 123)));
        System.out.println(largestNumber(Arrays.asList( 12, 121)));
        System.out.println(largestNumber(Arrays.asList( 8, 89)));
        System.out.println(largestNumber(Arrays.asList( 3, 30)));
        System.out.println(largestNumber(Arrays.asList(0, 0,0,0,1)));
    }

    public String largestNumber(final List<Integer> a) {
        StringBuilder res= new StringBuilder();
        ArrayList<Integer> b = new ArrayList<>(a);


        Collections.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1);
                String str2= String.valueOf(o2);
                return (str1+str2).compareTo(str2+str1);
            }
        });

        for (int i = a.size()-1; i >=0; i--) {
            res.append(a.get(i));
        }
        if(res.toString().matches("0+")){
            return new String("0");
        }
        return res.toString();


    }
    @Test
    public void firstMissingPositive() {


        ArrayList a = new ArrayList(Arrays.asList(1,3));
        a = new ArrayList(Arrays.asList(1,2,0));
       // a = new ArrayList(Arrays.asList(3,4,-1,1));
       // a = new ArrayList(Arrays.asList(-8, -7, -6));
      //  a = new ArrayList(Arrays.asList(417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327));
        System.out.println(firstMissingPositive(a));
    }


    public int firstMissingPositive(ArrayList<Integer> a) {


        int min=0;
        int max=0;

        HashSet<Integer> num = new HashSet();

        for (int i = 0; i < a.size(); i++) {
            if(a.get(i) >0){
                if(a.get(i) < min){
                    min=a.get(i);
                }

                num.add(a.get(i));
                if(a.get(i) > max){
                    max=a.get(i);
                }
            }
        }


        for (int i = min; i < max; i++) {
            if(!num.contains(i) && i!=0){
                return  i;
            }
        }
        return max+1;
    };

    @Test
    public void diagonal() {
        ArrayList p = new ArrayList();
        p.add(new ArrayList<>(Arrays.asList(1,2,3)));
        p.add(new ArrayList<>(Arrays.asList(4,5,6)));
        p.add(new ArrayList<>(Arrays.asList(7,8,9)));
        System.out.println(diagonal(p));
    }
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {

        ArrayList res = new ArrayList();
        for (int i = 0; i < a.size(); i++) {
                   ArrayList row = new ArrayList();
            for (int j = 0; j <= i; j++) {
                row.add(a.get(j).get(i-j));
              // System.out.println(a.get(j).get(i-j));

            }

            res.add(row);
        }


        for (int i = 1; i < a.size(); i++) {
            ArrayList row = new ArrayList();
            for (int j = a.size()-1; j >=i; j--) {
                //System.out.println(i+" "+j);

                row.add(0,a.get(j).get((a.size()-1)-j +i));
                //System.out.println(a.get(j).get((a.size()-1)-j +i));

            }

            res.add(row);
        }

        return res;
    }


    @Test
    public void generateMatrix() {
        System.out.println(generateMatrix(7));
    }
    public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            ArrayList r = new ArrayList<>();
            for (int j = 0; j < a; j++) {
                r.add(0);
            }
            result.add(r);
        }

        //int[] dir= new int[]{0,1,2,3};
        int dir=0;
        int l=0;
        int m = a-1;

        int rounds=0;
        int loc=-1;
        for (int i = 0; i < a*a -1; i++) {

            if(dir%m==0){
                dir=0;
                rounds++;
                loc++;

                if(loc==4)
                    loc =0;
            }


            if(rounds==5-l) {
                l++;
                rounds = 0;
                m-=l*2;
                System.out.println("reset rounds: "+ l + " "+ rounds+ " "+m);
            }



            System.out.println("rounds"+rounds);
                    System.out.println( loc+" "+dir+" "+m+" "+i+" "+l);

            /* top */
            if( loc== 0) {
                result.get(l).set(dir+l , i + 1);
            }

            if( loc== 1)
                result.get(dir+l).set(a-1-l,i+1);

            if( loc== 2)
                result.get(a-1-l).set(a-1-dir-l,i+1);

            if( loc== 3)
                result.get(a-1-l-(dir)).set(l,i+1);

            dir++;
            System.out.println(result);
        }

        return  result;
    }

    @Test
    public void generate() {
        System.out.println(generate(5));
    }


    public ArrayList<ArrayList<Integer>> generate(int a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(Arrays.asList(1)));
        for (int i = 1; i < a; i++) {
            int prev= result.size()-1;


            if(a==0)
                return result;

            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 0; j < result.get(prev).size()-1; j++) {
                int sum = result.get(prev).get(j) + result.get(prev).get(j + 1);
                row.add(sum);
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }

    @Test
    public void setZeroes() {
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        arrays.add(new ArrayList(Arrays.asList(1,1)));
        arrays.add(new ArrayList(Arrays.asList(1,0)));

        System.out.println(arrays+" "+arrays.size());
        setZeroes(arrays);
        System.out.println(arrays);


    }
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {

        boolean current=false;
        boolean previous = false;

        int rowSize=a.size();
        int colSize = a.get(0).size();


        for (int i = 0; i <= colSize; i++) {
            if(a.get(i).contains(0)){
                a.get(i).set(i,0);
            }
        }


        for (int i = 0; i <= rowSize; i++) {
            if(a.get(i).contains(0)){
                a.get(i).set(i,0);
            }
        }

    }

    @Test
    public void insert() {
        ArrayList<Interval> a = new ArrayList();
        a.add(new Interval(1,3));
        a.add(new Interval(6,9));

        System.out.println(insert(a,new Interval(2,5)));


        ArrayList<Interval> b = new ArrayList();
        b.add(new Interval(1,2));
        b.add(new Interval(3,5));
        b.add(new Interval(6,7));
        b.add(new Interval(8,10));
        b.add(new Interval(12,16));
        System.out.println(insert(b,new Interval(4,9)));

        ArrayList<Interval> c = new ArrayList();
        c.add(new Interval(1,2));
        c.add(new Interval(10,11));
        c.add(new Interval(12,15));
        System.out.println(insert(c,new Interval(4,13)));

        ArrayList<Interval> k = new ArrayList();
        k.add(new Interval(31935139, 38366404));
        k.add(new Interval(54099301, 76986474));
        k.add(new Interval(87248431, 94675146));
        System.out.println(insert(k,new Interval(43262807, 68844111)));


        ArrayList<Interval> d = new ArrayList();
        d.add(new Interval(1,2));
        d.add(new Interval(10,13));
        d.add(new Interval(15,18));
        d.add(new Interval(19,22));
        System.out.println(insert(d,new Interval(14,16)));

        ArrayList<Interval> e = new ArrayList();
        e.add(new Interval(1,2));
        e.add(new Interval(10,13));
        e.add(new Interval(15,18));
        System.out.println(insert(e,new Interval(16,21)));

        ArrayList<Interval> g = new ArrayList();
        g.add(new Interval(1,2));
        g.add(new Interval(10,13));
        g.add(new Interval(15,18));
        System.out.println(insert(e,new Interval(12,21)));

        ArrayList<Interval> h = new ArrayList();
        h.add(new Interval(3,5));
        h.add(new Interval(8,10));
        System.out.println(insert(h,new Interval(10,3)));


        ArrayList<Interval> f= new ArrayList();
        f.add(new Interval(1,2));
        f.add(new Interval(10,13));
        f.add(new Interval(15,18));
        System.out.println(insert(f,new Interval(19,21)));

        ArrayList<Interval> i= new ArrayList();
        i.add(new Interval(1,2));
        i.add(new Interval(10,13));
        i.add(new Interval(15,18));
        System.out.println(insert(f,new Interval(3,4)));



        ArrayList<Interval> j= new ArrayList();
        j.add(new Interval(1,2));
        j.add(new Interval(10,13));
        j.add(new Interval(15,18));
        j.add(new Interval(19,20));
        j.add(new Interval(21,22));
        System.out.println(insert(j,new Interval(14,17)));



        ArrayList<Interval> l= new ArrayList();
        l.add(new Interval(3,5));
        l.add(new Interval(8,10));
        System.out.println(insert(l,new Interval(1,12)));
        /**/


    }

    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

      @Override
      public String toString(){
          return "{"+start+ ","+ end+"}";
      }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res = new ArrayList<>();

        boolean merge=false;

        if(newInterval.start > newInterval.end){
            int temp =newInterval.start;
            newInterval.start=newInterval.end;
            newInterval.end=temp;
        }
        if(intervals.size()==0){
            res.add(newInterval);
            return res;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if(newInterval.start > intervals.get(i).end){
                res.add(intervals.get(i));
            }else if(newInterval.start >= intervals.get(i).start  && !merge){

                    Interval temp = new Interval( intervals.get(i).start, newInterval.end);
                    int j =i;
                    while(j+1 != intervals.size() && newInterval.end >= intervals.get(j+1).start){
                        j++;
                    }
                    temp.end = Math.max( newInterval.end ,intervals.get(j).end);

                    newInterval=temp;
                    res.add(temp);
                    merge=true;
            }else if(intervals.get(i).start > newInterval.end){
                if(!merge) {
                    res.add(newInterval);
                    merge=true;
                }
                res.add(intervals.get(i));
            }else if(newInterval.end  >= intervals.get(i).start && !merge){
               // if(newInterval.end <= intervals.get(i).end && !merge){

                    Interval tmp = new Interval( newInterval.start, newInterval.end);
                    int j =i;
                    while(j != intervals.size() &&  newInterval.end  >= intervals.get(i).end){
                        j++;
                    }

                    if(j == intervals.size())
                        continue;
                    tmp.end = Math.max( newInterval.end ,intervals.get(j).end);

                    newInterval=tmp;
                    res.add(tmp);
                    merge=true;
            }
            System.out.println("debug: intervals:"+ intervals+" res: "+ res + " interval:"+ intervals.get(i) +" newinterval:"+ newInterval);
        }

        /** special case outside the loop */
         if (merge==false && newInterval.end > intervals.get(intervals.size()-1).end){
            res.add(newInterval);
        }

        return res;
    }

    @Test
    public void getRow() {

        System.out.println(getRow(4));

    }

    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> prev=null;
        ArrayList<Integer> curr;
        int k =1;

        if(a ==0) {
            curr = new ArrayList<>();
            curr.add(k);
            return curr;
        }
        for (int i = 0; i < a; i++) {
            curr = new ArrayList<>();
            curr.add(k);
            for (int j = 0; prev!=null && j < prev.size()-1; j++) {
                curr.add(prev.get(j)+ prev.get(j+1));
            }
            curr.add(k);
            prev= curr;
        }

        return prev;
    }

    @Test
    public void maxset() {
        ArrayList a = Arrays.stream(new int[]{1, 2, 5, -7, 2, 3}).boxed().collect(Collectors.toCollection(ArrayList::new));
         a = Arrays.stream(new int[]{336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421  }).boxed().collect(Collectors.toCollection(ArrayList::new));

        System.out.println(maxset(a));
    }

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {

        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arrMax = arr;
        long sum=0;
        long maxSum=0;
        for (int i = 0; i < a.size(); i++) {

            if(a.get(i) >=0) {
                arr.add(a.get(i));
                sum += a.get(i);
            }else{
                    if (sum > maxSum) {
                        arrMax = arr;
                        maxSum = sum;
                    }
                    sum = 0;
                    arr = new ArrayList<>();
            }

        }

        if(arr.size() !=0){
            if(sum > maxSum){
                arrMax =arr;
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
            System.out.println(i + ": one:" + one + " zero:" + zero + " start:" + start + " end:" + end);
        }

        return res;
    }


    @Test
    public void repeatedNumber() {
        ArrayList a = Arrays.stream(new int[]{3, 1, 2, 5, 3}).boxed().collect(Collectors.toCollection(ArrayList::new));
        // a = Arrays.stream(new int[]{1,1,2}).boxed().collect(Collectors.toCollection(ArrayList::new));
        a = Arrays.stream(new int[]{389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260}).boxed().collect(Collectors.toCollection(ArrayList::new));
        //  a = Arrays.stream(new int[]{6,5,1,6,4,2,7,8}).boxed().collect(Collectors.toCollection(ArrayList::new));
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
        // System.out.println(sum.divide(gdc).subtract(orig.divide(gdc)) +" "+ Math.abs(noOrig-(noSum-dup)));


        return result;
    }

    public ArrayList<Integer> repeatedNumber2(final List<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeSet<Integer> ht = new TreeSet();

        for (int i = 0; i < a.size(); i++) {
            if (ht.contains(a.get(i)))
                result.add(a.get(i));
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
    public void plusOne() {
        ArrayList a = Arrays.stream(new int[]{9, 9, 9}).boxed().collect(Collectors.toCollection(ArrayList::new));


        System.out.println(plusOne(a));
    }

    @Test
    public void maxrray() {
        //System.out.println(maxSubArray(Arrays.asList(-2,1,-3,4,-1,2,1,-5,4)));

        System.out.println(maxSubArray4(Arrays.asList(-120, -202, -293, -60, -261, -67, 10, 82, -334, -393, -428, -182, -138,
                -167, -465, -347, -39, -51, -61, -491, -216, -36, -281, -361, -271, -368, -122, -114, -53, -488, -327, -182,
                -221, -381, -431, -161, -59, -494, -406, -298, -268, -425, -88, -320, -371, -5, 36, 89, -194, -140, -278,
                -65, -38, -144, -407, -235, -426, -219, 62, -299, 1, -454, -247, -146, 24, 2, -59, -389, -77, -19, -311,
                18, -442, -186, -334, 41, -84, 21, -100, 65, -491, 94, -346, -412, -371, 89, -56, -365, -249, -454, -226,
                -473, 91, -412, -30, -248, -36, -95, -395, -74, -432, 47, -259, -474, -409, -429, -215, -102, -63, 80, 65,
                63, -452, -462, -449, 87, -319, -156, -82, 30, -102, 68, -472, -463, -212, -267, -302, -471, -245, -165,
                43, -288, -379, -243, 35, -288, 62, 23, -444, -91, -24, -110, -28, -305, -81, -169, -348, -184, 79, -262, 13,
                -459, -345, 70, -24, -343, -308, -123, -310, -239, 83, -127, -482, -179, -11, -60, 35, -107, -389, -427, -210,
                -238, -184, 90, -211, -250, -147, -272, 43, -99, 87, -267, -270, -432, -272, -26, -327, -409, -353, -475, -210,
                -14, -145, -164, -300, -327, -138, -408, -421, -26, -375, -263, 7, -201, -22, -402, -241, 67, -334, -452, -367,
                -284, -95, -122, -444, -456, -152, 25, 21, 61, -320, -87, 98, 16, -124, -299, -415, -273, -200, -146, -437, -457,
                75, 84, -233, -54, -292, -319, -99, -28, -97, -435, -479, -255, -234, -447, -157, 82, -450, 86, -478, -58, 9, -500,
                -87, 29, -286, -378, -466, 88, -366, -425, -38, -134, -184, 32, -13, -263, -371, -246, 33, -41, -192, -14, -311, -478,
                -374, -186, -353, -334, -265, -169, -418, 63, 77, 77, -197, -211, -276, -190, -68, -184, -185, -235, -31, -465, -297, -277, -456, -181, -219, -329, 40, -341, -476, 28, -313, -78, -165, -310, -496, -450, -318,
                -483, -22, -84, 83, -185, -140, -62, -114, -141, -189, -395, -63, -359, 26, -318, 86, -449, -419, -2, 81, -326, -339, -56, -123, 10, -463, 41, -458, -409, -314, -125, -495, -256, -388, 75, 40, -37, -449, -485,
                -487, -376, -262, 57, -321, -364, -246, -330, -36, -473, -482, -94, -63, -414, -159, -200, -13, -405, -268, -455, -293, -298, -416, -222, -207, -473, -377, -167, 56, -488, -447, -206, -215, -176, 76, -304, -163,
                -28, -210, -18, -484, 45, 10, 79, -441, -197, -16, -145, -422, -124, 79, -464, -60, -214, -457, -400, -36, 47, 8, -151, -489, -327, 85, -297, -395, -258, -31, -56, -500, -61, -18, -474, -426, -162, -79, 25, -361,
                -88, -241, -225, -367, -440, -200, 38, -248, -429, -284, -23, 19, -220, -105, -81,
                -269, -488, -204, -28, -138, 39, -389, 40, -263, -297, -400, -158, -310, -270, -107, -336, -164, 36, 11, -192, -359, -136, -230, -410, -66, 67, -396, -146, -158, -264, -13,
                -15, -425, 58, -25, -241, 85, -82, -49, -150, -37, -493, -284, -107, 93, -183, -60, -261, -310, -380)));
        System.out.println(maxSubArray4(Arrays.asList(2, 6, 2, -1, 8, -9, 0, -3)));
        System.out.println(maxSubArray4(Arrays.asList(-500, 1, 2)));

        System.out.println(maxSubArray4(Arrays.asList(-89, -277, -475, -480, -420)));
    }


    Integer max = null;

    private int sum(final List<Integer> a) {

        if (a.size() == 0)
            return 0;
        if (a.size() == 1)
            return a.get(0);

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
        ArrayList arr = Arrays.stream(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}).boxed().collect(Collectors.toCollection(ArrayList::new));

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
                if (sum == 0)
                    sum = a.get(i);
                else
                    sum -= endPtr;
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
                continue; //dont even continue this loops waste to time
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

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int carry = 1;

        int j;
        for (j = 0; j < a.size(); j++) {
            if (a.get(j) != 0)
                break;
        }

        for (int i = a.size() - 1; i >= j; i--) {
            int val = a.get(i) + carry;
            a.set(i, val % 10);
            carry = val / 10;
        }


        if (carry != 0) {
            a.add(j, carry);
        }

        a = new ArrayList<>(a.subList(j, a.size()));

        return a;
    }

    @Test
    public void coverPoints() {


        ArrayList a = Arrays.stream(new int[]{4, 8, -7, -5, -13, 9, -7, 8}).boxed().collect(Collectors.toCollection(ArrayList::new));

        ArrayList b = Arrays.stream(new int[]{4, 8, -7, -5, -13, 9, -7, 8}).boxed().collect(Collectors.toCollection(ArrayList::new));


        System.out.println("pp" + coverPoints(a, b));
    }

    /**
     * (x,y) to
     * (x+1, y),
     * (x - 1, y),
     * (x, y+1),
     * (x, y-1),
     * (x-1, y-1),
     * (x+1,y+1),
     * (x-1,y+1),
     * (x+1,y-1)
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
     * 0,0
     * 1,1
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

    @Test
    public void isUnique() {

        String a = "abcdz";
        assertTrue(isUnique(a));

    }

    @Test
    public void isPermution() {

        isPermution("", "cda", "bc");

    }

    @Test
    public void spiral() {

        List a = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12),
                Arrays.asList(13, 14, 15, 16)
        );

        a = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(8, 9, 10)
        );


        a = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 5),
                Arrays.asList(5, 6, 7),
                Arrays.asList(8, 9, 10),
                Arrays.asList(11, 12, 13),
                Arrays.asList(14, 15, 16),
                Arrays.asList(17, 18, 19),
                Arrays.asList(20, 21, 22),
                Arrays.asList(23, 24, 25),
                Arrays.asList(26, 27, 28),
                Arrays.asList(29, 30, 31),
                Arrays.asList(32, 33, 34),
                Arrays.asList(35, 36, 37)
        );


        a = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(5),
                Arrays.asList(9),
                Arrays.asList(13)
        );
/*
        a = Arrays.asList(
                Arrays.asList(1,2)
        );

       a = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(5,6)
        );
/*
        a = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)
        );


        ArrayList b = new ArrayList();
        b.add(1);
        a = Arrays.asList(
                b
        );
/*
        a = Arrays.asList(
                Arrays.asList(1,2,3));


        a = Arrays.asList(
                Arrays.asList(11, 217, 223, 213, 178, 226, 166, 212, 121, 277, 188, 5, 56, 354, 6),
                Arrays.asList(69, 384, 201, 369, 72, 174, 320, 265, 61, 397, 152, 10, 385, 288, 23)
        );

                a = Arrays.asList(
                Arrays.asList(133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198),
                Arrays.asList(401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10),
                        Arrays.asList(112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126)
        );


        a = Arrays.asList(
                Arrays.asList(335, 401, 128, 384, 345, 275, 324, 139, 127, 343, 197, 177, 127, 72, 13, 59),
                Arrays.asList(102, 75, 151, 22, 291, 249, 380, 151, 85, 217, 246, 241, 204, 197, 227, 96),
                Arrays.asList(261, 163, 109, 372, 238, 98, 273, 20, 233, 138, 40, 246, 163, 191, 109, 237),
                Arrays.asList(179, 213, 214, 9, 309, 210, 319, 68, 400, 198, 323, 135, 14, 141, 15, 168)
        );

        /**/
        System.out.println(spiral(a));
    }

    private ArrayList spiral(List<List<Integer>> a) {
        ArrayList<Integer> result = new ArrayList();
        for (int x = 0, y = 0; x <= a.size() / 2 && y <= a.get(x).size() / 2; x++, y++) {
            //top
            int rowSize = a.size();
            int colSize = a.get(x).size();

            if (rowSize % 2 == 1 ? x <= rowSize / 2 : x < rowSize / 2) {
                for (int i = y; i < colSize - 1 - y; i++) {
                    result.add(a.get(x).get(i));
                }
            }

            if (colSize % 2 == 1 ? x <= colSize / 2 : x < colSize / 2) {
                for (int i = x; i < rowSize - x; i++) {
                    result.add(a.get(i).get(colSize - 1 - y));
                }
            }

            //bottom
            if (x < rowSize / 2)
                for (int i = colSize - 2 - y; i >= y; i--) {
                    result.add(a.get(rowSize - 1 - x).get(i));
                }

            if (y < colSize / 2)
                for (int i = rowSize - 2 - x; i >= x + 1; i--) {
                    result.add(a.get(i).get(y));
                }
        }

        return result;

    }

    private boolean isUnique(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                    return false;
            }
        }

        return true;
    }


    @Test
    public void rotateMatrx() {

        byte[][] b = new byte[][]{{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        System.out.println(b);
        System.out.println(rotateMatrix(b));
    }

    /**
     * 0,0 0,1 0,2
     * 1,0 1,1 1,2
     * 2,0 2,1 2,2
     * <p>
     * 2,0 1,0 0,0
     * 2,1 1,1 0,1
     * 2,2 1,2 0,2
     *
     * @param src
     */

    private byte[][] rotateMatrix(byte[][] src) {
        byte[][] img = new byte[src.length][src.length];

        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length; j++) {
                img[i][j] = src[src.length - 1 - j][i];
                System.out.print(img[i][j]);
            }
            System.out.print("\n");
        }
        return img;

    }


    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.print("\n");
        }
    }

    @Test
    public void zeroMatrix() {

        int[][] b = new int[][]{{1, 1, 2, 3}, {4, 0, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}};
        System.out.println(b);
        printMatrix(zeroMatrix(b));
    }


    /**
     * use arbitrary value except 0
     *
     * @param matrix
     * @return
     */
    private int[][] zeroMatrix(int[][] matrix) {
        final int arbitraryValue = -999;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[i][k] = arbitraryValue;
                        matrix[k][j] = arbitraryValue;
                    }
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == -999) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;

    }

    @Test
    public void compression() {
        System.out.println(compression("aaaaabbbbbcccc"));
    }

    private String compression(String c) {

        StringBuilder result = new StringBuilder();
        int ctr = 1;
        for (int i = 0; i < c.length(); i++) {
            if (i + 1 != c.length() && c.charAt(i + 1) == c.charAt(i)) {
                ctr++;
            } else {
                result.append(c.charAt(i - 1) + "" + ctr);
                ctr = 1;
            }
        }
        return result.toString();

    }

    @Test
    public void urlify() {
        urlify(new char[]{'t', ' ', 'h', 'e', ' ', 'b', ' ', ' ', ' ', ' '}, 6);
    }


    @Test
    public void editAway() {
        Assert.assertFalse(editAway("pale", "pled"));
        Assert.assertTrue(editAway("pales", "pale"));
        Assert.assertFalse(editAway("paless", "pale"));
        Assert.assertTrue(editAway("pale", "apale"));
        Assert.assertFalse(editAway("pale", "aapale"));
        Assert.assertTrue(editAway("pale", "bale"));
        Assert.assertFalse(editAway("pale", "bake"));
    }


    private boolean editAway(String a, String b) {

        int i = 0;
        int j = 0;
        int e = 0;


        System.out.println("---- " + a + " vs " + b + "----");
        while (true) {

            System.out.println(i + " " + j + " " + e + " ");

            if (e == 2)
                return false;

            if (i > a.length() - 1 || j > b.length() - 1) {
                if (Math.abs(a.length() - b.length()) >= 2) {
                    return false;
                }

                if (e == 1 && i != j && a.length() == b.length())
                    return false;
                else
                    return true;
            }

            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++; //if match
            } else if (a.charAt(i + 1) == b.charAt(j) && a.charAt(i + 2) == b.charAt(j + 1)) {
                i++;
                e++;  //insert
            } else if (a.charAt(i) == b.charAt(j + 1) && a.charAt(i + 1) == b.charAt(j + 2)) {
                j++;
                e++; //delete
            } else {
                i++; //replace
                j++;
                e++;
            }
        }

    }

    private void urlify(char a[], int len) {

        int index = a.length - 1;
        for (int i = len - 1; i > 0; i--) {
            if (a[i] == ' ') {
                a[index] = '0';
                a[index - 1] = '2';
                a[index - 2] = '%';
                index -= 3;
            } else {
                a[index] = a[i];
                index -= 1;
            }
        }
        System.out.println(a);

    }

    private void shift(char[] a, int n, int from) {
        for (int i = a.length - 1; i > from + n; i--) {
            a[i] = a[i - n];
        }

    }

    private void isPermution(String prefix, String str, String str2) {

        if (0 == str.length()) {
            System.out.println(prefix);
        } else {


            // abc
            // bac
            // bca
            for (int i = 0; i < str.length(); i++) {
                isPermution(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), str2);
            }

        }
    }

}
