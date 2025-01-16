class Solution(object):
    def equalPairs(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        rows = {}
        count = 0
        
        for row in grid:
            row_str = str(row)
            rows[row_str] = rows.get(row_str, 0) + 1
        
        
        for i in range(len(grid)):
            column = [grid[j][i] for j in range(len(grid))]
            column_str = str(column)  
            if column_str in rows:  
                count += rows[column_str]  
        
        return count
        
