package com.xiaoxiong.al;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Od79 {
    /*
  某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
  现需要按照身高由低到高排列，
  对身高相同的人，按体重由轻到重排列，
  对于身高体重都相同的人，维持原有的编号顺序关系。
  请输出排列后的学生编号
  输入描述：
     两个序列，每个序列由N个正整数组成，(0<n<=100)。
     第一个序列中的数值代表身高，第二个序列中的数值代表体重，
  输出描述：
     排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
  实例一：
     输入:
      4
      100 100 120 130
      40 30 60 50
     输出:
      2134
  */
    static class Stu {
        int id;
        int h;
        int w;

        public Stu(int id, int h, int w) {
            this.id = id;
            this.h = h;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());//人数
        String[] h = in.nextLine().split(" ");//身高
        String[] w = in.nextLine().split(" ");//体重
        in.close();

        //遍历加入链表
        LinkedList<Stu> stus = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //遍历生成学生对象,将体重和身高转换成 Integer 类型方便比较大小
            Stu stu = new Stu(i + 1, Integer.parseInt(h[i]), Integer.parseInt(w[i]));
            stus.add(stu);
        }

        //进行自定义排序
        stus.sort(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {

                int result = o1.h == o2.h ? (o1.w - o2.w) : (o1.h - o2.h);

                return result;
//                return o1.h == o2.h ? (o1.w - o2.w) : o1.h - o2.h;
            }
        });
        StringBuilder builder = new StringBuilder();
        stus.forEach(x -> builder.append(x.id).append(" "));
        System.out.println(builder.substring(0, builder.length() - 1));
    }
}
