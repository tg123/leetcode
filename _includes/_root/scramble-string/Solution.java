public class Solution {
    
    static class Board {

        HashMap<Character, Integer> left  = new HashMap<Character, Integer>();
        HashMap<Character, Integer> right = new HashMap<Character, Integer>();

        String leftString;
        String rightString;

        HashMap<Character, Integer> part(int idx){
            if(idx < left.size()){
                return left;
            } else {
                return right;
            }

        }

        void add(Map<Character, Integer> m, Character c){
            Integer cnt = m.get(c);

            if(cnt == null){
                m.put(c, 1);
                return;
            }

            m.put(c, cnt + 1);

        }

        void addLeft(Character c){
            add(left, c);
        }

        void addRight(Character c){
            add(right, c);
        }

        int count(Map<Character, Integer> m, Character c){
            Integer cnt = m.get(c);
            if(cnt == null) return 0;

            return cnt;
        }

        boolean hasChar(int idx, Character c, int count){

            HashMap<Character, Integer> m = part(idx);

            if(m == left){
                return count(m, c) >= count;
            }

            return count(left, c) + count(right, c) >= count;
        }
    }

    List<Board> buildTwo(char[] all, int p){

        Board b = new Board();

        StringBuilder leftString  = new StringBuilder();
        StringBuilder rightString = new StringBuilder();

        for(int i = 0; i < all.length; i++){

            Character c = all[i];
            if(i < p){
                leftString.append(c);
                b.addLeft(c);
            }else{
                rightString.append(c);
                b.addRight(c);
            }
        }

        b.leftString  = leftString.toString();
        b.rightString = rightString.toString();

        Board mb = new Board();
        mb.left  = new HashMap<Character, Integer>(b.right);
        mb.right = new HashMap<Character, Integer>(b.left);

        mb.leftString  = b.rightString;
        mb.rightString = b.leftString;

        return Arrays.asList(new Board[]{b, mb});
    }

    boolean checkSameChar(char[] s1, char[] s2){
        s1 = Arrays.copyOf(s1, s1.length);
        s2 = Arrays.copyOf(s2, s2.length);

        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    static final Board SEP = new Board();

    public boolean isScramble(String s1, String s2) {

        char[] _s1 = s1.toCharArray();
        char[] _s2 = s2.toCharArray();

        if(_s1.length != _s2.length)
            return false;

        if(_s1.length == 0) return true;
        if(_s1.length == 1) return _s1[0] == _s2[0];
        if(!checkSameChar(_s1, _s2))
            return false;


        LinkedList<Board> exp = new LinkedList<Board>();

        for(int i = 1; i < _s1.length; i++){
            exp.addAll(buildTwo(_s1, i));
        }

        exp.add(SEP);

        HashMap<Character, Integer> counting = new HashMap<Character, Integer>();

        for(int i = 0; i < _s2.length; i++){

            Character c = _s2[i];

            Integer cnt = counting.get(c);

            if(cnt == null){
                cnt = 0;
                counting.put(c, 1);
            }else{
                counting.put(c, cnt + 1);
            }

            while(true){
                Board b = exp.poll();

                if(b == SEP){
                    if(exp.isEmpty())
                        return false;

                    exp.add(SEP);
                    break;
                }

                if(b.hasChar(i, c, cnt + 1)){
                    exp.add(b);
                }

            }

        }

        for(Board b : exp){
            if(b != SEP){

                if(isScramble(b.leftString , s2.substring(0, b.leftString.length()) )
                    && isScramble(b.rightString, s2.substring(b.leftString.length()))) {
                    return true;
                }

            }
        }

        return false;

    }
    
}