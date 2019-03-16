class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return countPathDP(obstacleGrid);
    }
    
    // using extra (mxn) space
    public int countPathDP(int[][] path){
        int m = path.length;
        int n = path[0].length;
        
        if(m  <= 0 || path[0][0] == 1){
            return 0;
        }
        path[0][0] = 1;
        
        // update the first col
        for(int i = 1; i < m; i++){
            if(path[i][0] == 1){
                //obstacle- make it zero
                path[i][0] = 0;
            }else{
                path[i][0] = path[i-1][0];
            }
            
        }
        
        // update the first row
        for(int j = 1; j < n; j++){
            if(path[0][j] == 1){
                path[0][j] = 0;
            }else{
                path[0][j] = path[0][j-1];
            }
        }
        
        // calculate the middle row and col values
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(path[i][j] == 1){
                    path[i][j] = 0;
                }else{
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }
            }
        }
        
        return path[m-1][n-1];
    }
}
