class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        boolean prev = nums[0] % 2 == 0;
        for(int i = 1; i < nums.length; i++){
            if(prev == (nums[i] % 2 == 0)) return false;
            prev = !prev;
        }

        return true;
    }
}
