class Solution {
    public boolean isValid(String s) {
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
