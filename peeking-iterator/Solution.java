// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    static final Integer NONE = new Integer(0);

    Iterator<Integer> iterator;

    Integer next = NONE;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(next == NONE){
            next = iterator.next();
        }

        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(next != NONE){
            try{
                return next;
            } finally {
                next = NONE;
            }
        }

        return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    return next != NONE || iterator.hasNext();
	}
}
