class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        //generate price map: Map<source, Map<dest, price>>
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int[] f : flights){
            if(!map.containsKey(f[0])){
                map.put(f[0], new HashMap<>());
            }
            map.get(f[0]).put(f[1], f[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //(price, currentCity, RemainingStops)
        pq.offer(new int[] {0, src, K+1});
        while(!pq.isEmpty()){
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            
            if(city == dst){
                return price;
            }
            if(stops > 0 && map.containsKey(city)){
                for(Map.Entry<Integer, Integer> entry: map.get(city).entrySet()){
                    pq.offer(new int[]{price + entry.getValue(), entry.getKey(), stops - 1});
                }
            }
        }
        return -1;
    }
}
