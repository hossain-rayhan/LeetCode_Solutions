class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //start from the top right corner
        //if the target is less than matrix[row][col], col--
        //if the target is greater than matrix[row][col], row++
        //Time Complexity: O(m+n)
        
        if(matrix == null || matrix.length <= 0){
            return false;
        }
        
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else if(target > matrix[row][col]){
                row++;
            }
        }
        return false;
    }
}
