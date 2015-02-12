public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);

        return IntStream.range(0, 1 << S.length)
                .mapToObj(mask -> 
                    IntStream.range(0, S.length)
                        .filter(i -> ((1 << i) & mask) > 0)
                        .map(i -> S[i])
                        .boxed()
                        .collect(Collectors.toList())
                )
                .collect(Collectors.toList());        
    }
}
