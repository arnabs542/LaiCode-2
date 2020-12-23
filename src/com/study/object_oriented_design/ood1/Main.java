package com.study.object_oriented_design.ood1;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Manager("Joe", "1103", 19750202, 3);
        Employee e2 = new Engineer("Mary", "2105", 19800420, 2);
        e1.calculateSalary(0.95);
        e2.calculateSalary(0.85);

        // 如果公司class有个一个 getAllEmployees的方法。
//        for (Employee e : this.getAllEmployees()) {
//            salaryList.add(e.calculateSalary(...));
//        }
    }
}
