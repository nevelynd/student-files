package deque;

import java.util.LinkedList;

public class LinkedListDeque<T> {
    private class IntNode {
        public T item;
        public IntNode prev;
        public IntNode next;


    public IntNode (IntNode p,T i, IntNode n){
        item= i;
        next= n;
        prev= p;
    }
}
    private int size;
    private IntNode sentfront;

    public LinkedListDeque (){
        size=0;


        sentfront= new IntNode(null, null, null);

    }

    public void addFirst(T item){
        size+=1;
        if (sentfront.next!=null){
        sentfront= sentfront.next;}
        sentfront= new IntNode(sentfront.prev, item,  sentfront);
    }


    public void addLast(T item) {
        sentfront.next=sentfront.prev;
        if (sentfront!=null){
        sentfront.prev= sentfront;}
        sentfront=new IntNode(sentfront.prev,item,sentfront.next);
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
        if (size==0) {res=" ";}
        while (size!=0 && sentfront!=null){
            res+=sentfront.item+ " ";
            sentfront=sentfront.next;
        }
            System.out.println(res);


    }

    public T removeFirst(){
        if (size==0) {return null;}
        size-=1;
        T res=sentfront.item;
        sentfront=sentfront.next;

    {return res;}

    }
    public T removeLast(){
        if (size==0) {return null;}
        size-=1;
        sentfront=sentfront.next;
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




