package arrayset;

import java.util.*;

public class ArraySet<TT> implements Set {

    private TT[] arraySet;
    private TT tt;
    private final Class classCastCheck = tt.getClass();

    public ArraySet() {
        arraySet = (TT[]) new Object[0];
    }

    @Override
    public String toString() {
        return Arrays.toString(arraySet);
    }

    private class ArraySetIterator implements Iterator {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size();
        }

        @Override
        public Object next() {
            return arraySet[counter++];
        }

        @Override
        public void remove() {
            removeForIterator(arraySet[--counter]);
        }
    }

    private void removeForIterator(Object o) {
        remove(o);
    }

    @Override
    public int size() {
        return arraySet.length;
    }

    @Override
    public boolean isEmpty() {
        return arraySet.length == 0;
    }

    /**
     * Returns {@code true} if this set contains the specified element.
     *
     * @param o object to be checked for containment in this set
     * @return {@code true} if this set contains the specified element
     * @throws ClassCastException if the specified object cannot be compared
     * with the elements currently in the set
     * @throws NullPointerException if the specified element is null and this
     * set uses natural ordering, or its comparator does not permit null
     * elements
     */
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            return false;
        } else {
            if (arraySet[0].getClass() != o.getClass()) {
                throw new ClassCastException();
            }
            for (TT tt : arraySet) {
                if (tt.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArraySetIterator();
    }

    @Override
    public Object[] toArray() {
        return arraySet;
    }

    /**
     * Returns an array containing all of the elements in this collection; the
     * runtime type of the returned array is that of the specified array. If the
     * collection fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this collection.
     *
     * <p>
     * If this collection fits in the specified array with room to spare (i.e.,
     * the array has more elements than this collection), the element in the
     * array immediately following the end of the collection is set to
     * <tt>null</tt>. (This is useful in determining the length of this
     * collection <i>only</i> if the caller knows that this collection does not
     * contain any <tt>null</tt> elements.)
     *
     * <p>
     * If this collection makes any guarantees as to what order its elements are
     * returned by its iterator, this method must return the elements in the
     * same order.
     *
     * <p>
     * Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs. Further, this method allows
     * precise control over the runtime type of the output array, and may, under
     * certain circumstances, be used to save allocation costs.
     *
     * <p>
     * Suppose <tt>x</tt> is a collection known to contain only strings. The
     * following code can be used to dump the collection into a newly allocated
     * array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param a the array into which the elements of this collection are to be
     * stored, if it is big enough; otherwise, a new array of the same runtime
     * type is allocated for this purpose.
     * @return an array containing all of the elements in this collection
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public Object[] toArray(Object[] a) {
        Object[] result;
        int counter = 0;
        if (size() >= a.length) {
            return toArray();
        } else {
            result = new Object[a.length];
            for (int i = 0; i < size(); i++) {
                result[counter++] = arraySet[i];
            }
            result[counter++] = null;
            int border = a.length - counter;
            for (int i = 0; i < border; i++) {
                result[counter++] = a[i];
            }
            return result;
        }
    }

    /**
     * Adds the specified element to this set if it is not already present. If
     * this set already contains the element, the call leaves the set unchanged
     * and returns {@code false}.
     *
     * @param e element to be added to this set
     * @return {@code true} if this set did not already contain the specified
     * element
     * @throws ClassCastException if the specified object cannot be compared
     * with the elements currently in this set
     * @throws NullPointerException if the specified element is null and this
     * set uses natural ordering, or its comparator does not permit null
     * elements
     */
    @Override
    public boolean add(Object e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (classCastCheck.equals(e.getClass())) {
            throw new ClassCastException();
        }
        if (arraySet.length == 0) {
            arraySet = (TT[]) new Object[1];
            arraySet[0] = (TT) e;
            return true;
        } else {
            if (arraySet[0].getClass() != e.getClass()) {
                throw new ClassCastException();
            }
            for (TT tt : arraySet) {
                if (tt == e) {
                    return false;
                }
            }
            TT[] tempSet = (TT[]) new Object[arraySet.length + 1];
            for (int i = 0; i < arraySet.length; i++) {
                tempSet[i] = arraySet[i];
            }
            tempSet[arraySet.length] = (TT) e;
            arraySet = tempSet;
            return true;
        }
    }

    /**
     * Removes the specified element from this set if it is present. Returns
     * {@code true} if this set contained the element (or equivalently, if this
     * set changed as a result of the call). (This set will not contain the
     * element once the call returns.)
     *
     * @param o object to be removed from this set, if present
     * @return {@code true} if this set contained the specified element
     * @throws ArrayIndexOutOfBoundsException if the set is empty.
     * @throws ClassCastException if the specified object cannot be compared
     * with the elements currently in this set
     * @throws NullPointerException if the specified element is null and this
     * set uses natural ordering, or its comparator does not permit null
     * elements
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        if (arraySet[0].getClass() != o.getClass()) {
            throw new ClassCastException();
        }
        for (int i = 0; i < arraySet.length; i++) {
            if (arraySet[i].equals(o)) {
                Object[] resultArray = new Object[arraySet.length - 1];
                for (int j = 0; j < resultArray.length; j++) {
                    if (j < i) {
                        resultArray[j] = arraySet[j];
                    } else {
                        resultArray[j] = arraySet[j + 1];
                    }
                }
                arraySet = (TT[]) resultArray;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns <tt>true</tt> if this collection contains all of the elements in
     * the specified collection.
     *
     * @param c collection to be checked for containment in this collection
     * @return <tt>true</tt> if this collection contains all of the elements in
     * the specified collection
     * @throws ArrayIndexOutOfBoundsException if the set is empty.
     * @throws ClassCastException if the types of one or more elements in the
     * specified collection are incompatible with this collection
     * (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one or
     * more null elements and this collection does not permit null elements
     * (<a href="#optional-restrictions">optional</a>), or if the specified
     * collection is null.
     */
    @Override
    public boolean containsAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Object[] checkingArray = c.toArray();
        if (arraySet[0].getClass() != checkingArray[0].getClass()) {
            throw new ClassCastException();
        }
        for (Object o : checkingArray) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all of the elements in the specified collection to this set.
     *
     * @param c collection containing elements to be added to this set
     * @return {@code true} if this set changed as a result of the call
     * @throws ClassCastException if the elements provided cannot be compared
     * with the elements currently in the set
     * @throws NullPointerException if the specified collection is null or if
     * any element is null and this set uses natural ordering, or its comparator
     * does not permit null elements
     */
    @Override
    public boolean addAll(Collection c) {
        Object[] checkingArray = c.toArray();
        for (int i = 0; i < checkingArray.length; i++) {
            if (checkingArray[i] == null) {
                throw new NullPointerException();
            }
            for (int j = 0; j < checkingArray.length; j++) {
                if (i == j) {
                    continue;
                }
                if (checkingArray[i].getClass() != checkingArray[j].getClass()) {
                    throw new ClassCastException();
                }
            }
        }
        for (int i = 0; i < checkingArray.length; i++) {
            add(checkingArray[i]);
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * This implementation iterates over this collection, checking each element
     * returned by the iterator in turn to see if it's contained in the
     * specified collection. If it's not so contained, it's removed from this
     * collection with the iterator's <tt>remove</tt> method.
     *
     * <p>
     * Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
     * and this collection contains one or more elements not present in the
     * specified collection.
     *
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @Override
    public boolean retainAll(Collection c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Object[] checkingArray = c.toArray();
        if (arraySet[0].getClass() != checkingArray[0].getClass()) {
            throw new ClassCastException();
        }
        Set<TT> result = new ArraySet();
        for (Object obj : checkingArray) {
            if (contains(obj)) {
                result.add((TT) obj);
            }
        }
        arraySet = (TT[]) result.toArray();
        return true;
    }

    /**
     * Removes from this set all of its elements that are contained in the
     * specified collection (optional operation). If the specified collection is
     * also a set, this operation effectively modifies this set so that its
     * value is the <i>asymmetric set difference</i> of the two sets.
     *
     * <p>
     * This implementation determines which is the smaller of this set and the
     * specified collection, by invoking the <tt>size</tt>
     * method on each. If this set has fewer elements, then the implementation
     * iterates over this set, checking each element returned by the iterator in
     * turn to see if it is contained in the specified collection. If it is so
     * contained, it is removed from this set with the iterator's
     * <tt>remove</tt> method. If the specified collection has fewer elements,
     * then the implementation iterates over the specified collection, removing
     * from this set each element returned by the iterator, using this set's
     * <tt>remove</tt> method.
     *
     * <p>
     * Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method.
     *
     * @param c collection containing elements to be removed from this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws ClassCastException if the class of an element of this set is
     * incompatible with the specified collection
     * @throws NullPointerException if this set contains a null element and the
     * specified collection does not permit null elements, or if the specified
     * collection is null
     */
    @Override
    public boolean removeAll(Collection c) {
        Object[] checkingArray = c.toArray();
        for (Object o : checkingArray) {
            remove(o);
        }
        return true;
    }

    @Override
    public void clear() {
        arraySet = (TT[]) new Object[0];
    }
}
