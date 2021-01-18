package com.study.algorithms.class18_cross_training_1.LCA;

public class LCA_WithRestriction {
  // 内存1GB，Tree 32GB，找LCA
  // 需要divide and conquer
  // 这种题只需要在概念上解决，是problem-solving题目

  // 举例：
  //  先Load前5层（一个很小的范围）：
  //    如果ab已经在了前5层里，那么就直接在这里解决即可。
  //    如果a在前5层里，细分5层以下的nodes为32个subtree，M1 - M32, 在每个subtree里找b
  //                 举例，如果M4告诉我b在这，那就用它的root和a找LCA。
  //    如果b在前5层里，同理。
  //    如果a和b都不在这个小尖尖里面：每个Mi里面做LCA
  //                  随后，再根据Mi的返回值，在小尖尖处理：
  //                          如果只有一个Mi有非空返回值，就传递；
  //                          如果Mi，Mj分别返回a、b，则在小尖尖做LCA

}
