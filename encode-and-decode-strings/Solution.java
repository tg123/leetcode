public class Codec {

    static final int MAX_LEN = Integer.toHexString(Integer.MAX_VALUE).length();

    // lazy ... should be byte[]
    static final String NUM_PATTERN = "%0" + MAX_LEN + "x";

    String serializeNumber(int n){
        return String.format(NUM_PATTERN, n);
    }

    int deserializeNumber(char[] s, int offset){
        return Integer.parseInt(new String(s, offset, MAX_LEN), 16);
    }

    /*  [count] [str len] [str  ...]             ... [str len][str  ...  ]
     *  0       L         2L        2L + strlen      nL       (n + 1)L   (n + 1)L + strlen
     */

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(serializeNumber(strs.size()));

        for(String s : strs){
            sb.append(serializeNumber(s.length()));
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char[] S = s.toCharArray();

        int offset = 0;
        int n = deserializeNumber(S, offset);
        // move to first str len start
        offset += MAX_LEN;

        ArrayList<String> strs = new ArrayList<>(n);

        for(int i = 0; i < n; i++){

            int len = deserializeNumber(S, offset);

            // move to str start
            offset += MAX_LEN;

            strs.add(new String(S, offset, len));

            // move to next str len start
            offset += len;
        }

        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
