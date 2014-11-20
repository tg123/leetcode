/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class Solution extends Reader4 {
  /**
  * @param buf Destination buffer
  * @param n   Maximum number of characters to read
  * @return    The number of characters read
  */
  public int read(char[] buf, int n) {

    char[] _buf = new char[4];

    int total = 0;

    while(true){
      int l = read4(_buf);

      if(l == 0) break;

      l = Math.min(n - total, l);

      for(int i = 0; i < l; i++){
        buf[total++] = _buf[i];
      }

    }

    return total;
  }
}
