import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;
    static class Node
    {
        public Object data;
        public List<Node> children;


        

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 1;
            for(Node child:this.children){
                sum+=child.size();
            }
            return sum;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
        
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);

        
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() {
    {
        return this.root.size();
    }

    // Additional methods will be added in later section
    
}


public int leafCount(){
    if(root. children!=null){
        return leafCount(root);
    }
    return 0;
}

public int leafCount(Node n){//if size 0, return 0, caall the reccursive
     if(n.children.size() == 0){
        return 1;
     }
    int sum = 0;

    for(Node i:n.children){
        sum++;
    }
       


    return sum;

}}

