public class Solution {
  public String largestNumber(int[] num) {

    String[] ns = Arrays.stream(num).mapToObj(x -> "" + x).toArray(String[]::new);

    Arrays.sort(ns, (String x, String y) -> (y + x).compareTo(x + y));

    if("0".equals(ns[0])) return "0";

    return Arrays.stream(ns).collect(Collectors.joining());
  }
}
