class Solution {
    public int uniquePathsIII(int[][] grid) {
        int startX = -1, startY = -1, totalEmpty = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    startX = i; 
                    startY = j;
                }
                if(grid[i][j] == 0){
                    totalEmpty++;
                }
            }
        }
        int[] result = new int[]{0, totalEmpty}; //[result, totalEmptySquare]
        dfs(grid, startX, startY, 0, result);
        return result[0];
    }
    
    public void dfs(int[][] grid, int row, int col, int count,  int[] result){
        int val = grid[row][col];
        if(val == -1 || val == 9){
            return; //obstacle or already visited
        }    
        
        if(val == 2){
            // destination found and it visited all the empty squares
            if(count-1 == result[1]){
                result[0]++;
            } 
            return;
        }
        
        grid[row][col] = 9; //choose
        
        //explore
        if(row - 1 >= 0) dfs(grid, row - 1, col, count+1, result);
        if(row + 1 < grid.length) dfs(grid, row + 1, col, count+1, result);
        if(col - 1 >= 0) dfs(grid, row, col - 1, count+1, result);
        if(col + 1 < grid[0].length) dfs(grid, row, col + 1, count+1, result);
        
        grid[row][col] = val; //undo
    }
}
