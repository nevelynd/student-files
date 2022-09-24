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
        nfirst= 0;
        nlast=1;


    }
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}

    //@Hug
    //private void resizefirst(int cap){
        //T[] narray= (T[]) new Object[cap];
        //System.arraycopy(array, 0,narray,1, size);

       // array=narray;}
    private void resize(int cap){
        T[] narray= (T[]) new Object[cap];
        for (int i = 0; i < array.length; i++) {
            int a=(1+nfirst+i)%size;
            narray[i]=array[a];

        }
        array=narray;
    }
    private void resizefirstrm(int cap){
        T[] narray= (T[]) new Object[cap];
       // System.arraycopy(array, 1,narray,0, size-1);
        for (int i = 0; i < size-1; i++) {
            int a=(2+nfirst+i)%array.length;
            narray[i]=array[a];

        }
        array=narray;
    }

    private void resizelastrm(int cap){
        T[] narray= (T[]) new Object[cap];
        // System.arraycopy(array, 1,narray,0, size-1);
        for (int i = 0; i < size-1; i++) {
            int a=(1+nfirst+i)%array.length;
            narray[i]=array[a];

        }
        array=narray;
    }

    public void addFirst(T item){
        if (size==array.length){
            nlast=size+1;
            resize(size*2);
            nfirst=array.length-1;

        }
        array[nfirst]=item;
        nfirst=(nfirst-1);
        if (nfirst<0){
            nfirst=array.length-1;
        }

        size+=1;
        }
    public void addLast(T item){
        if (size==array.length){
            nlast=array.length;
            resize(size*2);

       }

        array[nlast]=item;

        size+=1;
        nlast=(nlast+1)%array.length;

    }
    public T removeFirst(){
        if (size!=0||size>0&&array.length!=0){
            T res= array[(nfirst+1)%array.length];


            resizefirstrm(size-1);
            nfirst=array.length-1;
            size-=1;
            nlast=(nlast-1);
            if (nlast<0){
                if (size==array.length) {nlast=0;}
                else{nlast=array.length;}}
            return res;}
        return null;}
    public T removeLast(){
        if (size!=0 ||size>0&&array.length!=0){

            int oldbacki= nlast-1;

            if (oldbacki<0)
            {if (size!=1)
            {oldbacki=array.length-1;}
                else {oldbacki=0;}}
            T ans= array[oldbacki];
            resizelastrm(size-1);
            nfirst=array.length-1;
            size-=1;
            nlast=(nlast-1);
            if (nlast<0){
                if (size==array.length) {nlast=0;}
                else{nlast=array.length;}}
            return ans;}
        return null;}

    public T get(int index){
        if (index==(size-1)&&index==0) {return 0;}
    if (index>(size-1)) {return null;}
    else {return array[(index+(nfirst+1)%size)];}

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
