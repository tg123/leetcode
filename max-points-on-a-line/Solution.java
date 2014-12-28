/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    
    static class Line{
        
        Point p1;
        Point p2;
        
        int pointCount;
        
        Line(Point p1, Point p2){
            this.p1 = p1;
            this.p2 = p2;
            
            this.pointCount = 2;
        }
        
        boolean on(int x, int y){
            return (x - p1.x) * (p2.y - p1.y) == (y - p1.y) * (p2.x - p1.x);
        }
        
        boolean on(Point p){
            return on(p.x, p.y);
        }
    }
    
    public int maxPoints(Point[] points) {
        
        if(points.length < 2) return points.length;
        
        ArrayList<Line> lines = new ArrayList<Line>();
        
        lines.add(new Line(points[0], points[1]));
        
        for(int i = 2; i < points.length; i++){
            boolean on = false;
            for(Line line : lines){
                if(line.on(points[i])){
                    line.pointCount++;
                    on = true;
                }
            }
            
            if(!on){
                for(int j = 0; j < i; j++){
                    Line l = new Line(points[j], points[i]);
                    lines.add(l);

                    for(int k = 0; k < i; k++){
                        if(j != k && l.on(points[k])){
                            l.pointCount++;
                            break;
                        }

                    }
                }
            }
        }
        
        
        int max = Integer.MIN_VALUE;
        
        for(Line line : lines){
            if(line.pointCount > max) max = line.pointCount;
        }
        
        return max;
        
    }
}