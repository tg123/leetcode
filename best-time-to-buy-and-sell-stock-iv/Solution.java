public class Solution {
  public int maxProfit(int k, int[] prices) {
    k = Math.min(k, prices.length);
    if(k <= 0) return 0;

    // shit cheat
    if(k >= prices.length) return maxProfit(prices);

    int[][] P = new int[k + 1][prices.length];
    int[][] H = new int[k + 1][prices.length];

    int[] D = new int[prices.length];

    for(int i = 1; i < prices.length; i++){
      D[i] = prices[i] - prices[i - 1];
    }

    int si = 1;

    for(int j = 1; j <= k; j++) {

      for (int i = si; i < prices.length; i++) {

        H[j][i] = Math.max(H[j][i - 1] + D[i], P[j - 1][i - 1]);

        P[j][i] = Math.max(H[j][i], P[j][i - 1]);

      }

      for (int i = si + 1; i < prices.length; i++) {
        if(P[j - 1][i] == P[j][i]) {
          si = i;
        }
      }

      if(si == prices.length - 1){
        return P[j][prices.length - 1];
      }
    }

    return P[k][prices.length - 1];
  }

  // best-time-to-buy-and-sell-stock-ii
  int maxProfit(int[] prices) {

    if(prices.length <= 1) return 0;

    int profit = 0;

    int hold = prices[0];

    for(int i = 1; i < prices.length; i++){


      if(hold < prices[i]){
        profit += prices[i] - hold; // sell

      }

      hold = prices[i];
    }

    return profit;
  }
}
