package Data_Strutures.Linked_List;

public class Main {

    public static void main(String[] args) {
        /* Start with the empty list. */
        LinkedList_Impl<Integer> list = new LinkedList_Impl<>();


        list.add(1);
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(6);

        System.out.println(list.toString());

        list.remove(1);

        list.remove(Integer.valueOf(2));
        // Print the LinkedList

        System.out.println(list.toString());
        System.out.println(list.size());



}

}
