class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0 || board.length == 0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        int wl = word.length();
        
        if(wl > (m*n)){
            return false;
        }
        char[]input = word.toCharArray();
        boolean[][] isVisited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(check(board, i, j, isVisited, input, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean check(char[][] board, int row, int col, boolean[][] isVisited, char[] word, int i){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word[i] || isVisited[row][col]){
            return false;
        }
       
        isVisited[row][col] = true;
        
        if(i == word.length - 1){
            return true;
        }
        
        if(check(board, row-1, col, isVisited, word, i+1) || check(board, row+1, col, isVisited, word, i+1) || 
          check(board, row, col-1, isVisited, word, i+1) || check(board, row, col+1, isVisited, word, i+1)){
            return true;
        }
        
        isVisited[row][col] = false;
        return false;
    }
}
