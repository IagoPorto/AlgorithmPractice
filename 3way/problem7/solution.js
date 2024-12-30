/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {

    const vowels = new Set(['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U']);
    const chars = s.split('');
    let start = 0;
    let end = s.length - 1;

    while (start < end) {
        while (start < end && !vowels.has(chars[start])) {
            start++;
        }
        while (start < end && !vowels.has(chars[end])) {
            end--;
        }
        [chars[start], chars[end]] = [chars[end], chars[start]];
        start++;
        end--;
    }

    return chars.join('');

};
