package practice.slidingwindows;

public class BestTimeToSellAndBuyStocks {
    public static int findMaxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            int profit = sell - minBuy;
            maxProfit = Math.max(maxProfit, profit);
            minBuy = Math.min(minBuy, sell);
        }

        return maxProfit;
    }

    public static int findMaxProfitUsingSlidingWindow(int[] prices) {
        int left = 0, right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{10, 1, 5, 6, 7, 1};
        System.out.println(findMaxProfit(prices));

        System.out.println(findMaxProfitUsingSlidingWindow(prices));
    }
}
