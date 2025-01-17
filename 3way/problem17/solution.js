/**
 * @param {string} s
 * @return {string}
 */
var removeStars = function(s) {
    let stack = []

    s.split('').forEach((c) => {
        if(c === '*'){
            stack.pop()
        }else{
            stack.push(c)
        }
    })

    return stack.join('')
};
