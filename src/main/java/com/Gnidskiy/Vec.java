package com.Gnidskiy;

public class Vec<T> {
    private T[] _array;

    private int _size;

    /**
     * This method allocates array of type T
     * @param size size of desired array
     * @return Array of T with defined size
     */
    private T[] alloc(int size) {
        return (T[]) new Object[size];
    }

    /**
     * Increases array size in 2 times, when needed
     */
    private void realloc() {
        T[] place = _array;
        _array = alloc(_array.length * 2);

        for (int i = 0; i < place.length; ++i)
            _array[i] = place[i];
    }

    /**
     * Checks if index is out of bounds of array
     * @return Result of checking
     */
    private boolean inBounds(int idx) {
        return idx >= 0 && idx < _size;
    }

    /**
     * Default initialization constructor
     */
    public Vec() {
        _size = 0;
        _array = alloc(1);
    }

    /**
     * Constructor that allocates array with size
     */
    public Vec(int size) {
        _size = size;
        _array = alloc(_size);
    }

    /**
     * Constructor to create array from another array
     */
    public Vec(T[] array) {
        _size = array.length;
        _array = array.clone();
    }

    /**
     * Method to get element at index
     * @param idx Index of needed element
     * @return Element itself
     */
    public T at(int idx) {
        if (!inBounds(idx))
            throw new ArrayIndexOutOfBoundsException(idx + " was out of bounds of array");
        else
            return _array[idx];
    }

    /**
     * Adds element to the end of array
     * @param item Element to be pushed into array
     */
    public void push(T item) {
        if (_size + 1 >= _array.length)
            realloc();

        _array[_size++] = item;
    }

    /**
     * Removes element from array
     * @param idx Index of element
     */
    public void remove(int idx) {
        if (!inBounds(idx))
            throw new ArrayIndexOutOfBoundsException(idx + " was out of bounds of array");
        else {
            for (int i = idx; i < _size - 1; ++i)
                _array[i] = _array[i + 1];

            --_size;
        }
    }

    /**
     * Gets size of array
     * @return Number of elements in array
     */
    public int length() {
        return _size;
    }
}
