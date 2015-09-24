public class ZigzagIterator {

    Iterator<Integer>[] ivs;

    int p = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        ivs = new Iterator[]{v1.iterator(), v2.iterator()};
    }

    public int next() {
        for(;;){

            Iterator<Integer> i = ivs[p++ % ivs.length];

            if(i.hasNext()){
                return i.next();
            }
        }
    }

    public boolean hasNext() {
        for(Iterator i : ivs){
            if(i.hasNext()){
                return true;
            }
        }

        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
