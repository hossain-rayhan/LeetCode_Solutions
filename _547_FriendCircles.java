class Solution {
    public int findCircleNum(int[][] M) {
        int counter = 0;
        for(int row = 0; row < M.length; row++){
            if(M[row][row] == 1){ //diagonal 1 means, not visited
                dfs(M, row); 
                counter++;
            }
            
        }
        return counter;
    }
    
    public void dfs(int[][] a, int row){
        if(a[row][row] == 0){
            return;
        }   
        a[row][row] = 0; //mark as visited
        for(int col = 0; col < a.length; col++){
            if(a[row][col] == 1){
                dfs(a, col);
            }
        }
    }
}
