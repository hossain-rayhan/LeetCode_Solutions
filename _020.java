package main;

import java.util.Stack;

public class _020 {
	public static void main(String[] args) {
		String s = "()[]";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s){
		if(s.length() <= 1)
			return false;
		
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		
		while(index < s.length()){
			
			char ch = s.charAt(index);
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
			index++;
		}
		
		if(!stack.isEmpty())
			return false;
		return true;
	}
}
