public class Solution {

  static class Range {
    int start;
    int end;

    Range(int start, int end){
      this.start = start;
      this.end   = end;
    }

    public String toString(){
      if(start == end) return "" + start;

      return start + "->" + end;
    }

    boolean valid(){
      return end >= start;
    }

    void addMeIfValid(List<String> l){
      if(valid()){
        l.add(toString());
      }
    }
  }

  public List<String> findMissingRanges(int[] A, int lower, int upper) {

    List<String> rt = new ArrayList<String>();

    Range current = new Range(lower, upper);

    for(int i = 0; i < A.length; i++){
      if(A[i] > current.end) break;

      if(A[i] >= current.start){
        Range r = new Range(current.start, A[i] - 1);

        r.addMeIfValid(rt);

        current.start = A[i] + 1;
      }

    }

    current.addMeIfValid(rt);

    return rt;
  }
}
