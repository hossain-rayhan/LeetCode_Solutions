//https://www.youtube.com/watch?v=1rEUgAG7f_c

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        //return sort(points, K);
        //return maxHeap(points, K);
        return quickSelect(points, K);
    }
    
    //solution-1: sort and return first K
    //Time: O(NlogN)
    public int[][] sort(int[][] points, int K){
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0]*p2[0] + p2[1]*p2[1]));
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    //solution-2: Maintain a heap of size K
    //Time: O(NlogK)
    public int[][] maxHeap(int[][] points, int K){
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
    
    //solution-3: Quick select
    //Time: Theoritically O(N), but in the worst case it might be O(N^2).
    public int[][] quickSelect(int[][] points, int K){
        int left = 0, right = points.length - 1;
        while(left <= right){
            int index = partition(points, left, right);
            if(index == K){
                break;
            }else if(index < K){
                left = index + 1;
            }else{
                right = index - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    public int partition(int[][] points, int left, int right){
        int[] pivot = points[left];
        
        while(left < right){
            while(left < right && compare(points[right], pivot) >= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left], pivot) <= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        return left;
    }
    public int compare(int[] a, int[] b){
        return (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]);
    }
}
