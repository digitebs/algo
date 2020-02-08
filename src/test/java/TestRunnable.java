import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

/** Created by johnlim on 10/2/16. */
public class TestRunnable {
  static class T implements Runnable {
    ReentrantLock l = new ReentrantLock();;

    T() {
      //  l.lock();
    }

    @Override
    public void run() {
      l.lock();
      try {
        for (int i = 0; i < 100; i++)
          System.out.println(Thread.currentThread().getName() + " " + l.getHoldCount());
      } finally {
        l.unlock();
      }
    }
  }

  public static void main(String args[]) {

    T l = new T();
    // l.lock();
    Thread t1 = new Thread(l);
    Thread t2 = new Thread(l);

    t1.start();
    t2.start();
  }
}
