class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            char c = arr[i];
            if(c >= 'a' && c <= 'z'){
                arr[index++] = c;
            }else if(c >= 'A' && c <= 'Z'){
                //store the lowercase version
                int ascii = c + 32;
                arr[index++] = (char)ascii;
            }else if(c >= '0' && c <= '9'){
                arr[index++] = c;
            }
        }
        
        int start = 0;
        int end = index - 1;
        
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
