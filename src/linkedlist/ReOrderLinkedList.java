package linkedlist;

public class ReOrderLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtLast(1);
        list.addAtLast(2);
        list.addAtLast(3);
        list.addAtLast(4);
        list.addAtLast(5);
        list.addAtLast(6);

        Node head = reorderList(list.getHead());
        head.display(head);
    }

    static Node reorderList(Node node) {
        Node mid = MiddleElement.findMiddleElement(node);
        Node secondList = ReverseLinkedList.reverseList(mid.nextNode);
        mid.nextNode = null;

        return mergeSortedTwoLists(node, secondList);
    }

    /**
     * todo: Simply merge two lists
     * */
    private static Node mergeSortedTwoLists(Node left, Node right) {
        Node head = left;
        Node temp = null;
        while (left != null && right != null) {
            temp = left.nextNode;
            left.nextNode = right;
            left = temp;

            temp = right.nextNode;
            right.nextNode = left;
            right = temp;
        }

        if (left != null) {
            left.nextNode = temp;
        }
        return head;
    }
}