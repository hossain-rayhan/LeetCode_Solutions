class Solution {
    public int maxDistToClosest(int[] seats) {
        int i = 0, j, max = 0, length = seats.length;
        for( j = 0; j < length; j++){
            if(seats[j] == 1){
                if(i == 0){ //check the prefix continuous zeros
                    max = j;
                }else{
                    max = Math.max(max, (j-i+1)/2); //check the middle continuous zeros
                }
                i = j + 1;
            }
        }
        max = Math.max(max, length - i); //check the suffix continuous zeros
        
        return max;
    }
}
