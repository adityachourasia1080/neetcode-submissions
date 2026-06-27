class LRUCache {

    class Node{
        Node next;
        Node prev;
        int key;
        int value;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
            prev=null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    HashMap<Integer,Node>mp;

    private void add(Node temp){
        Node next= head.next;
        head.next= temp;
        temp.prev= head;
        next.prev=temp;
        temp.next=next;
    }

    private void remove(Node temp){
        Node prev= temp.prev;
        Node next= temp.next;
        prev.next= next;
        next.prev= prev;
    }

    public LRUCache(int capacity) {
        mp= new HashMap<>();
        head= new Node(-1,-1);
        tail= new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
         this.capacity= capacity;
    }


    
    public int get(int key) {

        if (!mp.containsKey(key))  return -1;

        Node temp= mp.get(key);
        remove(temp);
        add(temp);

        return temp.value;
        
    }
    
    public void put(int key, int value) {

        if (mp.containsKey(key)){
            Node temp = mp.get(key);
            remove(temp);
            temp.value= value;
            add(temp);
        }
        
        else{
        
            if (mp.size()==capacity){
                Node temp= tail.prev;
                mp.remove(temp.key);
                remove(temp);
            }

            Node naya = new Node(key,value);
            mp.put(key,naya);
            add(naya);
        }
        
    }
}
