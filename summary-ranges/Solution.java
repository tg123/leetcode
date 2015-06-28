public class Solution {

    static class Range {

        int st;
        int ed;

        Range(int st){
            this.st = st;
            this.ed = st;
        }

        public String toString(){
            if(ed == st) return "" + st;

            return st + "->" + ed;
        }
    }

    public List<String> summaryRanges(int[] nums) {

        ArrayList<String> rt = new ArrayList<>();

        if(nums.length == 0) return rt;

        Range r = new Range(nums[0]);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - r.ed == 1){
                r.ed = nums[i];
            } else {
                rt.add(r.toString());
                r = new Range(nums[i]);
            }
        }

        rt.add(r.toString());

        return rt;
    }
}
