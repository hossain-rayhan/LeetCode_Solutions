public class _067 {

    public static void main(String[] args) {
   	 String a = "11";
   	 String b = "11";

   	 _067 obj = new _067();
   	 System.out.println(obj.addTwoBinaryString(b, a));
    }

    private String addTwoBinaryString(String a, String b) {
   	 char[] arrA = a.toCharArray();
   	 char[] arrB = b.toCharArray();

   	 int aL = arrA.length - 1;
   	 int bL = arrB.length - 1;
   	 int maxIndex = Math.max(aL, bL);

   	 int carry = 0;
   	 String resultString = "";
   	 for (int i = 0; i <= maxIndex; i++) {
   		 int aValue, bValue;
   		 if (aL < 0) {
   			 aValue = 0;
   		 } else {
   			 aValue = arrA[aL] - 48;
   		 }
   		 if (bL < 0) {
   			 bValue = 0;
   		 } else {
   			 bValue = arrB[bL] - 48;
   		 }
   		 aL--;
   		 bL--;
   		 int result = (aValue + bValue + carry) % 2;
   		 carry = (aValue + bValue + carry) / 2;

   		 resultString = result + resultString;
   	 }
   	 if(carry > 0){
   		 resultString = carry + resultString;
   	 }
   	 return resultString;
    }
}

