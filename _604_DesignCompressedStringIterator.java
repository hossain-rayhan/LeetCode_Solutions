class StringIterator {
    long repeat = 0;
    char[] arr;
    char c;
    int index = 0;
    
    public StringIterator(String compressedString) {
         arr = compressedString.toCharArray();
    }
    
    public char next() {
        if(repeat > 0){
            repeat--;
            return c;
        }else if(index < arr.length){
            c = arr[index++];
            int d = 1;
            repeat = 0;
            while(index < arr.length && Character.isDigit(arr[index])){
                repeat = (10 * repeat) + (arr[index] - '0') ;
                index++;
            }
            
            repeat--;
            return c;
        }else{
            return ' ';   
        }
    }
    
    public boolean hasNext() {
        return repeat > 0 || index < arr.length;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
