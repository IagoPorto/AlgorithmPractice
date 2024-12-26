/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function(candies, extraCandies) {
    
    var result = []
    var max = 0;
    candies.forEach((candie, index) => {
        max = Math.max(max, candie);
    });

    for(let i = 0; i < candies.length; i++){
        result.push(candies[i] + extraCandies >= max);
    }

    return result;

};
