/**
You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:

    choose an index i such that 0 <= i < nums.length,
    increase your score by nums[i], and
    replace nums[i] with ceil(nums[i] / 3).

Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.

 

Example 1:

Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

Example 2:

Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.

**/

/**Intuition

To maximize the score after performing exactly k operations, my first thought was to always select the maximum element available. This would ensure that each operation contributes the highest possible value to the score.
Approach

I utilized a max-heap (implemented with PriorityQueue) to keep track of the maximum elements efficiently. Initially, all elements from the nums array are added to the heap. For each of the k operations, I extracted the maximum value, added it to the score, and then replaced it with its value divided by 3 (using the ceiling function). This greedy approach guarantees that we always get the highest score possible with each operation.
Complexity

    Time complexity: O(klogn), where nn is the number of elements in nums and k is the number of operations.

    Space complexity: O(n), due to the storage required for the max-heap.

Code**/

class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for(int n : nums){
            maxHeap.offer((long) n);
        }

        for(int i = 0; i < k; i++){
            long value = maxHeap.poll();
            score += value;
            maxHeap.offer((long) Math.ceil(value / 3.0));
        }

        return score;
    }
}
