class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        
        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            //Traverse first row: left to right
            for(int col = colStart; col <= colEnd; col++){
                list.add(matrix[rowStart][col]);
            }
            rowStart++;
            
            //Traverse last column: top to bottom
            for(int row = rowStart; row <= rowEnd; row++){
                list.add(matrix[row][colEnd]);
            }
            colEnd--;
            
            //Traverse last row: right to left
            if(rowStart <= rowEnd){
                for(int col = colEnd; col >= colStart; col--){
                    list.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;
            
            //Traverse first column: bottom to top
            if(colStart <= colEnd){
                for(int row = rowEnd; row >= rowStart; row--){
                    list.add(matrix[row][colStart]);
                }
            }
            colStart++;
        }
        
        return list;
    }
}
