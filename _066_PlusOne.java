class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0){
            return digits;
        }
        
        int carry = 1; //setting carry = 1, because we need to add 1 to the original number
        for(int i = digits.length-1; i>= 0; i--){
            int val = digits[i] + carry;
            digits[i] = val%10;
            carry = val / 10;
        }
        
        if(carry > 0){
            int[] newArray = new int[digits.length + 1];
            newArray[0] = carry;
            for(int i = 0; i < digits.length; i++){
                newArray[i+1] = digits[i];
            }
            return newArray;
        }else{
            return digits;
        }
    }
}
