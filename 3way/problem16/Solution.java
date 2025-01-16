class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows  = new HashMap<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            String key = Arrays.toString(grid[i]);
            rows.put(key, rows.containsKey(key) ? rows.get(key) + 1 : 1);
        }

        for(int i = 0; i < grid.length; i++){
            int[] column = new int[grid.length];
            for(int j = 0; j < grid.length; j++){
                column[j] = grid[j][i];
            }
            String columnKey = Arrays.toString(column);
            if(rows.containsKey(columnKey)){
                count += rows.get(columnKey);
            }
        }

        return count;

    }
}
