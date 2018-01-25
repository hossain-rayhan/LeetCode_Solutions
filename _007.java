package main;

public class _007 {
	
	public static void main(String[] args) {
		System.out.println(reverseInt2(65));
	}
	
	public static int reverseInteger(int x){
		long n = x;
		String result = "";

		if(n < 0){
			result = result + "-";
			n = n * -1;
		}
		
		int counter = 0;
		long y = 0;
		
		while(n != 0){
			y = n % 10;
			
			if( counter == 0 && y == 0){
				
			}else{
				result = result + y;
				counter++;
			}
			n = n / 10;
		}
		long resultInt = 0;
		if(result != "" && result != null)
		 resultInt = Long.parseLong(result);
		
		if(resultInt > Integer.MAX_VALUE || resultInt < Integer.MIN_VALUE)
			resultInt = 0;
		
		return (int)resultInt;
	}
	
	public static int reverseInt2(int x){
		long result = 0;
		while(x != 0){
			int mod = x % 10;
			result = result * 10 + mod;
			x = x / 10;			
		}
		
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		
		return (int)result;
		
	}
	
	
}
