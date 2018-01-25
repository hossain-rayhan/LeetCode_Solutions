package main;

public class _014 {
	public static void main(String[] args) {
		String [] input = {"aca", "acaaacba","acarefweregrwg"};
		System.out.println(longestCommonPrefix(input));
	}
	
	public static String longestCommonPrefix(String [] strs){
		String result = "";
		int size = strs.length;
		if(size <= 0)
			return result;
		
		int index = 0;
		char ch;
		
		while(true){
			
			int matchCounter = 0;
			
			if(strs[0].length() <= index)
				return result;
			else
				ch = strs[0].charAt(index);
			
			for(int i = 0; i < size; i++){
				if(strs[i].length() <= index)
					return result;
				else{
					
					if(strs[i].charAt(index) == ch)
						matchCounter++;
				}
				
			}
			index++;
			if(matchCounter == size)
				result = result + ch;
			else
				return result;
			
		}
		
	}
}
