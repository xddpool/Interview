package com.xiaoxiong.al;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Od73 {
    /*

   给出一个只包含字母的字符串,
   不包含空格,统计字符串中各个子字母(区分大小写)出现的次数,
   并按照字母出现次数从大到小的顺序输出各个字母及其出现次数
   如果次数相同,按照自然顺序排序,且小写字母在大写字母之前

   输入描述:
     输入一行仅包含字母的字符串

   输出描述:
     按照字母出现次数从大到小的顺序输出各个字母和字母次数,
     用英文分号分割,
     注意末尾的分号
     字母和次数中间用英文冒号分隔
     需要拼接变量 字母 冒号: 字母个数 分号
   示例:
       输入: xyxyXX
       输出:x:2;y:2;X:2;
   说明:每个字符出现的次数为2 故x排在y之前
   而小写字母x在大写X之前

   示例2:
       输入:
        abababb
       输出:
           b:4;a:3
       说明:b的出现个数比a多 故排在a前
    */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        in.close();

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // a-z 97-122
        print(map.entrySet().stream().filter(e -> e.getKey() >= 'a'));
        // A-Z 65-90
        //需求是大写字母摆在后面 所以后输出大写字母数量
        print(map.entrySet().stream().filter(e -> e.getKey() <= 'Z'));

    }

    private static void print(Stream<Map.Entry<Character, Integer>> stream) {
        List<Map.Entry<Character, Integer>> list = stream
                .sorted(new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        int v1 = o1.getValue();
                        char k1 = o1.getKey();
                        int v2 = o2.getValue();
                        char k2 = o2.getKey();
                        if (v1 != v2) {
                            //不相等输出value大的字母先
                            return v2 - v1;
                        } else {
                            //相等则判断字母的大小(先后)
                            return k1 - k2;
                        }
                    }
                }).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            builder.append(entry.getKey()).append(":")
                    .append(entry.getValue()).append(";");
        }

        System.out.print(builder);
    }
}
