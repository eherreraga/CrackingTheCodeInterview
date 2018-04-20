public class Chapter2{
    public static void main(String[]args){
        LinkedList ll = new LinkedList();

        ll.insert("a");
        ll.insert("b");
        ll.insert("c");
        ll.insert("c");
        ll.insert("d");

        ll.print();
        System.out.println();
        System.out.println("Problem 2.2: "+ll.returnKthLast(2).data);
        System.out.println("Problem 2.6: "+ll.palindrome());
        System.out.println("Problem 2.8: "+ll.loopDetection());
        ll.deleteMiddleNode();
        System.out.print("Problem 2.3");ll.print();
        ll.removeDups();
        ll.print();

    }

      
}
class LinkedList{
    Node head, tail;


    public LinkedList(){
    }
    public void insert(String data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode; 
        }

    }
    public boolean isEmpty(){
        return (head == null);
    }

    public void print(){

        for(Node t = head; t != null; t = t.next){
            System.out.print(" -> "+t.data);
        }
    }
    
    /**Problem 2.1
     * R�mov� Dups! Write code to remove duplicates from an unsorted linked list.
     */
    public void removeDups(){
        Node slowNode = head;
        Node fastNode = head;

        while(fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            if(fastNode.next != null){
                fastNode = fastNode.next;
                if(slowNode.data == fastNode.data){
                    Node temp = slowNode.prev;
                    temp.next = slowNode.next;
                    while(temp.prev != head){
                        temp = temp.prev;
                    }
                    head = temp;
                }
            }
        }
    }

    /**Problem 2.3
     * Delete Middle Node: Implement an algorithm to delete a node in the middle 
     * (i.e., any node but the  rst and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
     */
    public void deleteMiddleNode(){
        Node fastNode = head;
        Node slowNode = head;

        //finding the middle
         while(fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
                if(fastNode.next != null){
                    fastNode = fastNode.next;
                }
                else break;
         }
         //deleting the middle
         slowNode = slowNode.prev;
         slowNode.next = slowNode.next.next;
         
         while(slowNode != head)
            slowNode = slowNode.prev;
        head = slowNode;
    }


    public int size(){
        Node fastNode = head;
        int counter = 0;

        while(fastNode.next != null){
            fastNode = fastNode.next.next;
            counter += 2;
        }
        return counter;
    } 
    
    /**Problem 2.2
     * Return Kth to Last: 
     * Implement an algorithm to  nd the kth to last element of a singly linked list.
     * 
     */
    public Node returnKthLast(int k){
        int index = (size() - k);
        Node temp = head;
        while(index != 0){
            index--;
            temp = temp.next;
        }
        return temp;
    }

    /**Problem 2.6
     * Palindrome: Implement a function to check if a linked list is a palindrome.
     * palindrome: the same fowards and backwards
     */
    public boolean palindrome(){
        Node tempHead = head;
        Node tempTail = tail;

        while(tempHead != tempTail){

            if(!(tempHead.data == tempTail.data)){
                return false;
            }
            tempHead = tempHead.next;
            tempTail = tempTail.prev;
        }

        return true;
    }
    
    /**Problem 2.8
     * Given a circular linked list, implement an algorithm that returns the node at the
        beginning of the loop.
     */
    public String loopDetection(){
        
        for(Node first = head; first != null; first = first.next){
            for(Node comp = first.next; comp != null; comp = comp.next){
                if(first.data == comp.data)
                    return first.data;
            }
        }
        return "";
        
    }

} 
class Node{
    String data;
    Node next, prev;
       
    public Node(String data){
       this.data = data;
       this.next = null;
       this.prev = prev;
        }
    }  