public class MyQueue<E> {
    private Object[] q;
    private int head, tail, size, capacity;

    public MyQueue(int capacity) {
        // TODO check for sensible input
        this.capacity = capacity;
        q = new Object[capacity];
        size = 0;
        head = 0;
        tail = capacity - 1;
    }

    public MyQueue() {
        this(50);
    }

    public boolean push(E e) {
        if (size == capacity) return false;
        tail++;
        if (tail == capacity) tail = 0;
        q[tail] = e;
        size++;
        return true;
    }

    public E pop() {
        if (size == 0) return null;
        @SuppressWarnings("unchecked")
        E e = (E) q[head];
        q[head] = null;
        head++;
        if (head == capacity) head = 0;
        size--;
        return e;
    }

    public int size() {
       return size;
    }

    public void print() {
        for (int i=0; i<size; i++) {
            System.out.println(q[(head+i)%capacity].toString());
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.push(4);
        q.push(5);
        q.push(0);
        q.push(3);
        q.pop();
        q.pop();
        q.push(2);
        q.push(10);
        q.print();

        q = new MyQueue<Integer>(10);
        for (int i=0;i<15;i++) System.out.println(""+i+q.push(i));
        System.out.println(""+q.pop()+q.pop());
        q.push(99);
        q.push(100);
        q.print();
    }

}
