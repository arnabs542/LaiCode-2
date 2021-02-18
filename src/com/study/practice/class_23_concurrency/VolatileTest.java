package com.study.practice.class_23_concurrency;

// volatile use case 1

// 1. while里面有print的时候，不用volatile，也可以顺利停止newThread
// 2. while里面没有print的时候，不用volatile，则不能停止newThread
// 3. 加上volatile后恢复。

/*newThread先会读一次memory里的值，存到cache（这会儿是true）
  main thread修改的flag，也是在cache。就算写回memory，newThread也是读自己的cache而不是重新读memory。
  如果有个print，那就是做了IO。IO的时候CPU会把thread的cache换出到memory，过一会儿才会重新从memory读。所以加了IO就可以读到正确的值。
  没有print，没有IO。这个thread就是在自己的cache里面读。

  加上volatile后，修改了需要write back而不是改cache就行了，读取需要从memory获取而不是直接读cache。
  所以read和write之间不会出现data race - 因为相当于加了个小锁
*/

public class VolatileTest {
  public static boolean flag = false;
  public static class MyRunnable implements Runnable {
    @Override
    public void run() {
      while (!flag) {
        System.out.println("The thread is running..."); // Imagine what will happen if I comment this line out!
      }
      System.out.println("The thread is finished...");
    }
  }
  public static void main(String[] args) throws InterruptedException {
    Thread newThread = new Thread(new MyRunnable());
    newThread.start();
    Thread.sleep(1000);
    flag = true;
    System.out.println("Main thread is finished...");
  }
}

