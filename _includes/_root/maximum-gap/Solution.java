public class Solution {

  static class Bucket {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    void add(int n){
      min = Math.min(n, min);
      max = Math.max(n, max);
    }
  }

  public int maximumGap(int[] num) {
    if (num.length < 2) return 0;

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for(int i = 0; i < num.length; i++){
      max = Math.max(max, num[i]);
      min = Math.min(min, num[i]);
    }


    int gap = (int) Math.ceil((double)(max - min) / (num.length - 1));
    int n   = (max - min) / gap + 1;

    Bucket[] buckets = new Bucket[n];

    for(int i = 0; i < num.length; i++){
      int index = (num[i] - min) / gap;

      if(buckets[index] == null) buckets[index] = new Bucket();

      buckets[index].add(num[i]);
    }

    int maxGap = Integer.MIN_VALUE;

    int prev   = min;

    for(int i = 0; i < buckets.length; i++){
      if(buckets[i] == null) continue;

      maxGap = Math.max(maxGap, buckets[i].min - prev);

      prev   = buckets[i].max;
    }

    return maxGap;
  }
}
