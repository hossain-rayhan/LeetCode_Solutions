/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    //like 2D graph, [0, 1] = top, [1,0] = right, [0, -1] = down, and finally left
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    
    //the robot is initially facing up
    public void cleanRoom(Robot robot) {
        HashSet<String> set = new HashSet<>(); //to keep track of the visited cell
        dfs(robot, 0, 0, 0, set);
    }
    
    public void dfs(Robot robot, int x, int y, int currentDir, HashSet<String> visited){
        robot.clean();
        visited.add(x + "-" + y);
        
        for(int i = 0; i < 4; i++){
            int nextDir = (currentDir + i) % 4;
            int nextX = x + dx[nextDir];
            int nextY = y + dy[nextDir];
            
            if(!visited.contains(nextX + "-" + nextY) && robot.move()){ //if not visited and not obstacle
                dfs(robot, nextX, nextY, nextDir, visited);
                
                //go back to the parent cell
                robot.turnRight();
                robot.turnRight();
                robot.move();
                
                //go back to the original direction
                robot.turnRight();
                robot.turnRight();
            }
            
            //because we purposely arranged dx, dy to be clockwise. If we are facing right, we will be facing down in the next iteration
            robot.turnRight();
        }  
    }
}
