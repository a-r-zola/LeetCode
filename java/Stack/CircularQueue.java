package Stack;

class CircularQueue {
    
    private int head;
    private int tail;
    private int size;
    private int count;
    private int elements[];

    public CircularQueue(int k) {
        elements = new int[k];
        head = tail = count = 0;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        elements[head] = value;
        count ++;
        head = (head + 1) % size;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        count --;
        tail = (tail + 1) % size;
        return true;
    }
    
    public int Front() {
        if(isEmpty())
            return -1;
        return elements[tail];
    }
    
    public int Rear() {
        if(isEmpty())
            return -1;
        return elements[(head + size -1) % size];
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == size;
    }

}

class TestCicrcularQueue{
    public static void main(String args[]){

        //CircularQueue myCircularQueue = new CircularQueue(3);

        // System.out.println(myCircularQueue.enQueue(1)); // return True
        // System.out.println(myCircularQueue.enQueue(2)); // return True
        // System.out.println(myCircularQueue.enQueue(3)); // return True
        // System.out.println(myCircularQueue.enQueue(4)); // return False
        // System.out.println(myCircularQueue.Rear());     // return 3
        // System.out.println(myCircularQueue.isFull());   // return True
        // System.out.println(myCircularQueue.deQueue());  // return True
        // System.out.println(myCircularQueue.enQueue(4)); // return True
        // System.out.println(myCircularQueue.Rear());     // return 4

        CircularQueue myCircularQueue = new CircularQueue(6);

        System.out.println(myCircularQueue.enQueue(6)); 
        System.out.println(myCircularQueue.Rear()); 
        System.out.println(myCircularQueue.Rear()); 
        System.out.println(myCircularQueue.deQueue()); 
        System.out.println(myCircularQueue.enQueue(5));
        System.out.println(myCircularQueue.Rear());   
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.Front()); 
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.deQueue());
    }
}