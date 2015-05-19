public class Solution {

    static class TrieNode {
        // Initialize your data structure here.
        TrieNode parent;
        int depth = 0;

        char character;

        TrieNode[] children = new TrieNode[26];

        int count = 0;

        public TrieNode(TrieNode parent, char character) {
            this.parent = parent;
            this.character = character;

            if(parent != null) {
                this.depth = parent.depth + 1;
            }
        }

        TrieNode safe(char c){
            int i = index(c);

            if(children[i] == null){
                children[i] = new TrieNode(this, c);
            }

            return children[i];
        }

        int index(char c){
            return (int)(c - 'a');
        }

        void insert(char[] word, int st, int len){
            if(len == 0){
                this.count++;
                return;
            }

            TrieNode t = safe(word[st]);

            t.insert(word, st + 1, len - 1);
        }

        TrieNode child(char c){
            return children[index(c)];
        }

        boolean hasChild(char c){
            return child(c) != null;
        }

        String recover(){
            // assert count > 0
            TrieNode t = this;
            char[] s = new char[depth];

            for(int i = depth - 1; i >= 0; i--){
                s[i] = t.character;
                t = t.parent;
            }

            return new String(s);
        }
    }

    int flatten(int x, int y, int wide){
        return x * wide + y;
    }

    boolean vaild(int x, int y, char[][] board){
        return x >= 0 &&
               y >= 0 &&
               x < board.length &&
               y < board[0].length;
    }

    Set<String> found = new HashSet<>();

    void findWords(int x, int y, char[][] board, boolean[] vi, TrieNode current) {

        vi[flatten(x, y, board[0].length)] = true;

        if(current.count > 0){
            found.add(current.recover());
        }

        for(int[] xy : new int[][] {
            {x + 1, y},
            {x, y + 1},
            {x - 1, y},
            {x, y - 1},
        }) {
            int _x = xy[0];
            int _y = xy[1];

            if(!vaild(_x, _y, board)){
                continue;
            }

            if(vi[flatten(_x, _y, board[0].length)]) {
                continue;
            }

            TrieNode t = current.child(board[_x][_y]);

            if(t == null){
                continue;
            }

            findWords(_x, _y, board, vi, t);

            vi[flatten(_x, _y, board[0].length)] = false;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode(null, '\0');

        for(String w : words){
            root.insert(w.toCharArray(), 0, w.length());
        }

        final int LEN = board.length * board[0].length;

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[0].length; y++){
                if(root.hasChild(board[x][y])){
                    findWords(x, y, board, new boolean[LEN], root.child(board[x][y]));
                }
            }
        }

        return new ArrayList<>(found);
    }
}
