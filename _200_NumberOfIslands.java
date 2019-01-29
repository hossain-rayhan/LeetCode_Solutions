//This is a four connectivity problem
//We can also solve this using DFS
//Connected Component in an undirected graph
// https://www.geeksforgeeks.org/find-number-of-islands/

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int counter = 0;
        
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
		//Increase the counter only here..
                if(grid[r][c] == '1'){
                    dfs(grid, r,c);
                    counter++;
                }
            }
        }
        return counter;
    }
    
    //run dfs recurrsively and mark the 1's as *
    public void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '*';
        
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    }
}
