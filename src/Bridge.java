
public class Bridge {

    private int maxSize;
    public Soldier[] queArray;
    public int front;
    private int rear;
    private int nItems;
//--------------------------------------------------------------

    public Bridge(int s) { // constructor

        maxSize = s;
        queArray = new Soldier[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
//--------------------------------------------------------------

    public void insert(Soldier j) { // put item at rear of queue

        if (rear == maxSize - 1) // deal with wraparound
        {
            rear = -1;
        }
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
//--------------------------------------------------------------

    public Soldier remove() { // take item from front of queue

        Soldier temp = queArray[front++]; // get value and incr front
        if (front == maxSize) // deal with wraparound
        {
            //front = 0;
        }
        nItems--;                      // one less item
        return temp;
    }
//--------------------------------------------------------------

    public Soldier peekFront() { // peek at front of queue

        return queArray[front];
    }
//--------------------------------------------------------------

    public boolean isEmpty() { // true if queue is empty

        return (nItems == 0);
    }
//--------------------------------------------------------------

    public boolean isFull() { // true if queue is full

        return (nItems == maxSize);
    }
//--------------------------------------------------------------

    public int size() { // number of items in queue

        return nItems;
    }
}
