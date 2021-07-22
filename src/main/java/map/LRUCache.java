package map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author john.lim
 */
class LRUCache {

    HashMap<Integer,Integer> hm = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();
    int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!hm.containsKey(key))return -1;
        q.remove(key);
        q.offer(key);
        return hm.get(key);
    }

    public void put(int key, int value) {


        q.remove(key);
        q.offer(key);
        hm.put(key,value);

        if(q.size() > capacity){
            hm.remove( q.poll());
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
