class Solution {
    public int compress(char[] chars) {
        int l = chars.length;
        if(l <= 1){
            return l;
        }
        
        int index = 0;
        for(int i = 0; i < l; i++){
            char ch = chars[i];
            int counter = 1;
            while(i+1 < l && chars[i+1] == ch){
                counter++;
                i++;
            }
            chars[index++] = ch;
            if(counter > 1){
                Stack<Character> stack = new Stack();
                while(counter != 0){
                    int digit = counter % 10;
                    digit = 48 + digit;
                    stack.push((char)digit);
                    counter /= 10;
                }
                
                while(!stack.isEmpty()){
                    chars[index++] = stack.pop();
                }
            }
        }
        return index;
    }
}
