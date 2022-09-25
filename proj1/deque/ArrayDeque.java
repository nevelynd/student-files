package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>,Deque<T> {
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

    private void resizebrm(){
        if (array.length>=16&&size<=4){
        {T[] narray= (T[]) new Object[size];
        System.arraycopy(array, 0, narray, 0, size);
        array=narray;}}
    }

    private void resize(int cap){

        T[] narray= (T[]) new Object[cap];
            for (int i = 0; i < size; i++) {
                int a=(1+nfirst+i)%size;
                narray[i]=array[a];
            }
            array=narray;
    }
    private void resizefirstrm(int cap){

        if (size==1) {array=(T[]) new Object[0];}
        else{
            T[] narray= (T[]) new Object[cap];
            if (size==2) {T temp=array[(nfirst+2)%array.length];
                array=(T[]) new Object[1];
            array[0]=temp;}
            else{for (int i = 0; i < size-1; i++) {
            int a=(2+nfirst+i)%array.length;
            narray[i]=array[a];}
        array=narray;}}
    }

    private void resizelastrm(int cap){
        if (size==1) {array=(T[]) new Object[0];}
        else{T[] narray= (T[]) new Object[cap];
            if (size==2) {T temp=array[(nfirst+3)%array.length];
                array=(T[]) new Object[1];
                array[0]=temp;}
        else{for (int i = 0; i < size-1; i++) {
            int a = (1 + nfirst + i) % array.length;
            narray[i] = array[a];}


        array=narray;}
    }}

    public void addFirst(T item){

        if (size==array.length){
            if (array.length==0) {array=(T[]) new Object[1];}
            nlast=size;
            resize(array.length*2);
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
            if (array.length==0) {array=(T[]) new Object[1];
                nlast=0;}
            else {resize(array.length*2);
                nlast=array.length;}


            nfirst=array.length-1;

       }

        array[nlast]=item;

        size+=1;
        nlast=(nlast+1)%array.length;

    }
    public T removeFirst(){
        resizebrm();
        if (size!=0){
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
        resizebrm();
        if (size!=0){
            int oldbacki;
            //if (nlast!=nfirst)
            oldbacki= nlast-1;

            if (oldbacki<0)
            {if (size!=1)
            {oldbacki=array.length-1;}
                else {oldbacki=0;}}
            T ans= array[oldbacki];
            resizelastrm(size-1);
            size-=1;
            if (size!=0) {nfirst=array.length-1;}


            nlast=(nlast-1);
            if (nlast<0){
                if (size==array.length) {nlast=0;}
                else{nlast=array.length;}}
            return ans;}
        return null;}

    public T get(int index){


    if (index>(size-1) &&size!=1) {return null;}
    else {return array[((index+nfirst+1)%array.length)];}

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
