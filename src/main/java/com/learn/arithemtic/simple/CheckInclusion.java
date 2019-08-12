package com.learn.arithemtic.simple;

/**
 * @author jianggang
 * @Date 2019/4/18 15:47:24
 * @Description
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 *
 */
public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println((int)'a'+"---"+(int)'z');
    }

    public boolean checkInclusion(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int totalS1 = 0;
        for(char a : chars1){
            totalS1 += (int)a;
        }

        return false;
    }
}
