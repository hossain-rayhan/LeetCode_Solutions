class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int buy = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            int sell = prices[i];
            if(sell > buy){
                if(sell - buy > maxProfit){
                    maxProfit = sell - buy;
                }
            }else{
                buy = sell;
            }
        }
        return maxProfit;
    }
}
