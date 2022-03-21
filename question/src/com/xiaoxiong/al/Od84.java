package com.xiaoxiong.al;

import java.util.Arrays;
import java.util.Scanner;

public class Od84 {
    /*
  小组中每位都有一张卡片
  卡片是6位以内的正整数
  将卡片连起来可以组成多种数字
  计算组成的最大数字

  输入描述：
    ","分割的多个正整数字符串
    不需要考虑非数字异常情况
    小组种最多25个人

   输出描述：
     最大数字字符串

   示例一
     输入
      22,221
     输出
      22221

    示例二
      输入
        4589,101,41425,9999
      输出
        9999458941425101
   */
    public static void main(String[] args) {
        /**
         * 六个字符串
         * 长度不等
         * 输出最大的组合
         * 通过第一个字符进行排序,相等则对第二个字符进行同样操作
         * 从大到小进行组合
         */

        Scanner sc = new Scanner(System.in);
        //接收所有的卡片
        String cards = sc.nextLine();
        sc.close();
        //将每个卡片存入字符串数组
        String[] card = cards.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(card).sorted((o1, o2) -> {
            int o1l = o1.length();
            int o2l = o2.length();

            if (o1l == o2l) {
                return o2.compareTo(o1);
            } else {
                int min = Math.min(o1l, o2l);
                o1.substring(0, min);
                o2.substring(0, min);
                return o2.compareTo(o1);
            }
        }).forEach(s -> stringBuilder.append(s));


        System.out.println(stringBuilder);
    }
}
