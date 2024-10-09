/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

 

Constraints:

    1 <= nums.length <= 100
    0 <= nums[i] <= 400


**/

/**Intuition

You want to rob houses without triggering alarms. The trick is to avoid robbing two houses in a row. For each house, you decide: either rob it and skip the next, or skip it and keep the money you've already stolen.
Approach

We go house by house. For each house, we compare if it's better to rob it (and add the money from two houses before) or skip it and take what we've stolen so far. We track the maximum money after each house and update our decision.
Complexity

    Time complexity: O(n)

    Space complexity: O(1)

Code**/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int n1 = 0;
        int n2 = 0;
        for(int n : nums){
            int temp = n1;
            n1 = Math.max(n1, n2 + n);
            n2 = temp;

        }

        return n1;
    }
}
