class Solution {
    public int uniquePaths(int m, int n) {
        return countPathDP(m, n);
    }
    
    // using extra (mxn) space
    public int countPathDP(int m, int n){
        int[][] path = new int[m][n];
        
        // make the first col: 1
        for(int i = 0; i < m; i++){
            path[i][0] = 1;
        }
        
        // make the first row: 1
        for(int j = 0; j < n; j++){
            path[0][j] = 1;
        }
        
        // calculate the middle row and col values
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        
        return path[m-1][n-1];
    }
    
    
}
