class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        List<String> list = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return list;
        }
        char[] tempString = new char[digits.length()];
        backtrack(digits, 0, map, list, tempString);
        return list;
    }
    
    public void backtrack(String digits, int index, HashMap<Character, String> map, List<String> list, char[] tempString){
        if(index == digits.length()){
            //add to list
            list.add(new String(tempString));
        }else{
            String s = map.get(digits.charAt(index));
            for(int i = 0; i < s.length(); i++){
                tempString[index] = s.charAt(i);
                backtrack(digits, index + 1, map, list, tempString);
            }
        }
    }
}
