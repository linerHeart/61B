public class LinkedListDeque<T> {
    public class IntNode {
        IntNode prev;
        T t;
        IntNode next;

        public IntNode(IntNode p, T value, IntNode n) {
            prev = p;
            t = value;
            next = n;
        }
        public IntNode(IntNode p,IntNode n) {
            prev = p;
            next = n;
        }
    }
    int size;
    IntNode sentinel;
    public LinkedListDeque(){
        size=0;
        sentinel=new IntNode(null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }
    public void addFirst(T item){
        size=size+1;
        IntNode first = new IntNode(sentinel,item,sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
    }
    public void addLast(T item){
        size=size+1;
        IntNode last = new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        IntNode p = sentinel.next;
        while(p!=sentinel){
            System.out.println(p.t);
            p = p.next;
        }
    }

    public T removeFirst(){
        T hello = sentinel.next.t;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        return hello;
    }
    public T removeLast(){
        T hello = sentinel.prev.t;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return hello;
    }
    public T get(int index){
        IntNode p = sentinel.next;
        while(index>0){
            p = p.next;
        }
        return p.t;
    }
    private  T getRecursive(IntNode node,int index){
        if(node==null){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if(index==0){
            return node.t;
        }
        return getRecursive(node.next,index-1);
    }
    public T getRecursive(int index){
        return getRecursive(sentinel.next,index);
    }
}
