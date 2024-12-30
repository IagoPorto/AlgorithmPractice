/**
 * @param {number[]} nums
 * @return {boolean}
 */
var increasingTriplet = function(nums) {
    if(nums.length < 3) return false;
    let min1 = Infinity;
    let min2 = Infinity;
    for(let n of nums){
        if(n <= min1) min1 = n;
        else if(n <= min2) min2 = n;
        else return true;
    }

    return false;
};
