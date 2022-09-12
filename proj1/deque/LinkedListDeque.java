package deque.LinkedListDeque.java;

import java.util.LinkedList;

public class LinkedListDeque<T> {
    private class IntNode {
        public T item;
        public IntNode next;


    public IntNode (T i, IntNode n){
        item= i;
        next= n;
    }
}
    private int size;
    private IntNode sentfront;


    public LinkedListDeque (){
        size=0;
        sentfront= new IntNode(null, sentfront);

    }

    public void addFirst(T item){
        size+=1;
        sentfront= new IntNode(item, sentfront.next);
    }


    public void addLast(T item) {
        sentfront.next= new IntNode(item, sentfront.next);
        size+=1;


    }

    public boolean isEmpty(){
        if (size==0) {return true;}
        else {return false;}

    }

    public int size(){
        return size;
    }
    public void printDeque(){
        String res="";
        while (sentfront.next.item!=sentfront.item){
            res+=sentfront.item+ " ";
            sentfront=sentfront.next;
        }
            System.out.println(res);


    }

    public T removeFirst(){
    sentfront=sentfront.next;
    if (sentfront.item!=null) {return sentfront.item;}
        {return null;}
    }
    public T removeLast(){    sentfront=sentfront.next;
        if (sentfront.item!=null) {return sentfront.item;}
        {return null;}
    }
    public T get(int index){
        T ans;
        while (index<=size && index!=0) {
            ans=sentfront.item;
            sentfront=sentfront.next;
            index-=1;
        }
        return null;
        }
    public boolean equals(Object o){
        if (o=="e")
        {return true;}
        return false;
    }

    public T getRecursive(int index){
        T ans;
        if (index<=size || index!=0){return null;}
        ans=sentfront.item;
        sentfront=sentfront.next;
        index-=1;

        return getRecursive(index);
    }

    }




