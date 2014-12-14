public class Solution {

  static class Bucket {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    int[] nums = new int[0];

    void add(int n){
      min = Math.min(n, min);
      max = Math.max(n, max);


      nums = Arrays.copyOf(nums, nums.length + 1);

      nums[nums.length - 1] = n;
    }

    int gap(){
      if (nums.length == 1) return 0;
      if (nums.length == 2) return max - min;

      // bad case
      Arrays.sort(nums);

      int g = nums[1] - nums[0];
      for(int i = 2; i < nums.length; i++){
        g = Math.max(nums[i] - nums[i - 1], g);
      }

      return g;
    }
  }

  public int maximumGap(int[] num) {
    if (num.length < 2) return 0;

    double _avg = num[0];

    for(int i = 0; i < num.length; i++){
      _avg += (num[i] - _avg) / (i + 1);
    }

    int avg = (int) Math.ceil(_avg);

    Bucket[] buckets = new Bucket[num.length];
    for(int i = 0; i < num.length; i++){
      int index = num[i] / avg;

      if(buckets[index] == null) buckets[index] = new Bucket();

      buckets[index].add(num[i]);
    }

    int gap = Integer.MIN_VALUE;

    if (buckets[0] != null) gap = buckets[0].gap();

    for(int i = 1; i < buckets.length; i++){
      if(buckets[i] == null) continue;
      gap = Math.max(gap, buckets[i].gap());

      if(buckets[i - 1] == null) continue;
      gap = Math.max(gap, buckets[i].min - buckets[i - 1].max);
    }

    return gap;
  }
}
