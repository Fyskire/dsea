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

        /* 1a)
         * Angenommen unsere Queue hat eine Kapazität von 50. Dann ist die anfängliche Situation wie folgt:
         * head == 0
         * tail == 49
         * size == 0
         * capacity == 50
         *
         * Beim einfügen von n Elementen wird n mal das neue Element auf der Position direkt hinter tail eingefügt,
         * wobei zu beachten ist dass position 0 als Nachfolger der Position 49 behandelt wird.
         * Das erste Element wird also in Position 0 geschrieben, das zweite in 1 etc.
         * Bei jedem Einfügen werden tail und size inkrementiert.
         * Ist n>50, wird nach 50 eingefügten Elementen erkannt, dass die size==capacity ist
         * und direkt false zurückgegeben, anstatt ein weiteres Element einzufügen.
         *
         * Beim anschließenden Herausnehmen eines Elementes wird das Element auf der head position, also position 0,
         * zwischengespeichert, die position 0 im Array auf null gesetzt, die size um 1 verringert,
         * und head um 1 erhöht.
         *
         * Wird nun wieder ein Element hinzugefügt wird wieder auf die Position direkt hinter tail
         * das neue Element geschrieben und tail und size um eins erhöht.
         *
         * Bei jedem In- und Dekrementiervorgang von head und tail ist zu beachten,
         * dass die möglichen Positionen des Arrays wie ein Restklassenring über der Kapazität behandelt werden.
         * Der Vorgänger von 0 ist also (hier) 49, und der Nachfolger von (hier) 49 ist 0.
         */

        q = new MyQueue<Integer>(10);
        for (int i=0;i<15;i++) System.out.println(""+i+q.push(i));
        System.out.println(""+q.pop()+q.pop());
        q.push(99);
        q.push(100);
        q.print();
    }

}
