/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthFactor = function(n, k) {
    
    for(var i = 1; i <= n; i++){
        if(n % i == 0) k--;
        if(k == 0) return i;
    }
    
    return -1;

};
