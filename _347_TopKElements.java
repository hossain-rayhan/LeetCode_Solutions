class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int n : nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        
        //use the concept of maxHeap
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            maxHeap.add(new int[]{key, value});
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(k > 0){
            result.add(maxHeap.remove()[0]);
            k--;
        }
        return result;
    }
}
