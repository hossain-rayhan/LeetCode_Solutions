class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums1){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer> resultList = new ArrayList<>();
        for(int n: nums2){
            if(map.containsKey(n) && map.get(n) > 0){
                resultList.add(n);
                map.put(n, map.get(n) - 1);
            }
        }
        
        int[] arr = new int[resultList.size()];
        int index = 0;
        for(int n : resultList){
            arr[index++] = n;
        }
        
        return arr;
    }
}
