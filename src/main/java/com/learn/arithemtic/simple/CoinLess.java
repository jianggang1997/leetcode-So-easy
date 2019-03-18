package com.learn.arithemtic.simple;

import java.util.Scanner;

/**
 * @author jianggang
 * @Date 2019/3/16 10:04:48
 * @Description
 *
 *
 */
public class CoinLess {

    public static double res = 0;

    public static void main(String[] args) {
        int total = 1024;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = (total - n);
        solution(b);
        System.out.print((int)res);
    }

    public static void solution(double a){
        if(a == 0){
            return;
        }
        for(int i = 3 ; i >=0 ; i--){
            double temp = Math.pow(4,i);
            if(a >= temp){
                res = res + (int)(a/temp);
                solution(a%temp);
                break;
            }
        }
    }

}
