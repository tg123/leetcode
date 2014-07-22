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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        //intervals.add(newInterval);
        //Collections.sort(intervals, new Comparator<Interval>(){
        //    public int compare(Interval o1, o2){ return o1.start - o2.start ; }
        //});
        
        LinkedList<Interval> _i = new LinkedList<Interval>(intervals);
        
        boolean insert = false;
        for(int i = 0 ; i<_i.size() ; i++){
            if(newInterval.start <= _i.get(i).start) {
                _i.add(i, newInterval);
                insert = true;
                break;
            }
        }
        if(!insert) _i.add(newInterval);
        
        ArrayList<Interval> rt = new ArrayList<Interval>();
        
        while(_i.size() > 1){
            Interval i1 = _i.pop();
            Interval i2 = _i.pop();
            
            if(i1.end >= i2.start){
                _i.push(new Interval(i1.start, Math.max(i1.end, i2.end)));
            }else{
                rt.add(i1);
                _i.push(i2);
            }
         

        }
        
        rt.addAll(_i);
        
        return rt;
        
    }
}