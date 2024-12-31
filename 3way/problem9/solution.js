/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    let count = 1;
    let index = 0;

    for(let i = 1; i <= chars.length; i++){
        if(i == chars.length || chars[i] != chars[i - 1]){
            chars[index++] = chars[i - 1];
            if(count > 1){
                const countStr = count.toString();
                for (let c of countStr) {
                    chars[index++] = c;
                }
                count = 1;
            }
        }else{
            count++;
        }
    }
    return index;
};
