class Solution {
    public List<Integer> getRow(int rowIndex) {
        //return spaceComplexityKSquare(rowIndex);
        return spaceComplexityK(rowIndex);
    }
    
    //brute force, space complexity )(K^2)
    public List<Integer> spaceComplexityKSquare(int rowIndex){
        int[][] a = new int[rowIndex+1][rowIndex+1];
        
        for(int i = 0; i <= rowIndex; i++){
            a[i][0] = 1;
            a[0][i] = 1;
        }
        
        for(int i = 1; i <= rowIndex; i++){
            for(int j = 1; j <= rowIndex; j++){
                a[i][j] = a[i][j-1] + a[i-1][j];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            list.add(a[rowIndex-i][i]);
        }
        
        return list;
    }
    
    //follow up: space complexity O(k)
    public List<Integer> spaceComplexityK(int rowIndex){
        int[] a = new int[rowIndex + 1];
        a[0] = 1;
        
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 1; j--){
                a[j] = a[j-1] + a[j];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++){
            list.add(a[i]);
        }
        return list;
    }
}
