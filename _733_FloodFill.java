class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        //apply dfs and update with your color
        dfs(image, sr, sc, -1, image[sr][sc]);
        
        //update your -1, with the newColor
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                if(image[i][j] == -1){
                    image[i][j] = newColor;
                }
            }
        }
        return image;
    }
    
    public void dfs(int[][] image, int row, int col, int newColor, int checkPixel){
        if(row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != checkPixel){
            return;
        }
        
        image[row][col] = newColor;
        
        dfs(image, row, col + 1, newColor, checkPixel);
        dfs(image, row, col - 1, newColor, checkPixel);
        dfs(image, row - 1, col, newColor, checkPixel);
        dfs(image, row + 1, col, newColor, checkPixel);
    }
}
