package com.learn.arithemtic.simple;

/**
 * @author jianggang
 * @Date 2019/3/15 17:45:34
 * @Description
 */
public class IsInterleave {

    public static void main(String[] args) {
        solution("aabcc","dbbca","aadbbcbcac");
    }

    public static boolean solution(String s1, String s2, String s3){
        for(int i = 0 ; i < s3.length() ; i++){
            String temp = s3.substring(0,i);
            if(temp.equals(s1.substring(0,i))){

            }
        }
        return true;
    }
}
