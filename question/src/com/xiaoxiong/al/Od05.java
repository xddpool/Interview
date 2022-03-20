package com.xiaoxiong.al;

import java.util.Scanner;

public class Od05 {
    public static void main(String[] args) {
        /*
         一天一只顽猴想要从山脚爬到山顶
          途中经过一个有n个台阶的阶梯，但是这个猴子有个习惯，每一次只跳1步或3步
          试问？猴子通过这个阶梯有多少种不同的跳跃方式

          输入描述：
            输入只有一个这个数n    0<n<50
            此阶梯有多个台阶
          输出描述：
            有多少种跳跃方式

          实例:
           输入
             50
           输出
              122106097

           输入
              3
           输出
              2
         */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int f1 = 1;
        int f2 = 1;
        int f3 = 2;
        int top = 0;
        if (n < 3) {
            System.out.println(f2);
        } else if (n == 3) {
            System.out.println(f3);
        } else {
            for (int i = 4; i <= n; i++) {
                top = f3 + f1;
                f1 = f2;
                f2 = f3;
                f3 = top;
            }

            System.out.println(top);
        }


        in.close();

    }
}
