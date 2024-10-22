package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(4);
        list.addAtLast(5);

        list.display();
        reverseList(list.getHead());
        System.out.println("-----");
        tail.display(head);
    }

    static Node tail;
    static Node head;

    static Node reverseList(Node node) {
        if (node.nextNode == null) {
            tail = node;
            head = tail;
            return head;
        }
        reverseList(node.nextNode);
        tail.nextNode = node;
        tail = node;
        tail.nextNode = null;

        return head;
    }
}