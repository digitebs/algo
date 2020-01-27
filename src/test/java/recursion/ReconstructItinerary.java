package recursion;

import java.util.*;


/*

Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 reconstruct the itinerary in order.
 All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 */
public class ReconstructItinerary {

    // dfs
    List<String> res = new ArrayList<>();
    public boolean recurse(String s, HashMap<String,ArrayList<String>> hm, int N){
        //     System.out.println(hm+" "+res);
        if(res.size() == N) return true;
        ArrayList<String> arr = hm.get(s);
        if(arr==null || arr.isEmpty()){
            return false;
        }
        for(int i =0; i < arr.size(); i++){
            String tmp = arr.get(i);
            res.add(tmp);
            arr.remove(i);
            if(recurse(tmp,hm,N)) return true;
            res.remove(res.size()-1); //back track
            arr.add(i,tmp); //backtrack
        }
        return false;

    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,ArrayList<String>> hm = new HashMap<>();
        for(int i = 0; i < tickets.size(); i++){
            String key = tickets.get(i).get(0);
            if(!hm.containsKey(key)){
                hm.put(key,new ArrayList<>());
            }
            ArrayList<String> ts = hm.get(key);
            ts.add(tickets.get(i).get(1));

            hm.put(key, ts);
        }
        for(List<String> ticket: hm.values()){
            Collections.sort(ticket);
        }
        res.add("JFK");
        recurse("JFK",hm,tickets.size()+1);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary()
                .findItinerary(new ArrayList<>(Arrays.asList(
                        Arrays.asList("MUC","LHR"),
                        Arrays.asList("JFK","MUC"),
                        Arrays.asList("SFO","SJC"),
                        Arrays.asList("LHR","SFO")
                        )
                    )
                ));
    }
}
