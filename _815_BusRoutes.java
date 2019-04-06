class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if(S == T)
            return 0;
        
        //minimum num of buses- BFS
        //generate the stop - buses Map
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> visitedBuses = new HashSet<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                //i, j = stop which is key, i = bus number, which is value
                int busStop = routes[i][j];
                List<Integer> list = map.getOrDefault(busStop, new ArrayList<>());
                list.add(i);
                map.put(busStop, list);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int counter = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            counter++;
            for(int i = 0; i < size; i++){
                int stop = queue.poll();
                for(int bus : map.get(stop)){
                    if(visitedBuses.contains(bus)){
                        continue;
                    }
                    visitedBuses.add(bus);
                    for(int s = 0; s < routes[bus].length; s++){
                        if(routes[bus][s] == T){
                            return counter;
                        }
                        queue.offer(routes[bus][s]);
                    }
                }
            }
        }
        return -1;
    }
}
