public class _058 {

    public static void main(String[] args) {
   	 _058 obj = new _058();
   	 System.out.println(obj.getLengthOfLastWord("Hello Wor"));
    }
    private int getLengthOfLastWord(String s){
   	 if(s == null || s.length() <= 0){
   		 return 0;
   	 }
   	 
   	 String[] arr = s.split("\\s+");
   	 if(arr.length > 0){
   		 return arr[arr.length - 1].length();
   	 }
   	 return 0;
    }
}

