/**
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109


**/

class Solution {
    public int longestConsecutive(int[] nums) {
        int length = 0;
        int i = 0;
        int j = 1;
        Arrays.sort(nums);

        if(nums.length == 0){
            return length;
        }
        length++;
        if(nums.length == 1){
            return length;
        }

        int equal = 0;

        while(j < nums.length){
            if(nums[j - 1] + 1 == nums[j]){
                if(j - i + 1 - equal > length){
                    length = j - i + 1 - equal;
                }
                
            }else{
                if(nums[j - 1] != nums[j]){
                    i = j;
                    equal = 0;
                }else{
                    equal++;
                }
            }
            j++;
        }

        return length;
    }
}
