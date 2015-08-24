public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> m = new HashMap<>();

        for(char c : s.toCharArray()){
            Integer i = m.get(c);

            if(i == null){
                m.put(c, 1);
            } else {
                m.put(c, i + 1);
            }
        }

        int single = 0;

        for(int v : m.values()){
            if(v % 2 == 1){
                single++;
            }

            if(single > 1){
                return false;
            }
        }

        return true;
    }
}
