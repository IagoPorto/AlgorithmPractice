/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findMaxAverage = function(nums, k) {
    var sum = 0;
    var max = -Infinity;

    for(let i = 0; i < k; i++){
        sum += nums[i];
    }

    max = Math.max(max, sum/k);

    for(let i = k; i < nums.length; i++){
        sum -= nums[i - k];
        sum += nums[i];
        max = Math.max(max, sum/k);
    }

    return max;
};
