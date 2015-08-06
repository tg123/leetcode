public class Vector2D {

    Iterator<List<Integer>> outterIter;
    Iterator<Integer> innerIter = Collections.emptyIterator();

    public Vector2D(List<List<Integer>> vec2d) {
        outterIter = vec2d.iterator();
    }

    public int next() {
        return innerIter.next();
    }

    public boolean hasNext() {
        if(innerIter.hasNext()){
            return true;
        }

        if(!outterIter.hasNext()){
            return false;
        }

        innerIter = outterIter.next().iterator();

        return hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
