class Solution(object):
    def isArraySpecial(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        if len(nums) == 1:
            return True
        prev = nums[0] % 2 == 0
        for i in range(1, len(nums)):
            if(prev == (nums[i] % 2 == 0)):
                return False
            prev = not prev

        return True
        
