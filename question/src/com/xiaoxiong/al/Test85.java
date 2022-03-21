package com.xiaoxiong.al;

import java.util.Scanner;

/**
 * 万物皆对象
 */
public class Test85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        // 1. 将输入的字符串按照格式存入数组
        String[] split = s.split(" ");

        /**
         * 需求分析
         * 剪贴板; 被选择的字母; 全选之后清空面板; 新的复制内容会覆盖其他内容
         *
         * 剪贴板: tab
         * 被选择的字母: choose
         * 清空的方法: reset
         * 覆盖原有内容使用 替换
         */

        //使用 StingBuilder 代替文档存储内容
        StringBuilder stringBuilder = new StringBuilder();
        //被选择的内容
        String choose = "";
        String tab = "";

        // 2. 将传入的操作数字遍历取出并且 使用 switch 命令对操作进行识别
        for (String op : split) {
            switch (op) {
                // 输入 A
                case "1":
                    // 当有 5操作 在之前执行时 需要清空文档内容
                    if (!choose.isEmpty()) {
                        stringBuilder.replace(0, stringBuilder.length(), "");
                        choose = "";
                    }
                    stringBuilder.append("A");
                    break;
                //复制
                case "2":
                    // 将当前所选内容复制到剪贴板; 获取所选内容
                    if (!choose.isEmpty()) {
                        tab = "";
                        tab = choose;
                        choose = "";
                    }
                    break;
                //剪切
                case "3":
                    if (!choose.isEmpty()) {
                        tab = "";
                        tab = choose;
                        choose = "";
                        stringBuilder.replace(0, stringBuilder.length(), "");
                    }
                    break;
                //粘贴
                case "4":
                    stringBuilder.append(tab);
                    tab = "";
                    choose = "";
                    break;
                //全选
                case "5":
                    // 全选内容被记录
                    String s1 = stringBuilder.toString();
                    choose = s1;
                    break;
            }
            System.out.println(stringBuilder.toString());
        }
        System.out.println(stringBuilder.length());
    }
}
