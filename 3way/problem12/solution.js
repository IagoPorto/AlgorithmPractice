/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxOperations = function(nums, k) {
    nums.sort((a, b) => a - b); 
    let left = 0;
    let right = nums.length - 1;
    let result = 0;
    while(left < right){
        if(nums[left] + nums[right] > k){
            right--;
        }else if(nums[left] + nums[right] < k){
            left++;
        }else{
            result++;
            left++;
            right--;
        }
    }
    return result;
};
