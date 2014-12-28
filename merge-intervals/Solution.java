/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        ArrayList<Interval> rt = new  ArrayList<Interval>();
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        LinkedList<Interval> s = new LinkedList<Interval>(intervals);

        while (s.size() > 1) {
            Interval i1 = s.pop();
            Interval i2 = s.pop();

            if (i1.end >= i2.start) {
                s.push(new Interval(i1.start, Math.max(i1.end, i2.end)));
            } else {
                s.push(i2);
                rt.add(i1);
            }
        }
        
        rt.addAll(s);
        
        return rt;
    }
}
