/**
 * @param {number[]} arr
 * @return {boolean}
 */
var uniqueOccurrences = function(arr) {
    const numberOccurrences = {};
    
    // Contar las ocurrencias
    for (let num of arr) {
        numberOccurrences[num] = (numberOccurrences[num] || 0) + 1;
    }
    
    const occurrences = new Set();
    
    // Verificar si las frecuencias son únicas
    for (let count of Object.values(numberOccurrences)) {
        if (occurrences.has(count)) {
            return false;
        }
        occurrences.add(count);
    }
    
    return true;
};
