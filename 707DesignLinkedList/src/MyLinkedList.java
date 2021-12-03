class MyLinkedList {
    int size;
    Node head;

    class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

    }

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);

    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        Node ptr = head.next;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        return ptr.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);


    }

    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;
        Node ptr = head;
        Node temp = new Node(val);
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        temp.next = ptr.next;
        ptr.next = temp;
        ++size;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node ptr = head;
        for (int i = 0; i < index; ++i) {
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        --size;

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */