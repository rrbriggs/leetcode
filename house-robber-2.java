// 213. House Robber II
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

// Example 1:

// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
// Example 2:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 3:

// Input: nums = [1,2,3]
// Output: 3

import java.util.Arrays;
class Solution {
    public int rob(int[] nums) {
        
        // handle edges
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // get the max of the array for omitting first and last, whoever wins the duel is our answer
        int ans = Math.max(solveRob(Arrays.copyOfRange(nums, 1, nums.length)), solveRob(Arrays.copyOfRange(nums, 0, nums.length - 1)));
        return ans;

    }

    // solve just how we did before
    private int solveRob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        System.out.println(rob2);
        return rob2;
    }
}
