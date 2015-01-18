public class Solution {
    public List<String> anagrams(String[] strs) {
        return Arrays.stream(strs)
            .collect(Collectors.groupingBy(
                            k -> {
                                char[] w = k.toCharArray();
                                Arrays.sort(w);
                                return new String(w);
                            }
                    ))
            .values()
            .stream()
            .filter(v -> v.size() > 1)
            .flatMap(v -> v.stream())
            .collect(Collectors.toList());
    }
}
