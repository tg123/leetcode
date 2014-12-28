public class Solution {
    public String multiply(String num1, String num2) {
        
        int[] paper = new int[num1.length() + num2.length()];
        
        Arrays.fill(paper, 0);
        
        char[] _num1 = num1.toCharArray(); 
        char[] _num2 = num2.toCharArray();
        
        for (int i = 0; i < _num2.length; i++) {
            for (int j = 0; j < _num1.length; j++) {
                paper[paper.length - (i + j + 2)] += (_num1[j] - '0') * (_num2[i] - '0');
            }
        }


        // add

        for (int i = 0; i < paper.length - 1; i++) {
            paper[i + 1] += paper[i] / 10;
            paper[i] %= 10;

        }

        String s = "";
        for(int i = paper.length - 1; i > 0 ; i--){

            if(paper[i] == 0 && "".equals(s))
                continue;

            s += paper[i];
        }

        s += paper[0];
        

        return s;
        
    }
}