//Push all gates into queue first. 
//Then for each gate update its neighbor cells and push them to the queue.

Repeating above steps until there is nothing left in the queue.

class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();   //level traversal, make sure get the shortest distance
            for(int s = 0; s < size; s++){
                int[] top = queue.poll();
                int row = top[0], col = top[1];
                for(int[] dir : directions){
                    int newX = row + dir[0], newY = col + dir[1];
                    if(newX < 0 || newX >= rooms.length || newY < 0 || newY >= rooms[0].length){
                        continue;
                    }
                    if(rooms[newX][newY] == Integer.MAX_VALUE){
                        rooms[newX][newY] = rooms[row][col] + 1;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
