class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        
        int index = 0;
        while(true){
            boolean conditionBreak = false;
            char ch;
            if(index < strs[0].length()){
                ch = strs[0].charAt(index);
            }else{
                break;
            }
            for(int i = 1; i < strs.length; i++){
                if(index < strs[i].length() && strs[i].charAt(index) == ch){
                    
                }else{
                    conditionBreak = true;
                    break;
                }
            }
            if(conditionBreak){
                break;
            }
            index++;
        }
        
        if(index == 0){
            return "";
        }else{
            return strs[0].substring(0, index);
        }
    }
}
