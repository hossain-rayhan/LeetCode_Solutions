//Solve in O(N) without any sort or Priority Queue

class Solution {
    public String reorganizeString(String S) {
        int length = S.length();
        if(length < 2){
            return S;
        }
        
        int[] frequency = new int[26];
        int maxIndex = 0;
        for(int i = 0; i < S.length(); i++){
            int index = S.charAt(i) - 'a';
            frequency[index]++;
            if(frequency[index] > frequency[maxIndex]){
                maxIndex = index;
            }
            
            if(frequency[maxIndex] > ((length + 1)/ 2)){
                return ""; //Impossible, if one char repeats more than half time
            }
        }
        
        //System.out.println(Arrays.toString(frequency));
        //System.out.println("Max Index: " + maxIndex);
        
        int i = 0;
        char[] result = new char[length];
        while(frequency[maxIndex] > 0){
            result[i] = (char) (97 + maxIndex);
            i = i + 2;
            frequency[maxIndex]--;
        }
        //System.out.println(Arrays.toString(result));
        
        for(int j = 0; j < 26; j++){
            while(frequency[j] > 0){
                if(i >= length){
                    i = 1;
                }
                result[i] = (char) (97 + j);
                i = i + 2;
                frequency[j]--;
            }
        }
        
        return String.valueOf(result);
    }
}
