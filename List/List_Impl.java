package Data_Strutures.List;

import java.util.Arrays;

public class List_Impl<E> {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    //Default Constructor
    public List_Impl(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Add Method
    public void add(E e){
        if(size == elements.length){
            ensureCapacity();
        }
        elements[size++] = e;
    }

    // Get Method
    @SuppressWarnings("unchecked")
    public E get(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds at index: " + i );
        }
        return (E) elements[i];
    }

    // Remove method
    public E remove(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("Index out of bounds at index: " + i );
        }
        Object item = elements[i];
        int numElements = size - (i+1);
        System.arraycopy(elements, i + 1, elements, i , numElements);
        size--;
        return (E) item;
    }

    // Get size of List
    public int size(){
        return size;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i].toString());
            if(i < size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

}
