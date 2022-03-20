package com.xiaoxiong.al;

import java.util.Scanner;

public class Od03 {
    public static void main(String[] args) {
           /*
        给出n阶方阵里所有数
        求方阵里所有数的和
        输入描述：
          输入有多个测试用例
          每个测试用例第一个第一个整数n   n<=1000 表示方阵阶数为n
          接下来是n行的数字，每行n个数字用空格隔开
        输出描述：
          输出一个整数表示n阶方阵的和
        例子：
          输入
              3
              1 2 3
              2 1 3
              3 2 1
          输出
              18
         */


        /**
         * 思路
         * 1. 按照要求输入方阵大小, 主要思路就是一排一排计算接受一排数据就计算一排的和
         * 2. 遍历接受输入数据 外层使用 nextLine().split 方式进行接受 并且存入 split[] 数组 回车即完成一层循环添加
         * 3. 将数据转为Int 并且 与sum逐个相加 最终得到答案
         * 4.关流
         */
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] split = in.nextLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                sum += Integer.parseInt(split[j]);
            }
        }
        System.out.println(sum);

        in.close();
    }
}
