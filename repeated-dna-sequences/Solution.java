public class Solution {
    
    static final int SIZE = 10;
    static final char[] CHAR_TO_INT = {'A', 'C', 'G', 'T'};
    static final int[]  INT_TO_CHAR = new int['T' + 1];
    static final int[]  POW = new int[SIZE];

    static {
        for(int i = 0; i < SIZE; i++){
            POW[i] = (int) Math.pow(4, i);
        }

        INT_TO_CHAR['A'] = 0;
        INT_TO_CHAR['C'] = 1;
        INT_TO_CHAR['G'] = 2;
        INT_TO_CHAR['T'] = 3;
    }

    int toInt(char[] s, int index){
        if(index + SIZE > s.length){
            return -1;
        }

        int n = 0;
        for(int i = index; i < index + SIZE; i++){
            n += INT_TO_CHAR[s[i]] * POW[i - index];
        }

        return n;
    }

    String formInt(int n){
        char[] s = new char[SIZE];

        for(int i = 0; i < SIZE; i++){
            s[i] = CHAR_TO_INT[n % 4];
            n /= 4;
        }
        return new String(s);
    }


    public List<String> findRepeatedDnaSequences(String s) {

        char[] S = s.toCharArray();

        final int max = toInt("TTTTTTTTTT".toCharArray(), 0);
        int[] m = new int[max + 1];

        for(int i = 0; i <= S.length - SIZE; i++){
            m[toInt(S, i)]++;
        }

        ArrayList<String> rt = new ArrayList<>();

        for(int i = 0; i < max + 1; i++){
            if(m[i] >= 2){
                rt.add(formInt(i));
            }
        }

        return rt;
    }
}
