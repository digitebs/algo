package sort;

public class MeetingPlanner {

    /*
        can use 2 pointer since they are sorted by start time.
        m + k
     */
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int i = 0;
        int j = 0;
        while(i < slotsA.length  && j < slotsB.length){
            int start = Math.max(slotsA[i][0], slotsB[j][0]);
            int end = Math.min(slotsA[i][1], slotsB[j][1]);

            if(start + dur <= end){
                return new int[]{start, start+dur};
            }else if(  slotsA[i][1] < slotsB[j][1]){
                i++;
            } else if(slotsA[i][1] == slotsB[j][1]){
                i++;
                j++;
            }else{
                j++;
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {

        meetingPlanner(new int[][]{
                {10,50},
                {50,120},
                {140,210}
        }, new int[][]{{0,15},{60,70}},8);

    }
}
