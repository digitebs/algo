package runnable;

class FooBar {
  private int n;

  boolean temp;
  public FooBar(int n) {
    this.n = n;
  }

  public synchronized void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      if(temp){
        wait();
      }
      printFoo.run();
      temp = true;
      notify();
    }
  }

  public synchronized void bar(Runnable printBar) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      if(!temp){
        wait();
      }
      printBar.run();
      temp = false;
      notify();
    }
  }
}