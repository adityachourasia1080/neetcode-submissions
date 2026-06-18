class LRUCache {
    class pair{
        public int first;
        public int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    class Node{
        pair p;
        public Node next;
        public Node prev;
        public Node(pair p){
            this.p=p;
            next=null;
            prev=null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer,Node> mp;

    public LRUCache(int capacity) {
        head= new Node(new pair(0,0));
        tail=new Node(new pair(0,0));
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        mp= new HashMap<>();
    }

    private void delete(Node temp){
        Node prev= temp.prev;
        Node next= temp.next;
        mp.remove(temp.p.first);
        prev.next=next;
        next.prev=prev;
    }

    private void add(Node head,Node temp){
        Node next= head.next;
        head.next=temp;
        temp.prev=head;
        temp.next=next;
        next.prev=temp;
        mp.put(temp.p.first,temp);
    }
    
    public int get(int key) {
        if (!mp.containsKey(key))  return -1;
        Node temp= mp.get(key);
        delete(temp);
        add(head,temp);
        return temp.p.second;
    }
    
    public void put(int key, int value) {
        
        if (mp.containsKey(key)){
            Node temp= mp.get(key);
            delete(temp);
            temp.p.second=value;
            add(head,temp);
            return ;
        }
        pair p= new pair(key,value);

        if (capacity==0){
            delete(tail.prev);
        }
        else capacity--;
         add(head,new Node(p));
    }
}
