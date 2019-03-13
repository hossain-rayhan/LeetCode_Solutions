class Solution {
    public int[][] candyCrush(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        boolean found = true;
        
        while(found){
            found = false;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    int val = Math.abs(board[i][j]);
                    if(val == 0){
                        continue;
                    }
                    
                    //if three in a row are equal
                    if(j + 2 < col && Math.abs(board[i][j+1]) == val && Math.abs(board[i][j+2]) == val){
                        found = true;
                        board[i][j] = -val;
                        board[i][j+1] = -val;
                        board[i][j+2] = -val;
                    }
                    
                    
                    //if three in a column are equal
                    if(i + 2 < row && Math.abs(board[i+1][j]) == val && Math.abs(board[i+2][j]) == val){
                        found = true;
                        board[i][j] = -val;
                        board[i+1][j] = -val;
                        board[i+2][j] = -val;
                    }
                }
            }
            
            //Crush: set the negative value to zero
            for(int j = 0; j < col; j++){
                int index = row - 1;
                //take all the positive values to the bottom
                for(int i = row - 1; i >= 0; i--){
                    if(board[i][j] > 0){
                        board[index--][j] = board[i][j];
                    }
                }
                
                //set all the negative values to zero
                while(index >= 0){
                    board[index--][j] = 0;
                }
            }
        }
        
        return board;
    }
}
