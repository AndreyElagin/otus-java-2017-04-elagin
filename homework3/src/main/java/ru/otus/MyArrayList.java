package ru.otus;

import java.util.*;

/**
 * Created by daddyingrave on 18/04/2017.
 */
public class MyArrayList<T> implements List<T> {
    public T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyArrayList(int initialSize) {
        array = (T[]) new Object[initialSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) return false;
        }

        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(o)) return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size == array.length) {
            int newLength = array.length * 3 / 2 + 1;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = t;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        if (index > size - 1) throw new IndexOutOfBoundsException();
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        if ((size - 1) < index) throw  new IndexOutOfBoundsException();
        array[index] = element;
        return array[index];
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            private int pos;
            private T current;

            @Override
            public boolean hasNext() {
                if (pos > size) throw new NoSuchElementException();
                return true;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                current = array[pos++];
                return current;
            }

            @Override
            public boolean hasPrevious() {
                if (pos < 0) throw new NoSuchElementException();
                return pos > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) throw new NoSuchElementException();
                current = array[pos--];
                return current;
            }

            @Override
            public int nextIndex() {
                if (pos == size) return size;
                return pos + 1;
            }

            @Override
            public int previousIndex() {
                if (pos == 0) return -1;
                return pos - 1;
            }

            @Override
            public void remove() {
                array[pos] = null;
                size--;
            }

            @Override
            public void set(T t) {
                MyArrayList.this.set(pos - 1, t);
            }

            @Override
            public void add(T t) {
                array[pos] = t;
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T t : this) {
            sb.append(t);
            sb.append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        return sb.toString();
    }

    @Override
    public void sort(Comparator<? super T> c) {
        array = Arrays.copyOfRange(array, 0, size);
        Arrays.sort(array, c);
    }
}
