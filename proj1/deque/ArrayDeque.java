package deque;

public class ArrayDeque<T> {
    private int size=8;
    private int nfirst;
    private int nlast;

    private T[] array;
    public ArrayDeque() {

        array = (T[]) new Object[8];
        size = 0;
        nfirst= 0;
        nlast=array.length-1;


    }
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}

    //@Hug
    private void resizefirst(int cap){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 0,narray,1, size);
        array=narray;
    }
    private void resizelast(int cap){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 0,narray,0, size);
        array=narray;
    }
    public void addFirst(T item){
        if (size==array.length){
            resizefirst(size+1);
            size+=1;
            array[0]=item;
        }
        else {array[nfirst]=item;}
        if (size!=array.length){
            nfirst=(nfirst-1)%(array.length-1);}

    }
    public void addLast(T item){
        if (size==array.length){
            resizelast(size+1);
            size+=1;}
        else {array[nfirst]=item;}
        if (size!=array.length){
        nlast=(nlast+1)%(array.length-1);}

    }
    public T removeFirst(){
        if (size!=0){
            T res= array[0];
            T[] narray=  (T[]) new Object[size-1];
            System.arraycopy(array, 1,narray,0, size-1);
            size-=1;
            array=narray;
            return res;}
        return null;
    }
    public T removeLast(){
        if (size!=0){
            T oldback= array[nlast];
            T[] narray=  (T[]) new Object[size-1];
            System.arraycopy(array, 0,narray,0, size-1);
            size-=1;
            array=narray;
            return oldback;}
        return null;
    }

    public T get(int index){
    if (index>(size-1)) {return null;}
    else {return array[index];}

    }

    public boolean equals(Object o){return true;}

    public void printDeque(){
        T[] copy= {};
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

}
