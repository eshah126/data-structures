/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {
        this.root= null;   
        
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        if(this.root == null){
            this.root = newNode;
        }
        else {
            this.root.addNode();
        }
        
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)

    {
        Node curr = this.root;
        while(curr!=null){
            int diff = obj.compareTo(curr.data);
            if(diff==0){
                return true;
            }
            else if(diff <0 ){
                curr = curr.left;
            }//find the spot where the 
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        //need to find WHERE IT IS
        Node tobeRovNode = this.root;//
        Node parent = null;
        Boolean found = null;

        while(!found && tobeRovNode !=null){
            int diff = obj.compareTo(tobeRovNode)
            if(diff == 0){
                found = true;
            } else {
                parent = tobeRovNode;
                //moving further down the true
                if(diff<0){
                    tobeRovNode = tobeRovNode.left;
                }
            }
        }
     
        if(!found){
            return;
        }//nothing to find
        //case 1 and Case 2(at least one child is null)
        if(tobeRovNode.left == null || tobeRovNode.right == null) {
            Node newChild;
            if(tobeRovNode.left == null){
                newChild = tobeRovNode.right;
                else{
                    newChild = tobeRovNode.left;
                    
            }

            if(parent == null){
                this.root = newChild;
            }else if(parent.left == tobeRovNode){
                parent.left = newChild;
            } else
            parent.right = newChild;
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {    
        //A binary search tree must be made up of comparable objects
        public Comparable data;
        public Node left;
        public Node right;
        

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   //if diff id lesss than 0. the neNode is to the left, 
            //if Nenode> 0 newNode is to the right
            int diff = newNode.data.compareTo(data);
            if(diff<0){
                if(left==null){
                    left = newNode;
                }
                else{
                    left.addNode(newNode);
                }

            if(diff>0){//if it is grater than diff, or the copareable 
                if(right==null){
                    right = newNode;
                }
                else{
                    right.addNode(newNode);
                }

            }
        }
    }
}



