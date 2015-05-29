public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(k <= 0) return false;

        Map<Integer, List<Integer>> pairs = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> l = pairs.get(nums[i]);

            if(l == null){
                l = new ArrayList<>();
                pairs.put(nums[i], l);
            } else {
                for(int j : l){
                    if(i - j <= k){
                        return true;
                    }
                }
            }

            l.add(i);
        }

        return false;
    }
}
