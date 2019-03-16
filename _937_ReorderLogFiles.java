class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComparator = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                //find the first space index after the log id
                int spaceIndex1 = s1.indexOf(' ');
                int spaceIndex2 = s2.indexOf(' ');
                
                //extract the first char of the log
                char firstChar1 = s1.charAt(spaceIndex1 + 1);
                char firstChar2 = s2.charAt(spaceIndex2 + 1);
                
                //now compare the two first char
                //we have four possible option: digit-digit, digit-char, char-digit, or char-char
                if(firstChar1 <= '9'){
                    if(firstChar2 <= '9'){
                        return 0; // digit-digit
                    }else{
                        return 1; //digit-char
                    }
                }else{
                    if(firstChar2 <= '9'){
                        return -1; //char-digit
                    }else{
                        // char-cahr, here the most calculations
                        
                        //compare the logs using Java default comparTo() method
                        int comp = s1.substring(spaceIndex1+1).compareTo(s2.substring(spaceIndex2+1));
                        if(comp == 0){
                            //both of the logs are equal, need to compare the ids
                            return s1.substring(0, spaceIndex1).compareTo(s2.substring(0, spaceIndex2));
                        }else{
                            return comp;
                        }
                    }
                }
                
            }
        };    
       
        Arrays.sort(logs, myComparator);
        return logs;
    }
}
