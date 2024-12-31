/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    let sIndex = 0;
    let tIndex = 0;
    let sLen = s.length;
    let tLen = t.length;
    while(sIndex < sLen && tIndex < tLen){
        if(s[sIndex] == t[tIndex]){
            sIndex++;
        }
        tIndex++;
    }
    return sIndex == sLen;
};
