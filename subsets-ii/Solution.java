public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);

        return new ArrayList<>(IntStream.range(0, 1 << num.length)
                .mapToObj(mask ->
                                IntStream.range(0, num.length)
                                        .filter(i -> ((1 << i) & mask) > 0)
                                        .map(i -> num[i])
                                        .boxed()
                                        .collect(Collectors.toList())
                )
                .collect(Collectors.toSet()));        
    }
}
