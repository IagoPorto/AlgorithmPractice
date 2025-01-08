/**
 * @param {number[]} nums
 * @return {number}
 */
var longestSubarray = function(nums) {
    let left = 0, zeroCount = 0, max = 0

    for(let i = 0; i < nums.length; i++){
        if(nums[i] == 0){
            zeroCount++;
            while(zeroCount > 1){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
        }
        max = Math.max(max, i - left);
    }

    return max
};
