package linkedlist;

public class LinkedListPractice {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addAtStart(1);
        list.addAtStart(1);
        list.addAtStart(1);
        list.addAtStart(1);
        list.addAtStart(1);
        list.addAtStart(1);
        list.addAtStart(2);
        list.addAtStart(3);
        list.addAtLast(4);
        list.addAtLast(5);
        list.addAtLast(6);

        list.display();
        System.out.println("----------");
        list.removeAtStart();
        list.removeAtLast();
        list.display();
        System.out.println("----------");
        list.removeAtIndex(3);
        list.display();
        System.out.println("----------");
        list.insertAtIndexRecursion(200, 1, list.getHead());
        list.display();
        System.out.println("----------");
        list.deleteDuplicates(list.getHead());
        list.display();
        System.out.println("----------");
        System.out.println("----------");
        LinkedList list1 = new LinkedList();
        list1.addAtLast(1);
        list1.addAtLast(2);
        list1.addAtLast(3);
        list1.addAtLast(9);
        list1.display();
        System.out.println("----------");
        LinkedList list2 = new LinkedList();
        list2.addAtLast(0);
        list2.addAtLast(1);
        list2.addAtLast(6);
        list2.addAtLast(8);
        list2.display();
        System.out.println("----------");
        list1.mergeSortedTwoLists(list1.getHead(), list2.getHead());


        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("----------");
        LinkedList list3 = new LinkedList();
        list3.addAtLast(1);
        list3.addAtLast(2);
        list3.addAtLast(3);
        list3.addAtLast(9);
        list3.addAtLast(6);
        list3.addAtLast(5);
        list3.addAtLast(8);
        list3.addAtLast(4);
        list3.getTail().nextNode = list3.getNodeAtIndex(3, list3.getHead());
        list3.display();
        System.out.println("----has cycle-----");
        System.out.println(list3.hasCycle(list3.getHead()));
        System.out.println("----length of cycle-----");
        System.out.println(list3.lengthOfCycle(list3.getHead()));
        System.out.println("----start value of cycle-----");
        System.out.println(list3.startOfCycle(list3.getHead()).value);
        System.out.println("----------");
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    Node getNodeAtIndex(int index, Node node) {
        if (index == 0) {
            return node;
        }
        return getNodeAtIndex(--index, node.nextNode);
    }

    void addAtStart(int value) {
        if (size == 0) {
            Node item = new Node(null, value, null);
            head = item;
            tail = item;
            size ++;
            return;
        }

        Node item = new Node(null, value, head);
        head.previousNode = item;
        head = item;

        size ++;
    }

    void addAtLast(int value) {
        if (size == 0) {
            Node item = new Node(null, value, null);
            head = item;
            tail = item;
            size ++;
            return;
        }

        Node item = new Node(tail, value, null);
        tail.nextNode = item;
        tail = item;

        size ++;
    }

    void display() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.value);
            temp = temp.nextNode;
        }
    }

    void removeAtStart() {
        if (size <= 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        head.nextNode.previousNode = null;
        head = head.nextNode;

        size --;
    }

    void removeAtLast() {
        if (size <= 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        tail.previousNode.nextNode = null;
        tail = tail.previousNode;

        size --;
    }

    void removeAtIndex(int index) {
        if (size <= index) {
            return;
        }

        if (index == 0) {
            head.nextNode.previousNode = null;
            head = head.nextNode;
            size --;
            return;
        }

        if (index == size - 1) {
            tail.previousNode.nextNode = null;
            tail = tail.previousNode;
            size --;
            return;
        }

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.nextNode;
        }

        // todo : now temp have the indexed node
        temp.previousNode.nextNode = temp.nextNode;
        temp.nextNode.previousNode = temp.previousNode;

        size --;
    }

    void insertAtIndexRecursion(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(node.previousNode, value, node);
            node.previousNode.nextNode = temp;
            node.previousNode = temp;
            size ++;
            return;
        }
        insertAtIndexRecursion(value, --index, node.nextNode);
    }

    /**
     * todo: delete duplicate items
     * */
    void deleteDuplicates(Node node) {
        if (node.nextNode == null) {
            return;
        }
        if (node.value == node.nextNode.value) {
            node.nextNode = node.nextNode.nextNode;
            size --;
            deleteDuplicates(node);
        }
        deleteDuplicates(node.nextNode);
    }

    /**
     * todo: Merging two sorted linked list in order
     * */
    static void mergeSortedTwoLists(Node list1, Node list2) {
        Node temp = new Node(null, 0, null);

        while (list1 != null && list2 != null) {
            if (list2.value < list1.value) {
                temp.nextNode = list2;
                list2 = list2.nextNode;
            } else {
                temp.nextNode = list1;
                list1 = list1.nextNode;
            }
            temp.nextNode.previousNode = temp;
            temp = temp.nextNode;
        }
        while (list1 != null) {
            temp.nextNode = list1;
            temp.nextNode.previousNode = temp;
            temp = temp.nextNode;
            list1 = list1.nextNode;
        }
        while (list2 != null) {
            temp.nextNode = list2;
            temp.nextNode.previousNode = temp;
            temp = temp.nextNode;
            list2 = list2.nextNode;
        }
        temp.nextNode = null;

        Node temp2 = temp;
        while (temp2.previousNode != null) {
            System.out.println(temp2.value);
            temp2 = temp2.previousNode;
        }
    }

    /**
     * todo: find cycle in list
     * */
    boolean hasCycle(Node node) {
        Node slow = node;
        Node fast = node;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * todo: find cycle length
     * */
    int lengthOfCycle(Node node) {
        Node slow = node;
        Node fast = node;
        int length = 0;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) {
                return getLength(slow);
            }
        }

        return length;
    }

    /**
     * todo: length of a node
     * */
    int getLength(Node node) {
        Node slow = node;
        Node fast = node;
        int length = 0;
        do {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            length++;
        } while (slow != fast);
        return length;
    }

    /**
     * todo: find the initiate node from which cycle starts
     * */
    Node startOfCycle(Node node) {
        Node slow = node;
        Node fast = node;
        int length = 0;

        while (fast != null && fast.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast) {
                length = getLength(slow);
                break;
            }
        }

        Node first = node;
        Node second = node;

        while (length-- > 0) {
            second = second.nextNode;
        }

        while (first != second) {
            first = first.nextNode;
            second = second.nextNode;
        }

        return first;
    }
}

class Node {
    int value;
    Node nextNode;
    Node previousNode;

    public Node(Node previousNode, int value, Node nextNode) {
        this.value = value;
        this.previousNode = previousNode;
        this.nextNode = nextNode;
    }

    void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.nextNode;
        }
    }
}