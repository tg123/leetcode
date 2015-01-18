public class Solution {
    public String largestNumber(int[] num) {
        String[] ns = Arrays.stream(num)
                .mapToObj(Integer::toString)
                .sorted((x, y) -> (y + x).compareTo(x + y))
                .toArray(String[]::new);

        if ("0".equals(ns[0])) return "0";

        return String.join("", ns);
    }
}
