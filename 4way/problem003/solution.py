class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total_sum = sum(nums)
        left_sum = 0
        for i, n in enumerate(nums):
            right_sum = total_sum - left_sum - n
            if(right_sum == left_sum): return i
            left_sum += n

        return -1
