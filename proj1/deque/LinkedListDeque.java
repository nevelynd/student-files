package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;
        public IntNode(IntNode p, T i, IntNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }
    private int size;
    private IntNode sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
    }
    public void addFirst(T item) {
        if (sentinel.next != null) {
            IntNode temp = sentinel.next;
            sentinel.next = new IntNode(sentinel, item, sentinel.next);
            temp.prev = sentinel.next;
        }

        else {
            sentinel.next = new IntNode(sentinel, item, sentinel);
            sentinel.prev = sentinel.next;
        }
        size += 1;
    }
    public void addLast(T item){
        if(sentinel.prev!=null){
            IntNode temp=sentinel.prev;
            sentinel.prev=new IntNode(sentinel.prev,item,sentinel);
            temp.next=sentinel.prev;
        }
        else{
            sentinel.prev=new IntNode(sentinel,item,sentinel.prev);
            sentinel.next=sentinel.prev;
        }
        size+=1;
    }
    public boolean isEmpty(){
        if(size==0){return true;}
        else{return false;}
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int count=size;
        String res="";
        if(size==0){res=" ";}
        while(size!=0&&count>=0&&sentinel.item!=null){
            res+=sentinel.item+ " ";
            sentinel=sentinel.next;
            count-=1;
        }
            System.out.println(res);
    }
    public T removeFirst() {
        if (size == 0 || sentinel.next == null) {return null;}
        else {

            size-=1;
            T res=sentinel.next.item;
            sentinel.next.prev=sentinel;
            sentinel.next=sentinel.next.next;

            return res;
        }
    }
    public T removeLast() {
        if (size ==0 || sentinel.prev == null) { return null;}
        else{
            size -= 1;
            IntNode oldback = sentinel.prev;
            IntNode newback = oldback.prev;

            sentinel.prev=newback;
            newback.next=sentinel;
            return oldback.item;
        }
    }
    public T get(int index) {
        T ans=sentinel.next.item;
        while(index<=size && index!=0){
            ans=sentinel.item;
            sentinel=sentinel.next;
            index-=1;
        }
        return ans;
    }
    public T getRecursive(int index){
        IntNode p = sentinel.next;
        if(index<0){return null;}
        else if(index==0) { return p.item;}
            p = p.next;
            index -= 1;

        return getRecursive(index);
    }


    public boolean equals(Object o){
        if (o instanceof Deque<?>) {return true;
            //Deque newe= (Deque) o;
            //for (int i = 0; i < size; i++) {




    } return false;}

    public Iterator<T> iterator() {
        return null;
    }
}




