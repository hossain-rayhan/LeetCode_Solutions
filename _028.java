package main;

public class _028 {
	public static void main(String[] args) {
		String h = "dfadsfasd", n = "ds";
		System.out.println(strStr(h, n));
	}
	
	public static int strStr(String haystack, String needle) {
		int hl = haystack.length();
		int nl = needle.length();
		
		if(hl == 0 && nl == 0)
			return 0;
		if(hl > 0 && nl <= 0)
			return 0;
		
		for(int i = 0; i < hl; i++){
			if(haystack.charAt(i) == needle.charAt(0)){
				if(hl - i < nl)
					return -1;
				int a = i, matchCounter = 0;
				for(int j = 0; j < nl ; j++){
					if(needle.charAt(j) == haystack.charAt(a + j)){
						matchCounter++;
					}else{
						break;
					}
				}
				if(matchCounter == nl)
					return i;
			}
		}
        return -1;
    }
}
