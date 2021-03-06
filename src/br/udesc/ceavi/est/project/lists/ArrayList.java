package br.udesc.ceavi.est.project.lists;

import br.udesc.ceavi.est.project.interfaces.List;

public class ArrayList<E> implements List<E> {

    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public ArrayList() {
        this(CAPACITY);
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) {
        checkIndex(i, size + 1);
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }

    public void add(E e) {
        add(size, e);
    }

    @Override
    public E remove(int i) {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }

    @Override
    public String toString() {
        System.out.println("Printando ArrayList");
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[j]);
        }
        sb.append(")");
        return sb.toString();
    }
}
