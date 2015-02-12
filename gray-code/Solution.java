public class Solution {
    public List<Integer> grayCode(int n) {
        
        return IntStream.range(0, (int) Math.pow(2, n))
            .map(i -> (i >> 1) ^ i )
            .boxed()
            .collect(Collectors.toList());
        
    }
}
