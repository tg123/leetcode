public class Solution {

    Integer[] stack;
    List<List<Integer>> found;

    void search(int p, int k, int current, int n, int st){

        if(p == k){
            if(n == current){
                found.add(new ArrayList<>(Arrays.asList(stack)));
            }

            return;
        }

        // cut
        if(current + 9 * (k - p) < n){
            return;
        }

        if(current + 1 * (k - p) > n){
            return;
        }

        for(int i = st; i < 10; i++){
            if(current + i <= n){
                stack[p] = i;
                search(p + 1, k, current + i, n, i + 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        found = new ArrayList<>();
        stack = new Integer[k];

        search(0, k, 0, n, 1);

        return found;
    }
}
