package com.study.object_oriented_design.ood1;

public class Manager extends Employee {
  public Manager(String name, String id, int birthDate, int level) {
    super(name, id, birthDate, level);
  }

  @Override
  public int calculateSalary(double performanceScore) {
    return (int) (getBaseSalary(level) * (1 + 0.25 * performanceScore));
  }

  @Override
  protected int getBaseSalary(int level) {
    return 12000;
  }
}


