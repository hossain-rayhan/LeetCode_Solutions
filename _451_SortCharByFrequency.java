//Here I used the concept of Bucket sort. We can also sove using a priority queue
//For this, complexity is: O(N). But for the Priority Queue it would be O(nLogk), k = distinct element

class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 2)
            return s;
        
        //count the frequency and find the max
        int max = 0;
        int[] frequency = new int[128];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            frequency[ch]++;
            if(frequency[ch] > max){
                max = frequency[ch];
            }
        }
        
        //bucket sort: creat the bucket
        List<Character>[] bucket = new List[max + 1];
        for(int i = 0; i < 128; i++){
            if(frequency[i] > 0){
                if(bucket[frequency[i]] == null){
                    bucket[frequency[i]] = new ArrayList<Character>();
                }
                bucket[frequency[i]].add((char)i);
            }
        }
        
        //add the char from the end of the bucket list
        StringBuilder sb = new StringBuilder();
        for(int i = max; i >= 0; i--){
            if(bucket[i] != null){
                for(int j = 0; j < bucket[i].size(); j++){
                    for(int k = 0; k < i; k++){
                        sb.append(bucket[i].get(j));
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
