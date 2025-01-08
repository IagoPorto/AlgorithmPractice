int longestOnes(int* nums, int numsSize, int k) {
    int left = 0;
    int right = 0;
    int zero_count = 0;
    int max_value = 0;

    while(right < numsSize){
        if(nums[right] == 0){
            zero_count++;
        }

        while(zero_count > k){
            if(nums[left] == 0){
                zero_count--;
            }
            left++;
        }

        max_value = max_value > (right - left + 1) ? max_value : right - left + 1;

        right++;
    }

    return max_value;
}
