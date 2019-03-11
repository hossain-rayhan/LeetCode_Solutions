//using TreeMap- data are sorted by key in ascending aorder
//For this time complexity for retrive would be O(logN)

//another way- Normal HashMap and String processing would take- O(N)

import java.util.NavigableMap;

class LogSystem {

    HashMap<String, Integer> indexMap;
    TreeMap<String, List<Integer>> logs;
    String max, min;
    
    public LogSystem() {
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:591";
        
        indexMap = new HashMap<>();
        indexMap.put("Year", 4);
        indexMap.put("Month", 7);
        indexMap.put("Day", 10);
        indexMap.put("Hour", 13);
        indexMap.put("Minute", 16);
        indexMap.put("Second", 19);
        
        logs = new TreeMap<>();
        
    }
    
    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp)){
            logs.put(timestamp, new ArrayList<Integer>());
        }
        logs.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> result = new ArrayList<>();
        
        int index = indexMap.get(gra);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0, index) + max.substring(index);
        
        NavigableMap<String, List<Integer>> sub = logs.subMap(start, true, end, true);
        for(Map.Entry<String, List<Integer>> entry : sub.entrySet()){
            result.addAll(entry.getValue());
        }
        
        return result;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
