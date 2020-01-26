package search;

import java.util.HashMap;

/*

ith vote for
persons and times

Input: ["TopVotedCandidate","q","q","q","q","q","q"],
    [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation:
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
 */
public class TopVoteCandidate {
    class TopVotedCandidate {
         int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length -1;
            int mid = (left + right)/2;
            while(left <= right){
                if(arr[mid] == target) return mid;
                if(mid-1 < 0) return 0;
                if(mid+1 >= arr.length) return arr.length-1;
                if(arr[mid-1] <= target &&target < arr[mid]){
                    return mid-1;
                }else if(arr[mid+1] > target &&target >= arr[mid]){
                    return mid;
                }else if(target < arr[mid] ){
                    right = mid -1;
                }else{
                    left = mid +1;
                }
                mid = (left + right)/2;
            }
            return -1;
        }

        int[] times;

        HashMap<Integer,Integer> hm = new HashMap<>(); //leading at time
        HashMap<Integer,Integer> hm1 = new HashMap<>(); // count
        public TopVotedCandidate(int[] persons, int[] times) {

            int person = -1;
            int max=0; //maxcount
            for(int i = 0; i < persons.length;i++){
                hm1.put(persons[i], hm1.getOrDefault(persons[i],0)+1);
                if(max <= hm1.get(persons[i])){
                    max = hm1.get(persons[i]);
                    person = persons[i];
                }
                //max = Math.max(max,hm1.get(persons[i]));
                hm.put(i,person); // at time 5 leading
            }
            this.times = times;
        }

        public int q(int t) {
            int i = binarySearch(times,t);
            //  System.out.println(t +" "+i);
            return hm.get(i);
        }
    }

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
}
