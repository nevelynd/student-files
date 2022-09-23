package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    private int size;
    private int nfirst;
    private int nlast;

    private T[] array;
    public ArrayDeque() {

        array = (T[]) new Object[8];
        size = 0;
        nfirst= 3;
        nlast=4;


    }
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}

    //@Hug
    private void resizefirst(int cap){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 0,narray,1, size);

        array=narray;
    }
    private void resizelast(int cap,int sizee){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 0,narray,0, sizee);
        array=narray;
    }
    private void resizefirstrm(int cap){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 1,narray,0, size-1);
        array=narray;
    }

    public void addFirst(T item){
        if (size==array.length){

            resizefirst(size*2);
            nfirst=0;}
        array[nfirst]=item;
        size+=1;
        nfirst=(nfirst-1);
            if (nfirst<0){
               nfirst=array.length-1;
            }}
    public void addLast(T item){
        if (size==array.length){
            nlast=array.length;
            resizelast(size*2,size);}

        array[nlast]=item;

        size+=1;
        nlast=(nlast+1);
        if (size!=array.length && nlast==array.length)
        {nlast=0;}
    }
    public T removeFirst(){
        if (size!=0||array.length!=0){
            nfirst=0;
            T res= array[0];
            resizefirstrm(size-1);
            size-=1;
            nlast=(nlast-1);
            if (nlast<0){
                if (size==array.length) {nlast=0;}
                else{nlast=array.length;}}
            return res;}
        return null;}
    public T removeLast(){
        if (size!=0 ||array.length!=0){

            int oldbacki= nlast-1;

            if (oldbacki<0)
            {if (size!=1)
            {oldbacki=array.length-1;}
                else {oldbacki=0;}}
            T ans= array[oldbacki];
            resizelast(size-1,size-1);
            size-=1;
            nlast=(nlast-1);
            if (nlast<0){
                if (size==array.length) {nlast=0;}
                else{nlast=array.length;}}
            return ans;}
        return null;}

    public T get(int index){
    if (index>(array.length-1)) {return null;}
    else {return array[index];}

    }

    public boolean equals(Object o){return (o instanceof ArrayDeque<?> &&  array[0]==o)
        ;
    }

    public void printDeque(){
        T[] copy=  (T[]) new Object[size];;
        System.arraycopy(array, 0,copy,0, size);
        int i= 0;
        int count=size;
        String res="";
        if(size==0){res=" ";}
        while(size!=0&&copy!=null){
            res+=copy[i]+ " ";
            T[] narray=  (T[]) new Object[size-1];
            System.arraycopy(array, 1,narray,0, size-1);
            count-=1;
            i+=1;
        }
        System.out.println(res);
    }


    public Iterator<T> iterator() {
        return null;
    }
}
