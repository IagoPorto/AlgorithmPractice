/**
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    let count = 1

    for(let i = 0; i < flowerbed.length; i++){
        if(flowerbed[i] == 0){
            count++
            if(count == 3){
                n--;
                count = 1
            }

        }else{
            count = 0
        }
    }

    if(count == 2){
        n--
    }

    return n <= 0
};
