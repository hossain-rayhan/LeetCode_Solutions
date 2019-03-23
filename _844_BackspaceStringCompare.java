class Solution {
    public boolean backspaceCompare(String S, String T) {
        int backspaceCounterS = 0, alphabetCounterS = 0;
        char[] sArr = S.toCharArray();
        int index = sArr.length - 1;
        for(int i = sArr.length - 1; i >= 0; i--){
            if(sArr[i] == '#'){
                backspaceCounterS++;
            }else{
                if(backspaceCounterS > 0){
                    sArr[i] = '#';
                    backspaceCounterS--;
                }else{
                    alphabetCounterS++;
                    sArr[index--] = sArr[i];
                }
            }
        }
        
        int backspaceCounterT = 0, alphabetCounterT = 0;
        char[] tArr = T.toCharArray();
        index = tArr.length - 1;
        for(int i = tArr.length - 1; i >= 0; i--){
            if(tArr[i] == '#'){
                backspaceCounterT++;
            }else{
                if(backspaceCounterT > 0){
                    tArr[i] = '#';
                    backspaceCounterT--;
                }else{
                    alphabetCounterT++;
                    tArr[index--] = tArr[i];
                }
            }
        }
        if(alphabetCounterS != alphabetCounterT){
            return false;
        }
        int s = sArr.length - 1, t = tArr.length - 1, i = 0;
        while(i < alphabetCounterT){
            if(sArr[s--] != tArr[t--]){
                return false;
            }
            i++;
        }
        return true;
    }
}
