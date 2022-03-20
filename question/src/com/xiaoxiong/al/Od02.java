package com.xiaoxiong.al;

import java.util.ArrayList;
import java.util.Scanner;

public class Od02 {
    public static void main(String[] args) {
//        给定两个整数数组
        //array1 array2  数组元素按升序排列
        // 假设从arr1 arr2中分别取出一个元素，可构成一对元素
        // 现在需要取出k对元素，并对取出的所有元素求和
        // 计算和的最小值
        // 注意：两对元素对应arr1 arr2的下标是相同的
        //       视为同一对元素

        //输入描述
        //    输入两行数组arr1 arr2
        //    每行首个数字为数组大小size   0<size<=100
        //    arr1，2中的每个元素   0< <1000
        //    接下来一行  正整数k   0<k<=arr1.size * arr2.size
        // 输出描述
        //   满足要求的最小值

        // 例子

        //输入
        //   3 1 1 2
        //   3 1 2 3
        //   2

        //输出
        //   4

        //说明：用例中需要取两个元素，
        // 取第一个数组第0个元素与第二个数组第0个元素组成一个元素
        // [1,1]
        //取第一个数组第1个元素与第二个数组第0个元素组成一个元素
        // [1,1]

        //求和为1+1+1+1=4 ,满足要求最小

        Scanner in = new Scanner(System.in);

        int[] arr1 = getArray(in.nextLine());
        int[] arr2 = getArray(in.nextLine());
        int k = in.nextInt();

        /**
         * 思路整理：
         *  1. 两个数组接受到输入之后 将两个 数组元素 的 两两之和 通过 两层for 遍历增加到 链表之中(这里使用ArrayList的目的是不用想长度)
         *  2. new一个 Integer 类型的新数组 长度为 ArrayList 的长度, 将
         */
        int sum = 0;

        // 1
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr1) {
            for (int j : arr2) {
                list.add(i + j);
            }
        }

        list.sort((o1, o2) -> (o1 - o2));

        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }


        // 2
//        Integer[] res = new Integer[list.size()];
//        list.toArray(res);
//        Arrays.sort(res);
//
//        for (int i = 0; i < k; i++) {
//            sum += res[i];
//        }
        System.out.println(sum);

        in.close();

    }

    // 这是将输入的要求形式转换成数组的方法
    private static int[] getArray(String line1) {
        // 通过正则表达式 \s+ 将空格分离得到输入的每一个数字
        String[] split1 = line1.split("\\s+");

        // 以字符数组 split1 第一个下标的数字为长度创建数组
        int[] arr1 = new int[Integer.parseInt(split1[0])];

        // 排除第一个输入的第一个数字，将剩余的元素存入 arr1
        // 因为通过输入创建的 split1 总是比真正要去取数字的数组长度大 1
        // 但是要求是不需要 split1 0下标指向的元素
        // 所以 边界从 i = 1 开始， 遍历 split1.length-1 次将 split1 中的元素 从 arr1 的 0 下标 开始传入
        for (int i = 1; i < split1.length; i++) {
            arr1[i - 1] = Integer.parseInt(split1[i]);
        }

        return arr1;
    }
}

