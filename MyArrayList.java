package com.company;
import java.util.*;
/**
 * My own ArrayList implementation.
 * 1) add Integers to the end of the arrayList : boolean add(Integer integer)
 * 2) add Integers to a specific index location: void add(int index, Integer integer)
 * 3) check to see how many elements are in the arrayList: int size()
 * 4) check to see if the arrayList is empty: boolean isEmpty()
 * 5) get the object from a specific index location: Integer get(int index)
 * 6) check to see if an object exists within the array: boolean contains(Object o)
 * 7) get the index location of a specific object: int indexOf(Object o)
 * 8) remove the object from the arrayList: boolean remove(Object o)
 * 9) remove the object from the arrayList from a specific index location: Integer remove(int index)
 */
public class MyArrayList implements List<Integer> {
    private Integer[] arrayList;
    private int size;
    private final static int DEFAULT_SIZE = 10;
    public MyArrayList() {
        this.arrayList = new Integer[DEFAULT_SIZE];
    }
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }
        this.arrayList = new Integer[initialCapacity];
        this.size = 0;
    }
    /**
     * how many elements are in the arrayList
     * @return size
     */
    @Override
    public int size() {
        return this.size;
    }
    /**
     * check to see if the arrayList is empty
     * @return true if empty; false if not
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    /**
     * if an object exists within the arrayList
     * @param o
     * @return true if object exists, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) >= 0;
    }
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }
    /**
     * add Integers to the end of the arrayList
     * @param integer
     * @return
     */
    @Override
    public boolean add(Integer integer) {
        if (this.arrayList.length == this.size) {
            ensureCapacity();
        }
        this.arrayList[this.size++] = integer;
        return true;
    }
    /**
     * remove the object from the arrayList
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }
    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }
    @Override
    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }
    @Override
    public boolean addAll(int i, Collection<? extends Integer> collection) {
        return false;
    }
    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }
    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }
    @Override
    public void clear() {
    }
    /**
     * get the object from a specific index location
     * @param index
     * @return
     */
    @Override
    public Integer get(int index) {
        Integer integer = null;
        try {
            integer = this.arrayList[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you specified is not within bounds.");
            System.exit(-1);
        }
        return integer;
    }
    @Override
    public Integer set(int index, Integer integer) {
        return null;
    }
    /**
     * add Integers to a specific index location
     * @param index
     * @param integer
     */
    @Override
    public void add(int index, Integer integer) {
        if (this.arrayList.length == this.size) {
            ensureCapacity();
        }
        if (index >= this.arrayList.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }
        add(integer);
        if (size - 1 - index >= 0) {
            System.arraycopy(arrayList, index, arrayList, index + 1, size - 1 - index);
        }
        arrayList[index] = integer;
    }
    /**
     * remove the object from the arrayList from a specific index location
     * @param index
     * @return integer
     */
    @Override
    public Integer remove(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Integer integer = get(index);
        if (size - 1 - index >= 0) {
            System.arraycopy(arrayList, index + 1, arrayList, index, size - 1 - index);
        }
        size--;
        return integer;
    }
    /**
     * get the index location of a specific object
     * @param o
     * @return index
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.arrayList.length; i++) {
            if (o.equals(this.arrayList[i])) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }
    @Override
    public ListIterator<Integer> listIterator(int i) {
        return null;
    }
    @Override
    public List<Integer> subList(int i, int i1) {
        return null;
    }
    private void ensureCapacity() {
        int newIncreasedCapacity = arrayList.length * 2 + 1;
        arrayList = Arrays.copyOf(arrayList, newIncreasedCapacity);
    }
    public static void main(String[] args) {
        MyArrayList myList = new MyArrayList();
        System.out.println("The number of elements in array is: " + myList.size());
        System.out.println("The ArrayList is empty: " + myList.isEmpty());
        System.out.println();
        System.out.println("Add an element to the end of the ArrayList: 4");
        myList.add(4);
        System.out.println("The number of elements in array is: " + myList.size());
        System.out.println("The ArrayList is empty: " + myList.isEmpty());
        System.out.println();
        System.out.println("Add an element to the end of the ArrayList: 6");
        myList.add(6);
        System.out.println("The number of elements in array is: " + myList.size());
        System.out.println("The index of 6 is " + myList.indexOf(6));
        System.out.println();
        System.out.println("Add an element to the end of the ArrayList: 10");
        myList.add(10);
        System.out.println("Element at index 2 : " + myList.get(2));
        System.out.println();
        System.out.println("Add an element to the end of the ArrayList: 8");
        myList.add(8);
        System.out.println("The number of elements in array is: " + myList.size());
        System.out.println();
        System.out.println("Add an element to a 2 index location of the ArrayList: 5");
        myList.add(2, 5);
        System.out.println("Element at index 2 : " + myList.get(2));
        System.out.println();
        System.out.println("Element at index 1 : " + myList.get(1));
        System.out.println("Element at index 4 : " + myList.get(4));
        System.out.println();
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("ArrayList[" + i + "]: " + myList.get(i));
        }
        System.out.println();
        System.out.println("Add an element to a 3 index location of the ArrayList: 7");
        myList.add(3, 7);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("ArrayList[" + i + "]: " + myList.get(i));
        }
        System.out.println();
        System.out.println("The index of 3 is " + myList.indexOf(3));
        System.out.println("The index of 10 is " + myList.indexOf(10));
        System.out.println();
        System.out.println("Is 6 in array? " + myList.contains(6));
        System.out.println("Is 9 in array? " + myList.contains(9));
        System.out.println();
        System.out.println("Element at index 2 : " + myList.get(2));
        System.out.println("Removing element at index 2: "+myList.remove(2));
        System.out.println("Element at index 2 : " + myList.get(2));
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("ArrayList[" + i + "]: " + myList.get(i));
        }
        System.out.println();
    }
}
