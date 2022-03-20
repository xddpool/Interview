package com.xiaoxiong.al;

import java.util.Scanner;

public class Od04 {
    public static void main(String[] args) {

        /*
        TLV编码是按 Tag Length  Value格式进行编码的
        一段码流中的信元用tag标识，tag在码流中唯一不重复
        length表示信元value的长度  value表示信元的值
        码流以某信元的tag开头 ，tag固定占一个字节
        length固定占两个字节，字节序为小端序
        现给定tlv格式编码的码流以及需要解码的信元tag
        请输出该信元的value

        输入码流的16机制字符中，不包括小写字母
        且要求输出的16进制字符串中也不要包含字符字母
        码流字符串的最大长度不超过50000个字节

        输入描述
           第一行为第一个字符串 ，表示待解码信元的tag
           输入第二行为一个字符串， 表示待解码的16进制码流
          字节之间用空格分割
        输出描述
           输出一个字符串，表示待解码信元以16进制表示的value

           例子：
           输入：
            31
            32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC

           输出
            32 33

           说明：
           需要解析的信源的tag是31
           从码流的起始处开始匹配，tag为32的信元长度为1(01 00,小端序表示为1)
           第二个信元的tag为90 其长度为2
           第三个信元的tag为30 其长度为3
           第四个信元的tag为31 其长度为2(02 00)
           所以返回长度后面的两个字节即可 为 32 33
         */

        Scanner in = new Scanner(System.in);
        // 1 想要获得信元值的 Tag
        String tag = in.nextLine();

        // 2 输入 TLV 编码
        String data = in.nextLine();

        // 3 将 TLV 编码以以空格切分存入 split
        String[] split = data.split("\\s+");

        // 4 遍历 右边界 为 split 长度, 遍历目的是寻找到匹配 tag i为当前所在 tag 的下标位置
        for (int i = 0; i < split.length; ) {

            // 5 求得当前 tag 所对应的 length 因为 length 占两个字节, 这个方法将 tag 后的两个字节传入 并且转换为 10 进制 求得长度
            int length = Integer.parseInt(split[i + 2] + split[i + 1], 16);

            // 6 判断当前 tag 是否与需要解码的 tag 相等
            if (tag.equals(split[i])) {
                // 相等则创建 可变字符序列
                StringBuilder stringBuilder = new StringBuilder();
                // 遍历 并且将 value 传入, 因为 tag + value 占用三个字节 所以从 value 所对应的下标位置开始进行遍历加入
                StringBuilder builder = new StringBuilder();
                for (int j = i + 3; j < i + 3 + length; j++) {
                    // 加入 bilder
                    builder.append(split[j]).append(" ");
                }
                // 打印输出 value 的原始值
                System.out.println();
                break;

                // 7 tag 不匹配则 将 i 移到 第二组 tag 起始的下标处
            } else {
                i += length + 3;
            }
        }

        in.close();

    }
}
