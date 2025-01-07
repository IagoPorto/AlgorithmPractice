double max(double a, double b);

double findMaxAverage(int* nums, int numsSize, int k) {
    double sum = 0;
    double max_val = INT_MIN;

    for(int i = 0; i < k; i++){
        sum += nums[i];
    }

    max_val = max(max_val, sum/k);

    for(int i = k; i < numsSize; i++){
        sum -= nums[i -k];
        sum += nums[i];
        max_val = max(max_val, sum/k);
    }

    return max_val;
}

double max(double a, double b) {
    return (a > b) ? a : b;
}
