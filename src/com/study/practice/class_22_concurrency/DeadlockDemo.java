package com.study.practice.class_22_concurrency;

public class DeadlockDemo{
  static class Friend{
    private final String name;
    public Friend(String name){
      this.name = name;
    }
    public String getName(){
      return this.name;
    }
    public synchronized void bow(Friend receiver){
      System.out.format("%s向%s鞠躬%n",this.name,receiver.getName());
      receiver.bowBack(this);
    }
    public synchronized void bowBack(Friend receiver){
      System.out.format("%s向%s鞠躬回敬%n",this.name,receiver.getName());
    }
  }
  public static void main(String[] args) throws InterruptedException {
    final Friend zhang = new Friend("张财主");
    final Friend li = new Friend("李财主");
    new Thread(new Runnable(){
      public void run(){
        zhang.bow(li);
      }
    }).start();
    Thread.sleep(10);
    new Thread(new Runnable(){
      public void run(){
        li.bow(zhang);
      }
    }).start();
  }
}
