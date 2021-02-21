package Data_Strutures.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Stack_Impl<E> {

    private Object[] elementData;
    private int top;
    private int initialCapacity = 10;

    Stack_Impl() {
        elementData = new Object[this.initialCapacity];
        this.top = -1;
    }

    public E push(E item) {
        if (top >= elementData.length-1) {
            this.ensureCapacity();
        }
        top = top + 1;
        elementData[top] = item;
        return item;
    }

    public E pop(){
        E item = null;
        if(top < 0){
            return item;
        }else{
            item = (E) elementData[top];
            top = top - 1;
        }
        return item;
    }

    public E peek(){
        E item = null;
        if(top < 0){
            return item;
        }else{
            item = (E) elementData[top];
        }
        return item;
    }

    private void ensureCapacity() {
        int newSize = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newSize);
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public void printStack(){
        System.out.print("Top:");
        for (int i = top; i >= 0; i--) {
            System.out.print(elementData[i] + "->");
        }
        System.out.println();
    }
}
