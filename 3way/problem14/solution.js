/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var maxVowels = function(s, k) {
    let list = []
    let max = -Infinity
    let count = 0

    for(let i = 0; i < s.length; i++){
        list[i] = isVowel(s[i])
    }

    for(let i = 0; i < k; i++){
        if(list[i]){
            count++;
        }
    }

    max = count;

    for(let i = k; i < s.length; i++){
        if(list[i]){
            count++;
        }
        if(list[i - k]){
            count--;
        }

        max = Math.max(max, count);
    }

    return max;
};

function isVowel(char){
    return ['a', 'e', 'i', 'o', 'u'].includes(char);
}
