package queue;

import org.apache.commons.collections.buffer.CircularFifoBuffer;
import org.junit.*;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by johnlim on 1/3/17.
 */
public class CircularBuffer {

    @Test
    public void circularBuffer(){
        ArrayDeque<Integer> buffer = new ArrayDeque<Integer>(100);
        for(int i =1; i <= 100;i++){
            buffer.offer(i);
        }
       while(buffer.size()>1){
            buffer.add( buffer.poll());
           buffer.poll();
            System.out.println(buffer);
        }
    }

}