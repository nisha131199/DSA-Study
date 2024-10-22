package linkedlist;

public class MiddleElement {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(4);
        list.addAtLast(5);
        list.addAtLast(6);
        System.out.println(findMiddleElement(list.getHead()).value);
    }

    static Node findMiddleElement(Node node) {
        Node slow = node, fast = node;
        while (fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            if (fast != null) {
                slow = slow.nextNode;
            }
        }
        return slow;
    }
}