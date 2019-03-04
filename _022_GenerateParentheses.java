//Cracking the coding interview- Problem 8.9: Parens

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        char[] str = new char[n*2];
        
        backtrackHelper(list, n, n, str, 0);
        
        return list;
    }
    
    public void backtrackHelper(List<String> list, int leftRem, int rightRem, char[] str, int index){
        if(leftRem < 0 || rightRem < leftRem){
            return; //invalid state
        }
        
        if(leftRem == 0 && rightRem == 0){
            //both of the parens are used
            list.add(String.copyValueOf(str));
        }else{
            //parens are still left
            str[index] = '(';
            backtrackHelper(list, leftRem - 1, rightRem, str, index + 1);
            
            str[index] = ')';
            backtrackHelper(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
