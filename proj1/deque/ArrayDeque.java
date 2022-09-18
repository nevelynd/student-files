package deque;

public class ArrayDeque<T> {
    private int size=8;
    private int front;
    private int back;
    private T[] array;
    public ArrayDeque() {

        array = (T[]) new Object[8];
        size = 0;
    }
    public int size(){return size;}
    public boolean isEmpty() {return size==0;}

    //@Hug
    public void resize(int cap){
        T[] narray= (T[]) new Object[cap];
        System.arraycopy(array, 0,narray,0, size);
        array=narray;
    }
    public void addFirst(T item){
    resize(size+1);
    array[0]=item;
    }
    public void addLast(T item){
        resize(size+1);
        array[-1]=item;

    }
    public T removeFirst(){
        T res= array[0];
        T[] narray=  (T[]) new Object[size-1];
        System.arraycopy(array, 1,narray,0, size-1);
        array=narray;
        return res;
    }
    public T removeLast(){
        T res= array[-1];
        T[] narray=  (T[]) new Object[size-1];
        System.arraycopy(array, 0,narray,0, size-1);
        array=narray;
        return res;
    }

    public T get(int index){
    if (index>(size-1)) {return null;}
    else {return array[index];}

    }

    public boolean equals(Object o){return true;}

}
