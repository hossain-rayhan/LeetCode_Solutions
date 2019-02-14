class Solution {
    public int calPoints(String[] ops) {
        if(ops.length == 0)
            return 0;
        int[] value = new int[ops.length];
        int sum = 0, first = -1, second = -1;
        for(int i = 0; i < ops.length; i++){
            if(ops[i].equals("+")){
                int temp = value[first] + value[second];
                sum += temp;
                
                second = first;
                first++;
                value[first] = temp;
            }else if(ops[i].equals("D")){
                int temp = 2 * value[first];
                sum += temp;
                
                second = first;
                first++;
                value[first] = temp;
            }else if(ops[i].equals("C")){
                sum -= value[first];
                second--;
                first--;
            }else{
                int point = Integer.parseInt(ops[i]);
                sum += point;
                
                second = first;
                first++;
                value[first] = point;
                
            }
        }
        return sum;
    }
}
