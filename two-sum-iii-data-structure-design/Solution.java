public class TwoSum {

  Map<Integer, Integer> nums = new HashMap<Integer, Integer>();

  public void add(int number) {
    Integer c = nums.get(number);
    if(c == null) c = 0;
    c++;

    nums.put(number, c);
  }

  public boolean find(int value) {

    for(Integer n : nums.keySet()){
      Integer c = nums.get(value - n);

      if(c == null) continue;

      if(value - n == n){
        if(c > 1){
          return true;
        }
      }else{
        return true;
      }
    }


    return false;
  }
}
