class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int dashCounter = 0;
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '-'){
                dashCounter++;
            }
        }
        int validLength = S.length() - dashCounter;
        if(validLength == 0){
            return "";
        }
        
        char[] arr = S.toUpperCase().toCharArray();
        int dash = validLength / K;
        if(validLength % K == 0){
            dash--;
        }
        
        char[] key = new char[validLength + dash];
        int counter = 0, i = arr.length-1, index = key.length - 1;
        while(i >= 0){
            if(arr[i] != '-'){
                key[index--] = arr[i--];
                counter++;
                if(counter % K == 0 && index>= 0){
                    key[index--] = '-';
                }
            }else{
                i--;
            }
        }
        return new String(key);
    }
}
