/**
Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

 

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100


**/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = 0;
        int nin = 0;
        int count = m * n;
        boolean rigth = true;
        boolean left = false;
        boolean up = false;
        boolean down = false;
        int i = 0;
        int j = 0;
        List<Integer> output = new ArrayList<>();
        
        while (count > 0) {
            if (rigth) {
                while (j < n && count > 0) {
                    output.add(matrix[i][j]);
                    j++;
                    count--;
                }
                j--;
                i++;
                rigth = false;
                down = true;
                min++;
            }
            
            if (down) {
                while (i < m && count > 0) {
                    output.add(matrix[i][j]);
                    i++;
                    count--;
                }
                i--;
                j--;
                down = false;
                left = true;
                n--;
            }
            
            if (left) {
                while (j >= nin && count > 0) {
                    output.add(matrix[i][j]);
                    j--;
                    count--;
                }
                j++;
                i--;
                left = false;
                up = true;
                m--;
            }
            
            if (up) {
                while (i >= min && count > 0) {
                    output.add(matrix[i][j]);
                    i--;
                    count--;
                }
                i++;
                j++;
                up = false;
                rigth = true;
                nin++;
            }
        }
        
        return output;
    }
}
