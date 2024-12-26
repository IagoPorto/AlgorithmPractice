/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    if((str1 + str2) !== (str2 + str1)){
        return "";
    }
    const gdc = (a, b) => {
        return b == 0 ? a : gdc(b, a % b);
    }

    var mcd = gdc(str1.length, str2.length);

    return str1.substring(0, mcd);
};
