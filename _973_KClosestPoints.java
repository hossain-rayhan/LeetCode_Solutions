//https://www.youtube.com/watch?v=1rEUgAG7f_c

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));
        
        for(int[] p : points){
            maxHeap.add(p);
            if(maxHeap.size() > K){
                maxHeap.remove();
            }
        }
        
        int[][] result = new int[K][2];
        while(K > 0){
            result[K-1] = maxHeap.remove();
            K--;
        }
        
        return result;
    }
}
