class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> fifo = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                fifo.add(i);
            }else{
                Integer index = fifo.poll();
                if(index != null){
                    nums[index] = nums[i];
                    nums[i] = 0;
                    fifo.add(i);
                }
            }
        }
    }
}
