class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        
        for(int i = 1; i <= n; i++){
            String s = "";
            if(i % 5 == 0 && i % 3 == 0){
                s = "FizzBuzz";
            }else if(i % 5 == 0){
                s = "Buzz";
            }else if(i % 3 == 0){
                s = "Fizz";
            }else{
                s = s + i;
            }
            
            list.add(s);
        }
        
        return list;
    }
}
