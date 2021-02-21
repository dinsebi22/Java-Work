package Data_Strutures.Linked_List;

public class LinkedList_Impl<E> {

    private Node head;

    static class Node<E>{
        E data;
        Node next;

        // Constructor
        Node(E element){
            data = element;
            next = null;
        }
    }

    // Method to insert a new node
    public boolean add( E data){
        Node new_Node = new Node(data);
        new_Node.next = null;
        if(head == null){
            head = new_Node;
            return true;
        }else {
            Node last = head;
            while(last.next != null){
                last = last.next;
            }

            last.next = new_Node;
        }
        return true;
    }

    public void add(int index , E data){
        Node newNode = new Node(data);
        newNode.next = null;
        if(head == null){
            head = newNode;
        }else{
            Node wantedPos = head;
            int counter = 0;
            while(wantedPos != null) {
                wantedPos = wantedPos.next;
                counter++;
                if (counter == index) {
                    newNode.next = wantedPos.next;
                    wantedPos.next = newNode;
                    return;
                }
            }
        }
    }

    // Method to print the LinkedList.
    @Override
    public String toString(){
        Node currentNode = head;
        StringBuilder sb = new StringBuilder();

        sb.append("head(null)->");
        while(currentNode != null){
            sb.append(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }

    // Method to Delete node in the LinkedList by Key
    public boolean remove( E key){

        // Store head node
        Node currNode = head;
        Node prev = null;

        // CASE 1:
        // If head node itself holds the key to be deleted
        if(currNode != null && currNode.data.equals(key)){
            head = currNode.next;
            System.out.println(key.toString() +" found and deleted");
            return true;
        }

        // Case 2
        // If the key is somewhere other than at head
        while(currNode != null && !currNode.data.equals(key)){
            prev = currNode;
            currNode = currNode.next;
        }

        if(currNode != null){
            prev.next = currNode.next;
            System.out.println(key.toString() +" found and deleted");
            return true;
        }else{

            // CASE 3 Node not found;
            System.out.println(key + " not found");
            return false;
        }

    }

    // Method to delete a node in the LinkedList by POSITION
    public E remove(int index){
        Node currentNode = head;
        Node prev = null;

        // CASE 1:
        // If index is 0, then head node itself is to be deleted
        if(index == 0 && currentNode != null){
            head = currentNode.next;
            return (E) head.data;
        }

        // CASE 2:
        // If the index is greater than 0 but less than the size of LinkedList
        int counter = 0;
        while(currentNode != null){
            if(counter == index){
                prev.next = currentNode.next;
                System.out.println(index + " position element deleted");
                break;
            }else{
                prev = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
        }

        // CASE 3: The index is greater than the size of the LinkedList
        // In this case, the currNode should be null

        if(currentNode == null){
            System.out.println(index + " position element not found");
        }
        return (E) currentNode.data;

    }

    public E peek(){
        if(head.next != null){
            return (E) head.next.data;
        }
        return null;
    }

    public int size(){

        if(head.next == null){
            return 0;
        }

        Node current = head;
        int counter = 0;
        while(current != null){
            current = current.next;
            counter++;
        }
        return counter;
    }

}
