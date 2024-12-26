/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool* kidsWithCandies(int* candies, int candiesSize, int extraCandies, int* returnSize) {
    
    int max =  0;
    *returnSize = candiesSize;
    bool* result = (bool*)malloc(*returnSize * sizeof(bool));
    for(int i = 0; i < candiesSize; i++){
        max = candies[i] > max ? candies[i] : max;
    }

    for(int i = 0; i < candiesSize; i++){
        result[i] = candies[i] + extraCandies >= max;
    }

    return result;

}
