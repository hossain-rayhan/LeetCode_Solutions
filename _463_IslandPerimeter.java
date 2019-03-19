class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }    
        
        int result = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    result += 4;
                    if(row > 0 && grid[row-1][col] == 1) result -= 2;
                    if(col > 0 && grid[row][col-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
}
