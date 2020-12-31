package com.study.object_oriented_design.ood1;

abstract public class Employee { // 有public API，所以要public class
  private final String name;
  private final String id;
  // private int age;   // 应该是记录一个private final birthData,
  private final int birthDate;
  private int salary;
  protected int level; // 继承的要用

  public Employee(String name, String id, int birthDate, int level) {
    this.name = name;
    this.id = id;
    this.birthDate = birthDate;
    this.level = level;
  }

  public void printInfo() {
    System.out.println("Name: " + name + "; Age: " + birthDate + "; ID: " + id);
  }

  abstract public int calculateSalary(double performanceScore);
  // calculate salary based on the employee's level and performance score
  // assign the value to this.salary

  abstract protected int getBaseSalary(int level);

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public int getBirthDate() {
    return birthDate;
  }

  public int getSalary() {
    return salary;
  }

  public int getLevel() {
    return level;
  }

//    public void setAge(int age) {
//        this.age = age;
//    }
//    不好，不应该暴露一个接口。age的改变应该是“当前时间” - “出生时间”
//    这个setter功能太强了。
//    应该是记录一个private final birthData,
}
