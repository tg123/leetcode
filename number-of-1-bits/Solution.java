public class Solution {
  // copy from JDK Integer.bitCount
  /**
  * Returns the number of one-bits in the two's complement binary
  * representation of the specified {@code int} value.  This function is
  * sometimes referred to as the <i>population count</i>.
  *
  * @param i the value whose bits are to be counted
  * @return the number of one-bits in the two's complement binary
  *     representation of the specified {@code int} value.
  * @since 1.5
  */
  public static int bitCount(int i) {
    // HD, Figure 5-2
    i = i - ((i >>> 1) & 0x55555555);
    i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
    i = (i + (i >>> 4)) & 0x0f0f0f0f;
    i = i + (i >>> 8);
    i = i + (i >>> 16);
    return i & 0x3f;
  }

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    return bitCount(n);
  }
}
