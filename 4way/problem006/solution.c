bool isArraySpecial(int* nums, int numsSize) {
    if(numsSize == 1) return true;
    bool prev = nums[0] % 2 == 0;
    for(int i = 1; i < numsSize; i++){
        if(prev == (nums[i] % 2 == 0)) return false;
        prev = !prev;
    }
    return true;
}
