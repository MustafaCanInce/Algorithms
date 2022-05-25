public class DoublyLinkedList<T extends Comparable> {
    private DNode<T> head;

    public DNode<T> createNode(T val){
        return new DNode<>(val);
    }
    public void addToFront(T val){

        DNode<T> temp=createNode(val);
        temp.next=head;
        if( head!=null) head.prev=temp;
        head=temp;
    }
    public void addToEnd(T val){
        DNode<T> iterator=head;
        if(head==null){
            head=createNode(val);
        }else {
            while (iterator.next != null) {
                iterator = iterator.next;
            }

            iterator.next = createNode(val);
            iterator.next.prev=iterator;
        }
    }

    public void deleteFromFront(){
        if(head!=null){
            if (head.next==null){
                head=null;
            }else{
                head=head.next;
                head.prev=null;
            }
        }
    }
    public void addAfterHead(T val){
        DNode<T> temp=createNode(val);
        if(head==null){
            head=temp;
        }else{
            temp.next=head.next;
            if (head.next!=null) temp.next.prev=temp;
            temp.prev=head;
            head.next=temp;
        }

    }

    public void display(){
        DNode<T> iterator=head;
        while(iterator!=null){
            System.out.println(iterator.value);
            iterator=iterator.next;
        }
    }
}
