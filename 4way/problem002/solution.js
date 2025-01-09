/**
 * @param {number[]} gain
 * @return {number}
 */
var largestAltitude = function(gain) {
    let max = 0, prev = 0

    gain.forEach((point) => {
        prev += point
        max = Math.max(max, prev)
    })

    return max
};
