int compare(const void *a, const void *b) {
    return (*(int*)a - *(int*)b);
}

int maxOperations(int* nums, int numsSize, int k){

    qsort(nums, numsSize, sizeof(int), compare);

    int left = 0;
    int right = numsSize - 1;
    int result = 0;


    while(left < right){
        if(nums[left] + nums[right] > k){
            right--;
        }else if(nums[left] + nums[right] < k){
            left++;
        }else{
            result++;
            left++;
            right--;
        }
    }
    return result;
}
