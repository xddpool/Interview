package com.xiaoxiong.al;

import java.util.Scanner;

public class OdOne {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;

        try {
            int n = in.nextInt();
            int m = in.nextInt();

            for (int i = n; i < m; i++) {
                for (int j = n + 1; j < m; j++) {
                    for (int k = n + 2; k < m; k++) {
                        if (i < j && j < k
                                && k * k == i * i + j * j
                                && huzhi(i, j) == 1
                                && huzhi(j, k) == 1
                                && huzhi(i, k) == 1) {
                            System.out.println(i + " " + j + " " + k);
                            count++;
                        }
                    }
                }
            }

        } catch (Exception e) {

        } finally {
            if (count == 0) {
                System.out.println("Na");
            }
            in.close();
        }

    }

    // 欧几里得算法
    private static int huzhi(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        if (a % b == 0) { //假设a % b = r 如果取得余数为0，b就是两数的最大公约数
            return b;
        } else {
            return huzhi(b, a % b);//不是0则用除数 b 模 r 直到 r = 0 结束 （递归）
        }
    }
}


