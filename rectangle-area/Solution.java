public class Solution {

    int area(int x1, int y1, int x2, int y2){
        return (y2 - y1) * (x2 - x1);
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        // make sure left is left
        if(A > E){
            return computeArea(E, F, G, H, A, B, C, D);
        }

        int a = area(A, B, C, D) + area(E, F, G, H);

        // no share case1
        // [  ]C
        //       E[  ]
        if(C < E){
            return a;
        }

        // no share case2
        // [   ]B
        //
        //   [     ]H

        if(B > H || F > D){
            return a;
        }

        // remove share
        return a - area(E, Math.max(B, F), Math.min(C, G), Math.min(D, H));
    }
}
