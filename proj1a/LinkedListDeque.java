public class LinkedListDeque<Item> {

    private class Node{
    Node prev;
    Item item;
    Node next;
    public Node(Node prev,Item item,Node next){
        this.prev=prev;
        this.item=item;
        this.next=next;
        }
    public Node(){};

}
    private Node sentinel;
    int size;
    public LinkedListDeque(){
        sentinel=new Node();
        sentinel.item=null;
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public void addFirst(Item item){
        Node first=new Node(sentinel,item,sentinel.next);
        sentinel.next.prev=first;
        sentinel.next=first;
        size++;
    }
    public void addLast(Item item){
        Node last=new Node(sentinel.prev,item,sentinel);
        sentinel.prev.next=last;
        sentinel.prev=last;
        size++;
    }
    public boolean isEmpty(){
        return (sentinel.next==sentinel);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node p=sentinel;
        while(p.next!=sentinel){
            System.out.print(p.item+" ");
            p=p.next;
        }
        System.out.print(p.item);
    }
    public Item removeFirst(){
        if(sentinel.next==sentinel) return null;
        Item result=sentinel.next.item;
        sentinel.next.next.prev=sentinel;
        sentinel.next=sentinel.next.next;
        size--;
        return result;

    }
    public Item removeLast(){
        if(sentinel.next==sentinel) return null;
        Item result=sentinel.prev.item;
        sentinel.prev.prev.next=sentinel;
        sentinel.prev=sentinel.prev.prev;
        size--;
        return result;

    }
    public Item get(int i){
        if(i>=size || i<=0) return null;
        Node p=sentinel;
        while(i>=0){
            p=p.next;

        }
    return p.item;
    }
}
