public class Solution {
    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split(" +"));

        Collections.reverse(words);
        
        return String.join(" ", words);
    }
}
