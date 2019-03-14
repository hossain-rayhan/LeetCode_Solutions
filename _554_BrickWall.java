class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0){
            return 0;
        }
        
        //we need to count the points where maximum edges belongs
        HashMap<Integer, Integer> edgePositionMap = new HashMap<>();
        int maxEdge = 0;
        for(List<Integer> list : wall){
            int length = 0;
            //we don't need to consider the last brick's edge 
            for(int i = 0; i < list.size()-1; i++){
                length += list.get(i);
                edgePositionMap.put(length, edgePositionMap.getOrDefault(length, 0) + 1);
                
                maxEdge = Math.max(maxEdge, edgePositionMap.get(length));
            }
        }
        
        return wall.size() - maxEdge;
    }
}
