package deque;
public class LinkedListDeque<T> {
    public class IntNode {
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
    private IntNode sentfront;
    public LinkedListDeque() {
        size = 0;
        sentfront = new IntNode(null, null, null);
    }
    public void addFirst(T item) {
        if (sentfront.next != null) {
            IntNode temp = sentfront.next;
            sentfront.next = new IntNode(sentfront, item, sentfront.next);
            temp.prev = sentfront.next; }

        else {
            sentfront.next = new IntNode(sentfront, item, sentfront);
            sentfront.prev = sentfront.next; }
        size += 1;
    }
    //stylecheck after
    public void addLast(T item){
        if(sentfront.prev!=null){
            IntNode temp=sentfront.prev;
            sentfront.prev=new IntNode(sentfront.prev,item,sentfront);
            temp.next=sentfront.prev;
        }
        else{
            sentfront.prev=new IntNode(sentfront,item,sentfront.prev);
            sentfront.next=sentfront.prev;
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
        while(size!=0&&count>=0&&sentfront.item!=null){
            res+=sentfront.item+ " ";
            sentfront=sentfront.next;
            count-=1;
        }
            System.out.println(res);
    }
    public T removeFirst() {
        if (size == 0 || sentfront.next == null) {return null;}
        else {

            size-=1;
            T res=sentfront.next.item;
            sentfront.next=sentfront.next.next;
            sentfront.next.prev=sentfront;
            return res;
        }
    }
    public T removeLast() {
        if (size ==0 || sentfront.prev == null) { return null;}
        else{
            size -= 1;
            IntNode oldback = sentfront.prev;
            IntNode newback = oldback.prev;

            sentfront.prev=newback;
            newback.next=sentfront;
            return oldback.item;
        }
    }
    public T get(int index) {
        T ans;
        while(index<=size&&index!=0){
            ans=sentfront.item;
            sentfront=sentfront.next;
            index-=1;
        }
        return null;
    }
    public T getRecursive(int index){
        T ans;
        if(index<=size||index!=0){return null;}
        ans=sentfront.item;
        sentfront=sentfront.next;
        index-=1;
        return getRecursive(index);
    }
}




