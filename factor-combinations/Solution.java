public class Solution {
    List<List<Integer>> getFactors(int n, int low, int high) {
        List<List<Integer>> found = new ArrayList<>();

        if(low <= n && n < high){
            found.add(Arrays.asList(n));
        }

        for(int i = low; n / i >= low; i++){
            if(n % i == 0){
                for(List<Integer> sub : getFactors(n / i, i, n)){
                    List<Integer> l = new ArrayList<>();
                    l.add(i);
                    l.addAll(sub);
                    found.add(l);
                }
            }
        }

        return found;
    }

    public List<List<Integer>> getFactors(int n) {
        return getFactors(n, 2, n);
    }
}
