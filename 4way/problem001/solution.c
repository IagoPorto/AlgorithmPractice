int longestSubarray(int* nums, int numsSize) {
    int left = 0;
    int zeroCount = 0;
    int max = 0;

    for(int i = 0; i < numsSize; i++){
        if(nums[i] == 0){
            zeroCount++;
        }

        while(zeroCount > 1){
            if(nums[left] == 0){
                zeroCount--;
            }
            left++;
        }

        max = max < i - left ? i - left : max;
    }

    return max;
}
