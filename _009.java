package main;

public class _009 {
	
	public static void main(String[] args) {
		System.out.println(isPalindromr(-454));
	}
		
	public static boolean isPalindromr(int x){
		if (x < 0)
			return false;
		long original = x;
		long result = 0;
		while(x != 0){
			int mod = x % 10;
			result = result * 10 + mod;
			x = x / 10;			
		}
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return false;
		
		return original == result;	
	}
}
