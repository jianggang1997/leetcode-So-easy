package com.learn.arithemtic.math;

/**
 *
 * @author jianggang
 * @Date 2019/6/4 13:49:53
 * @Description  素数相关算法
 */
public class Primes {


    public static int countPrimes(int num){

        boolean[] notPrimes = new boolean[num+1];

        int count = 0;

        for(int i = 2; i < num ; i++) {
            if(notPrimes[i]) {
                continue;
            }
            count ++;
            System.out.print(i + "\t");
            System.out.println();
            for(long j = (long)(i) * i; j < num; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("一共有素数："+countPrimes(10)+" 个");
    }

}
