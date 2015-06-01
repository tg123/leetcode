public class Solution {
    
    static class Tree {
        TreeMap<Integer, Integer> tree = new TreeMap<>();

        int size = 0;

        void add(Integer n){
            Integer v = tree.get(n);

            if(v == null){
                v = 0;
            }

            tree.put(n, v + 1);

            size++;
        }

        void remove(Integer n){
            Integer v = tree.get(n);

            v--;

            if(v == 0){
                tree.remove(n);
            } else {
                tree.put(n, v);
            }

            size--;
        }

        // fuck overflow
        long nearSub(Integer n){

            Integer v = tree.get(n);
            if(v >= 2) return 0;

            long min = Long.MAX_VALUE;

            Integer h = tree.higherKey(n);
            if(h != null){
                min = h - n;
            }

            Integer l = tree.lowerKey(n);
            if(l != null){
                min = Math.min(min, (long)n - l);
            }

            return min;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0) return false;
        if (nums.length <= 1) return false;

        Tree tree = new Tree();

        tree.add(nums[0]);

        int p = 0;
        for(int i = 1; i < nums.length; i++){

            tree.add(nums[i]);

            if(tree.nearSub(nums[i]) <= t){
                return true;
            }

            if(tree.size > k){
                tree.remove(nums[p++]);
            }
        }

        return false;
    }
}
