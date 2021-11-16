public class LRUCache {
    int size;
    ListNode dummy;
    ListNode tail;
    IDictionary<int, ListNode> keyToPrev;

    public LRUCache(int capacity) {
        this.size = capacity;
        this.keyToPrev = new Dictionary<int, ListNode>();
        this.dummy = new ListNode(-1,-1);
        this.tail = this.dummy;
    }
    
    public int Get(int key) {
        if(!keyToPrev.ContainsKey(key)){
            return -1;
        }
        kick(key);
        return tail.val;
    }
    
    public void Put(int key, int value) {
        if(keyToPrev.ContainsKey(key)){
            kick(key);
            tail.val = value;
        }else{
            pushBack(new ListNode(key, value));
            if(keyToPrev.Count > size){
                popFront();
            }
        }
    }

    private void pushBack(ListNode node){
        keyToPrev.Add(node.key, tail);
        tail.next = node;
        tail = node;
    }

    private void kick(int key){
        ListNode prevNode = keyToPrev[key];
        ListNode keyNode = prevNode.next;
        if(keyNode == tail){
            return;
        }
        keyToPrev.Remove(keyNode.key);
        prevNode.next = keyNode.next;
        keyToPrev[prevNode.next.key] = prevNode;
        keyNode.next = null;
        pushBack(keyNode);
    }

    private void popFront(){
        ListNode head = dummy.next;
        keyToPrev.Remove(head.key);
        keyToPrev[head.next.key] = dummy;
        dummy.next = head.next;
    }
}

public class ListNode{
    public int key { get; set; }
    public int val { get; set; }
    public ListNode next { get; set; }
    public ListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}