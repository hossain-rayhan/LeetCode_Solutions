class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        //the pattern is repeated somewhere in the middle
        int[] f_cells = new int[cells.length];
        int[] next_cells = new int[cells.length];
        
        for(int cycle = 0; N--> 0; cycle++){
            for(int i = 1; i < cells.length - 1; i++){
                next_cells[i] = cells[i-1] == cells[i+1]? 1 : 0;
            }
            
            if(cycle == 0){// very first iteration
                f_cells = next_cells.clone();
            }else if(Arrays.equals(next_cells, f_cells)){ //cycle found
                N = N % cycle;
            }
            cells = next_cells.clone(); //every time update the cells
        }
        return cells;
    }
}
