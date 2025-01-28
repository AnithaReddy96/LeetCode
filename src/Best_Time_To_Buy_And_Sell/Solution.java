package Best_Time_To_Buy_And_Sell;

public class Solution {
/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104*/




    public static int maxProfit(int[] prices){
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else{
                maxProfit = Math.max(maxProfit,(prices[i]-minPrice));
            }
        }
        return maxProfit;
    }

    public static int[] buyDayAndSellDay(int[] prices){
        int minPrice = prices[0];
        int maxProfit = 0;
       // int buyDay = 0,sellDay=0;
        int[] buyAndSell = new int[2];

        for(int i =1;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
                buyAndSell[0]=i;

            }else{
                maxProfit = Math.max(maxProfit,(prices[i]-minPrice));
                buyAndSell[1]=i;
            }
        }
        return buyAndSell;
    }
}
