public class Solution {
    public int candy(int[] ratings) {
        
        
        int[] candies = new int[ratings.length];
        
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < candies.length; i++){
            if(ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1])
                candies[i] = candies[i - 1] + 1;
        }
        
        for(int i = candies.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }
        
        int s = 0;
        for(int c : candies) 
            s += c;
            
        return s;
        
    }
}