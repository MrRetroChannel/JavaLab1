package com.Gnidskiy;

public class Vec<T> {
    private T[] _array;

    private int _size;

    private T[] alloc(int size) {
        return (T[]) new Object[size];
    }

    private void realloc() {
        T[] place = _array;
        _array = alloc(_array.length * 2);

        for (int i = 0; i < place.length; ++i)
            _array[i] = place[i];
    }

    private boolean inBounds(int idx) {
        return idx >= 0 && idx < _size;
    }

    public Vec() {
        _size = 0;
        _array = alloc(1);
    }

    public Vec(int size) {
        _size = size;
        _array = alloc(_size);
    }

    public Vec(T[] array) {
        _size = array.length;
        _array = array.clone();
    }

    public T at(int idx) {
        if (!inBounds(idx))
            throw new ArrayIndexOutOfBoundsException(idx + " was out of bounds of array");
        else
            return _array[idx];
    }

    public void push(T item) {
        if (_size + 1 >= _array.length)
            realloc();

        _array[_size++] = item;
    }

    public void remove(int idx) {
        if (!inBounds(idx))
            throw new ArrayIndexOutOfBoundsException(idx + " was out of bounds of array");
        else {
            for (int i = idx; i < _size - 1; ++i)
                _array[i] = _array[i + 1];

            --_size;
        }
    }

    public int length() {
        return _size;
    }
}
