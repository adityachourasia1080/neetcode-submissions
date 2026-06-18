class MyCircularQueue {
     int element;
     int arr[];
     int front;
     int rear;
     int size;

    public MyCircularQueue(int k) {
        arr= new int[k];
        element=0;
        front=-1;
        rear=-1;
        size=k;
    }
    
    public boolean enQueue(int value) {
      if (isFull())  return false;
      rear=(rear+1)%size;
      arr[rear]=value;
      if (front==-1) front=0;
      element++;
      return true;
    }
    
    public boolean deQueue() {
        if (isEmpty())  return false;
        element--;
        front=(front+1)%size;
        return true;  
    }
    
    public int Front() {
        if (isEmpty()==false)  return arr[front];
        return -1;
    }
    
    public int Rear() {
         if (isEmpty()==false)  return arr[rear];
        return -1;
    }

    
    public boolean isEmpty() {
        if (element==0)  return true;
        return false;
    }

    
    public boolean isFull() {
        if (element==size)  return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */