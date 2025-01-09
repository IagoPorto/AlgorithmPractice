class Solution(object):
    def largestAltitude(self, gain):
        """
        :type gain: List[int]
        :rtype: int
        """
        max_val = 0
        prev = 0
        for point in gain:
            prev += point
            max_val = max(max_val, prev)

        return max_val
        
