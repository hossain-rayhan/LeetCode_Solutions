class Solution {
    public int snakesAndLadders(int[][] board) {
        
        //convert the 2d array to 1d array
        int n = board.length;
        int[] a = new int[n*n];
        
        int index = 0;
        boolean leftToRight = true;
        for(int i = n-1; i >= 0; i--){
            if(leftToRight){
                for(int j = 0; j < n; j++){
                    a[index++] = board[i][j];
                }
                leftToRight = false;
            }else{
                for(int j = n-1; j >= 0; j--){
                    a[index++] = board[i][j];
                }
                leftToRight = true;
            }
        }
        
        //run the bfs: level order traversal
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n*n];
        int start = 1;
        if(a[0] > -1){
            start = a[0]; //there is a ladder at the start index
        }
        queue.offer(start);
        visited[start-1] = true;
        int step = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.remove();
                if(node == n*n){
                    return step;
                }
                //check next 6 steps if its not visited
                for(int next = node+1; next <= node+6; next++){
                    if(next-1 < n*n && !visited[next-1]){
                        int destination = a[next-1] > -1? a[next-1] : next; //mind, block number is index+1
                        queue.offer(destination);
                        visited[next-1] = true;
                    }
                }
            }
            step++; //increament step after finishing the current level
        }
        return -1;
    }
}
