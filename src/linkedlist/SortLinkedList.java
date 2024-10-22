package linkedlist;

public class SortLinkedList {
    public static void main(String[] args) {
        LinkedList node = new LinkedList();
        node.addAtLast(2);
        node.addAtLast(8);
        node.addAtLast(1);
        node.addAtLast(7);
        node.addAtLast(6);
        node.addAtLast(7);
        node.addAtLast(3);
        Node head = sort(node.getHead());
        head.display(head);
    }

    static Node sort(Node node) {
        if (node == null || node.nextNode == null) {
            return node;
        }

        Node mid = MiddleElement.findMiddleElement(node);
        Node next = mid.nextNode;
        mid.nextNode = null;
        Node left = sort(node);
        Node right = sort(next);

        return mergeSortedTwoLists(left, right);
    }


    /**
     * todo: Merging two sorted linked list in order
     * */
    static Node mergeSortedTwoLists(Node list1, Node list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.value < list2.value) {
            list1.nextNode = mergeSortedTwoLists(list1.nextNode, list2);
            return list1;
        } else {
            list2.nextNode = mergeSortedTwoLists(list1, list2.nextNode);
            return list2;
        }
    }
}