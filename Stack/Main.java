package Data_Strutures.Stack;

public class Main {

    public static void main(String[] args) {
        Stack_Impl<Integer> stack = new Stack_Impl<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.peek());
        System.out.println("POP: --> "+ stack.pop());
        System.out.println(stack.peek());

        stack.printStack();

        stack.push(10);

        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.isEmpty());
        stack.push(2);
        System.out.println(stack.isEmpty());

    }




}
