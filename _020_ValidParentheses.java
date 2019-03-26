class Solution {
    public boolean isValid(String s) {
        //return normal(s);
        return smart(s);
    }
    
    public boolean smart(String s){
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
    
    public boolean normal(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            char popChar;
            switch(ch){
				case '(': 
					stack.push(ch);
					break;
				case ')': 
					if(stack.isEmpty())
						return false;
					popChar = stack.pop();
					if(popChar != '(')
						return false;
					break;
				case '{': 
					stack.push(ch);
					break;
				case '}': 
					if(stack.isEmpty())
						return false;
					popChar = stack.pop();
					if(popChar != '{')
						return false;
					break;
				case '[': 
					stack.push(ch);
					break;
				case ']': 
					if(stack.isEmpty())
						return false;
					popChar = stack.pop();
					if(popChar != '[')
						return false;
					break;
			}	
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}
