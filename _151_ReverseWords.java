public class Solution {
    public String reverseWords(String s) {
        return reverseWord1(s);
    }
    
    //using extra spaces
    public String reverseWord1(String s){
        
        String[] arr = s.trim().split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
            if(i > 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
