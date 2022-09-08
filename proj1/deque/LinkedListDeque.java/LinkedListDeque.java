package deque.LinkedListDeque.java;

public class LinkedListDeque {
    private int first;
    private LinkedListDeque rest;
    private final T[] T;
    private LinkedListDeque (int f, LinkedListDeque r){
        first=f;
        rest=r;

    }

    public void addFirst(T item){
        first= new LinkedListDeque(item, first);
    }


    public void addLast(T item){}

    public boolean isEmpty(){}




}
