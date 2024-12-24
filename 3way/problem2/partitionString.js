/**
 * @param {string} s
 * @return {number}
 */
var partitionString = function(s) {
    let seen = new Array(26).fill(false);
    let result = 1;

    for(let i = 0; i < s.length; i++){
        let index = s.charCodeAt(i) - 'a'.charCodeAt(0);;
        if(seen[index]){
            result++;
            seen = new Array(26).fill(false);
        }
        seen[index] = true
    }
    return result;
};
