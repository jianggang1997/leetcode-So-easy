package com.learn.arithemtic.math;

/**
 * @author jianggang
 * @Date 2019/6/5 16:40:02
 * @Description  递归解法
 *
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。要求时间复杂度 O(N)，空间复杂度 O(1)。
 *
 * Input:
 * {2, 3, 1, 0, 2, 5}
 *
 * Output:
 * 2
 */
public class Duplicate {

    public static int duplicateNum = -1;

    public static void main(String[] args) {
        int[] nums  = new int[]{1, 1};
        System.out.println(solution(nums));
        System.out.println("duplicate Number is:" + duplicateNum);
    }

    public static boolean solution(int[] nums){
        if(nums == null || nums.length <= 0) {
            return false;
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                boolean reset = reset(nums, i, nums[i]);
                if(reset){
                    return true;
                }else {
                    continue;
                }
            }
        }
        return false;
    }


    public static boolean reset(int[] nums, int i, int j) {
        if(nums[i] == nums[j]){
            duplicateNum = nums[i];
            return true;
        }
        swap(nums,i,j);
        if(nums[j] != i) {
            reset(nums,i,nums[i]);
        }
        return false;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
