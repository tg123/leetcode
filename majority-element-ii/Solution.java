public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0) return Collections.emptyList();

        int n1 = nums[0];
        int n2 = nums[0];

        int c1 = 0;
        int c2 = 0;

        for(int i = 0; i < nums.length; i++){

            // put to an empty slot
            if(c1 <= 0 && nums[i] != n2){
                n1 = nums[i];
                c1 = 1;
                continue;
            }

            if(c2 <= 0 && nums[i] != n1){
                n2 = nums[i];
                c2 = 1;
                continue;
            }

            // add count
            if(nums[i] == n1){
                c1++;
                continue;
            }

            if(nums[i] == n2){
                c2++;
                continue;
            }

            // no match

            c1--;
            c2--;
        }

        // faint
        return new ArrayList<>(IntStream.of(n1, n2)
                .filter(n ->
                        Arrays.stream(nums).filter(i -> n == i).count() > nums.length / 3)
                .boxed()
                .collect(Collectors.toSet()));
    }
}
