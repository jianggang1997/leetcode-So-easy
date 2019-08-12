package com.learn.arithemtic.math;

/**
 * @author jianggang
 * @Date 2019/6/6 11:39:14
 * @Description
 */
public class FindMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                    {1,   4,  7, 11, 15},
                    {2,   5,  8, 12, 19},
                    {3,   6,  9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
                };
        System.out.println(find(18,matrix));
    }

    public static boolean find(int target, int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j<matrix[i].length-1; j++) {
                if(matrix[i][j] == target||matrix[i][j+1] == target){
                    return true;
                }
                if(target < matrix[i][j+1]){
                    if(i+1 < matrix.length){
                        i = i+1;
                    }
                }
            }
        }
        return false;
    }

}
