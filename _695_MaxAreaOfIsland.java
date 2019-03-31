class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int[] counter = new int[] {0};
                    dfs(grid, row, col, counter);
                    if(counter[0] > max){
                        max = counter[0];
                        counter[0] = 0;
                    }
                }
            }
        }
        return max;
    }
    
    public void dfs(int[][] grid, int row, int col, int[] counter){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1){
            return;
        }
        grid[row][col] = 2;
        counter[0]++;
        
        dfs(grid, row - 1, col, counter);
        dfs(grid, row + 1, col, counter);
        dfs(grid, row, col - 1, counter);
        dfs(grid, row, col + 1, counter);
    }
}
