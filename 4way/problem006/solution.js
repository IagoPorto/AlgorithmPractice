/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isArraySpecial = function(nums) {
    if(nums.length == 1) return true
    let prev = nums[0] % 2 == 0
    for(let i = 1; i < nums.length; i++){
        if(prev == (nums[i] % 2 == 0)) return false
        prev = !prev
    }
    return true
};
