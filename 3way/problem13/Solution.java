class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        max = Math.max(max, sum/k);

        for(int i = k; i < nums.length; i++){
            sum -= nums[i - k];
            sum += nums[i];
            max = Math.max(max, sum/k);
        }

        return max;

    }
}
