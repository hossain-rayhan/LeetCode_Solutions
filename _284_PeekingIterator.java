// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html


//We could solve this problem using a queue. But the problem is: imagine we
//have an iterator with 10 million values, and we want to iterate only first k
//values. The time complexity would be O(N) as well as the Space complexity.

//The way we chose- Time complexity is O(K) and Space complexity is O(1)

import java.util.NoSuchElementException;
class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    boolean noSuchElement;
    int next;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        moveForward();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        //need to discuss with the interviewer what type of exception we should throw
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(noSuchElement){
            throw new NoSuchElementException();
        }
        int val = next;
        moveForward();
        return val;
	}

	@Override
	public boolean hasNext() {
	    return !noSuchElement;
	}
    
    public void moveForward(){
        if(iterator.hasNext()){
            next = iterator.next();
        }else{
            noSuchElement = true;
        }
    }
}
