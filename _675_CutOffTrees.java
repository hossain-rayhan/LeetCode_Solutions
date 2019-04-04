class Solution {
    public int cutOffTree(List<List<Integer>> forest) {
        //maintain a priority queue of height, as the lowest height tree should be cut first
        //three items int the pq item [row, col, treeHeight]
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> a[2] - b[2]);
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(0).size(); j++){
                int height = forest.get(i).get(j);
                if(height > 1){
                    pq.add(new int[]{i, j, height});
                }
            }
        }
        
        //run bfs to find each tree, as we need to visit in minimum path
        int totalStep = 0;
        int[] start = new int[]{0, 0};
        while(!pq.isEmpty()){
            int[] nextTree = pq.remove();
            int step = bfs(forest, start, nextTree);
            if(step == -1){
                return -1;
            }
            
            totalStep += step;
            start[0] = nextTree[0];
            start[1] = nextTree[1];
            
        }
        return totalStep;
    }
    
    public int bfs(List<List<Integer>> f, int[] start, int[] target){
        int row = f.size(), col = f.get(0).size();
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0, -1},{0, 1},{-1, 0},{1, 0}};
        boolean[][] isVisited = new boolean[row][col];
        
        queue.add(start);
        isVisited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] tree = queue.remove();
                if(tree[0] == target[0] && tree[1] == target[1]){
                    return step;
                }
                //check four neighbors
                for(int[] n : dir){
                    int r = tree[0] + n[0];
                    int c = tree[1] + n[1];
                    if(r < 0 || r >= row || c < 0 || c >= col || f.get(r).get(c) == 0 || isVisited[r][c]) continue;
                    queue.add(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
