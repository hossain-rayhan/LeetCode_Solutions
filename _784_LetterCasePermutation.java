//https://leetcode.com/problems/letter-case-permutation/discuss/115485/Java-Easy-BFS-DFS-solution-with-explanation

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        dfsHelper(S.toCharArray(), 0, list);
        
        return list;
    }
    
    public void dfsHelper(char[] arr, int position, List<String> list){
        if(position == arr.length){
            list.add(new String(arr));
        }else if(arr[position] >= '0' && arr[position] <= '9'){
            dfsHelper(arr, position + 1, list);
        }else{
            char c = arr[position];
            
            arr[position] = Character.toUpperCase(c);
            dfsHelper(arr, position + 1, list);
            
            arr[position] = Character.toLowerCase(c);
            dfsHelper(arr, position + 1, list);
        }
    }
}
