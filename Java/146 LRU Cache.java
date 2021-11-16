class LRUCache {
     int capacity;
     Map<Integer, Node> mapToPrev;
     Node dummy;
     Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mapToPrev = new HashMap<Integer, Node>();
        this.dummy = new Node(0,0);
        this.tail = dummy;
    }
    
    public int get(int key) {
        if(!mapToPrev.containsKey(key))
            return -1;
        kick(key);
        return tail.val;
    }
    
    public void put(int key, int value) {
        if(mapToPrev.containsKey(key)){
            kick(key);
            tail.val = value;
        }else{
            Node newNode = new Node(key, value);
            pushBack(newNode);
            if(mapToPrev.size() > capacity){
                popFront();
            }
        }
    }
    
    private void pushBack(Node node){
        mapToPrev.put(node.key, tail);
        tail.next = node;
        tail = node;
    }
    
	//kick the key node to the tail
    private void kick(int key){
        Node prevNode = mapToPrev.get(key);
        Node currNode = prevNode.next;
        if(currNode == tail){
            return;
        }
        prevNode.next = currNode.next;
        mapToPrev.put(prevNode.next.key,prevNode);
        currNode.next = null;
        pushBack(currNode);
    }
    
    private void popFront(){
        Node head = dummy.next;
        mapToPrev.remove(head.key);
        mapToPrev.put(head.next.key, dummy);
        dummy.next = head.next;
    }
}

class Node{
     int key;
     int val;
     Node next;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }
}
