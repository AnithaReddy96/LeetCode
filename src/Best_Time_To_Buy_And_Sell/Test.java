package Best_Time_To_Buy_And_Sell;

public class Test {
    public static void main(String[] args) {

       int maxprofit = Solution.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(maxprofit);

        int[] days = Solution.buyDayAndSellDay(new int[]{7,1,5,3,6,4});
        System.out.println(days[0]+" "+days[1]);
    }
}
