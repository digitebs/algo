package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * implementaion of heap using integer, its a binary tree where the top node is the snallest
 */
public class Heap {
    LinkedList<Integer> heap = new LinkedList<>();

    int left(int idx){
        return 2 *idx + 1;
    }
    int right(int idx){
        return 2 *idx + 2;
    }

    int parent(int idx){
        return (idx - 1)/2;
    }


    void heapifyDown(int i){

        int l = left(i);
        int r = right(i);

        if(l >= heap.size()) return;

        if(r >= heap.size() || heap.get(l) > heap.get(r)){
            Collections.swap(heap,l,i);
            heapifyDown(l);
        }else {
            Collections.swap(heap,r,i);
            heapifyDown(r);
        }
    }
    void heapifyUp(int c){
        if(c <= 0) return;

        int p = parent(c); //got o teh bottom
        if(heap.get(p) > heap.get(c)){
            Collections.swap(heap,c,p);
            heapifyUp(p); // recrusrively swap whileits greater
        }
    }

    void delete(int v){
        for(int i =0;i < heap.size(); i++){
            if(heap.get(i) == v){
                heap.set(i,heap.getLast());
                heap.removeLast();
                break;
            }
        }

        heapifyDown(0);
    }
    void insert(int v){
        heap.add(v);
        heapifyUp(heap.size());
    }
    public static void main(String[] args) {

    }
}
