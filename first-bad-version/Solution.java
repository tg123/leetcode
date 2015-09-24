/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int good = 0; // not exists
        int bad  = n;

        for(;;) {

            if(bad - good <= 1) return bad;

            int t = (bad - good) / 2 + good; // fuck overflow

            if(isBadVersion(t)){
                bad  = t;
            } else {
                good = t;
            }
        }

    }
}
