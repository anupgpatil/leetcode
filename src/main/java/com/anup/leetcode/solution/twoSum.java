package com.anup.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Source: https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Constraints
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */

public class twoSum {
    public int[] bruteForce(int[] nums, int target) {
        int[] result = new int[]{};
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) { //fixing one element and iterating the rest
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result = new int[]{nums[i], nums[j]};
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return result;
    }

    public int[] hashMap(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (integerMap.containsKey(difference)) {
                return new int[]{integerMap.get(difference), i};
            }
            integerMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        twoSum ts = new twoSum();
        int[] q = new int[]{3, 2, 4, 5, 8, 9, 11};
        int target = 9;
        System.out.println("======= Brute Force =======");
        int[] result = ts.bruteForce(q, target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println("");
        System.out.println("=======Revised Solution=======");
        int[] result2 = ts.hashMap(q, target);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(q[result2[i]]);
        }
    }
}
