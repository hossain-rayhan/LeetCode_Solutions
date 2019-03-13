class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            int pId = pid.get(i);
            int parentId = ppid.get(i);
            List<Integer> l = map.getOrDefault(parentId, new ArrayList<Integer>());
            l.add(pId);
            map.put(parentId, l);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(kill);
        
        
        while(!queue.isEmpty()){
            int id = queue.remove();
            result.add(id);
            List<Integer> l = map.getOrDefault(id, new ArrayList<Integer>());
            for(int x : l){
                queue.add(x);
            }
        }
        return result;
    }
}
