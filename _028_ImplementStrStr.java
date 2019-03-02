class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0){
            return 0;
        }
        
        if(haystack == null || haystack.length() == 0){
            return -1;
        }    
        
        if(needle.length() > haystack.length()){
            return -1;
        }
        
        for(int i = 0; i <= haystack.length()-needle.length(); i++){
            int j = 0;
            boolean match = true;
            
            while(j < needle.length()){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    match = false;
                    break;
                }
                j++;
            }
            
            if(match){
                return i;
            }
        }
        
        return -1;
    }
}
