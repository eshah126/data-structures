import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{
    /*the first variable that refers to the first node in the list
     * if the list is empty,first will be null
     */
    private Node first;
    public int count;




    /**
        Constructs an empty linked list.
    */
    public LinkedList(){
        this.first = null;
    }




    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */
    public Object getFist(){
        if (this.first == null){
            throw new NoSuchElementException();
        }
        return this.first.data;
    }






    /**
        Removes the first element in the linked list.
        @return the removed element
    */
    public Object removeFirst(){
        if(this.first == null){
            throw new NoSuchElementException();
        }
        Object element = this.first.data;
        this.first = this.first.next;
        return element; 


    }





    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
    public void addFirst(Object element){
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = this.first;
        this.first = newNode;

    }





    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */
    public ListIterator listIterator(){
        return new LinkedListIterator();
    }





    //Class Node
    //Node is a static class becuase it does'nt have to acess anything in the LinkList class
    static class Node {
        public Object data;
        public Node next;
    }


    class LinkedListIterator implements ListIterator
    {
      //private data
      private Node position;
      private Node previous;
      private boolean isAfterNext;



        /**
            Constructs an iterator that points to the front
            of the linked list.
        */
        public LinkedListIterator(){
            position = null;
            previous = null;
            isAfterNext = false;
        }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */
        public Object next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            previous = position;
            isAfterNext = true;

            if(position == null){
                //begining of the list
                position = first;

        }
        else {
            position = position.next;
            return position.data;
        }
    }





        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */
        public boolean hasNext(){
            //first check if list is empty
            if(position == null){
                return first != null; //if first is emmpty it would be null
            }
            return position.next != null;
        }


        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
        public void add(Object element){
            //check if it iterator is at the begining 
            if(position == null){
                addFirst(element);
                position = first;
            }
            else {
                Node newNode = new Node();
                newNode.data= element;
                newNode.next = position.next;
                position.next = newNode;
                //setting the next elemnt of the current position to point to the new node
                position = newNode;

            }
            isAfterNext = false;
        }






        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
            
        */
        public void remove(){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
            if (position == first){
                removeFirst();
                position = null;
            }else {
                previous.next = position.next;
                position = previous;
            }
            isAfterNext = false;

        }







        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */
        public void set(Object element){
            if(!isAfterNext){
                throw new IllegalStateException();
            }
                position.data = element;

            }
        }
        public int size(){
            while(hasNext()){
                count++;
            }



            return count;
        }


        private static int size(Node start){
            int size1 = 0;
            if(start != null){
                size1 = start.next();
                size(size1);
                
            }
            return size1;
        }


        public boolean contains(Object obj){
            while(next() != null){
                if(next().equals(obj)){
                    return true;
                }
                return false;
            }



            private static boolean contains(Node start, Object obj){
                
            }



        }








    }//LinkedListIterator
//LinkedList
