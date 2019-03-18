class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        //adjencent positions
        int[][] adj = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}}; 
        dfs(board, click[0], click[1], adj);
        
        return board;
    }
    
    public void dfs(char[][] board, int row, int col, int[][] adj){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return;
        }
        if(board[row][col] == 'M'){ //exit case
            board[row][col] = 'X';
            return;
        }else if(board[row][col] == 'B'){ // already explored
            return;
        }else{
            //count the number of adjecent mines
            int mines = 0;
            for(int[] direction : adj){
                int r = row + direction[0];
                int c = col + direction[1];
                if(r >= 0 && r < board.length && c >= 0 && c < board[0].length){
                    if(board[r][c] == 'M' || board[r][c] == 'X'){
                        mines += 1;
                    }
                }
            }
            
            //mines found in adjecent locaitons
            if(mines > 0){
                board[row][col] = (char)('0' + mines);
            }else{
                //no mines found, only condition for recursive exploration
                board[row][col] = 'B';
                for(int[] direction : adj){
                    int r = row + direction[0];
                    int c = col + direction[1];
                    dfs(board, r, c, adj);
                }
            }
        }
    }
}
