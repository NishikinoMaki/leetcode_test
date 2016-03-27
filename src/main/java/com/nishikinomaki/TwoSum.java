package com.nishikinomaki;

/**
 * Created by nishikinomaki on 16/3/28.
 *
 * link: https://leetcode.com/problems/two-sum/
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution.
 Example:
 Given nums = [2, 7, 11, 15], target = 9,
 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 UPDATE (2016/2/13):
 The return format had been changed to zero-based indices. Please read the above updated description carefully.
 返回数组的索引是从0开始的
 */
public class TwoSum {

    /**
     * o(n^2) 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int begin = 0;
        int end = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    begin = i;
                    end = j;
                    break;
                }
            }
        }
        return new int[]{begin, end};
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;
        int[] nums = new int[]{3, 2, 4};
        int target = 6;



        TwoSum twoSum = new TwoSum();

        int[] format = twoSum.twoSum(nums, target);
        System.out.println(format[0]);
        System.out.println(format[1]);
    }
}
