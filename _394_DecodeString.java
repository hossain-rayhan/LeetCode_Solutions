class Solution {
    int index = 0;
    
    public String decodeString(String s) {
        return decodeArray(s.toCharArray());
    }
    
    public String decodeArray(char[] s){
        StringBuilder sb = new StringBuilder();
        
        while(index < s.length && s[index] != ']'){
            if(!Character.isDigit(s[index])){
                sb.append(s[index++]);
            }else{
                int repeat = 0;
                while(Character.isDigit(s[index])){
                    repeat = (repeat * 10) + (s[index++] - '0');
                }
                
                index++; // to skip the '['
                String sub = decodeArray(s);
                index++; //to skip the ']'
                
                while(repeat > 0){
                    sb.append(sub);
                    repeat--;
                }
            }    
        }
        return sb.toString();
    }
}
