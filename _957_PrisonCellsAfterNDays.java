class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        N = N % 14; // The pattern is repeated after 14th
        if(N == 0){
            N = 14;
        }
        
        int[] cellNew = new int[cells.length];
        cellNew[0] = 0;
        cellNew[cells.length-1] = 0;
        
        for(int i = 1; i <= N; i++){
            if(i %2 == 1){
                for(int j = 1; j < cells.length - 1; j++){
                    if(cells[j-1] == cells[j+1]){
                        cellNew[j] = 1;
                    }else{
                        cellNew[j] = 0;
                    }
                }
            }else{
                for(int j = 1; j < cells.length - 1; j++){
                    if(cellNew[j-1] == cellNew[j+1]){
                        cells[j] = 1;
                    }else{
                        cells[j] = 0;
                    }
                }
                cells[0] = 0;
                cells[cells.length-1] = 0;
            }
            
        }
        
        if(N%2 == 0){
            return cells;
        }else{
            return cellNew;
        }
    }
}
