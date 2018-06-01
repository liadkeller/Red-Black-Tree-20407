/***
 * Extended Red Black Tree with few more data fields:
 * Maximal node in the tree (by key)
 * Total size of the tree, as defined while creating the tree
 * Current size - The current number of nodes in the tree
 ***/

public class RBTree {
    private Node _root;
    private Node _max;
    private int _size; // The current number of nodes in the tree
    private int _total; // The maximum size of the tree

    /***
     * Constructs a new empty tree sized k (total size).
     * @param k Total size of the tree
     ***/
    public RBTree(int k)
    {
        _root = null;
        _size = 0;
        _total = k;
    }
    
    /***
     * Inserts key to the tree while keeping a fixed Red Black Tree
     * @param k The new key
     ***/
    public void insert(int k)
    {
        Node x = _root;
        Node y = null;
        Node z = new Node(k);
        
        while (x != null && !x.isNil())
        {
            y = x;
            if (k < x.getKey())
                x = x.getLeft();
            else
                x = x.getRight();
        } // finds the parent of z (y)
        
        z.setParent(y);
        if (y == null)
            _root = z;
   
        else if (k < y.getKey())
            y.setLeft(z);
        
        else
            y.setRight(z);
        
        z.setLeft(null);
        z.setRight(null);
        z.setRed();
        insertFix(z);
         
        if(_size == 0)
        {
            _max = z;
            _size++;
        }
        
        else if(_size < _total) // case 1
        {
            _size++;
            if(k > _max.getKey())
                _max = z;
        }
        
        if(_size == _total) // case 2
            _max = maximum(_root);
    }
    
    // After positioning the new node,
    // the method will fix the coloring
    private void insertFix(Node z)
    {
        Node y;
        
        while (z.getParent() != null && z.getParent().isRed())
        {
            if(z.getParent().getParent() == null);
            // Only violation is between the red root and his red son. the root will turn black and the tree will be fixed
            
            else if (z.getParent().isLeftSon())
            {
                y = z.getParent().getParent().getRight(); // right uncle
                
                if(y == null) // if right uncle doesnt exsist, generates a NIL as an uncle
                {
                    y = new Node();
                    z.getParent().getParent().setRight(y);
                    y.setParent(z.getParent().getParent());
                }
                
                if (y.isRed())
                {
                    z.getParent().setBlack();
                    y.setBlack();
                    z.getParent().getParent().setRed();
                    z = z.getParent().getParent(); // jumps up two rows
                }
                
                else if (y.isBlack())
                {
                    if (z.isRightSon())
                    {
                        z = z.getParent();
                        leftRotate(z);
                    }
                    
                    if (z.isLeftSon())
                    {
                        z.getParent().setBlack();
                        z.getParent().getParent().setRed();
                        rightRotate(z.getParent().getParent());
                    }
                }
                
            }
            
            else if (z.getParent().isRightSon())
            {
                y = z.getParent().getParent().getRight(); // Left uncle
                
                if(y == null) // if Left uncle doesnt exsist, generates a NIL as an uncle
                {
                    y = new Node();
                    z.getParent().getParent().setLeft(y);
                    y.setParent(z.getParent().getParent());
                }
                
                if (y.isRed())
                {
                    z.getParent().setBlack();
                    y.setBlack();
                    z.getParent().getParent().setRed();
                    z = z.getParent().getParent(); // jumps up two rows
                }
                
                else if (y.isBlack())
                {
                    if (z.isLeftSon())
                    {
                        z = z.getParent();
                        rightRotate(z);
                    }
                    
                    if (z.isRightSon())
                    {
                        z.getParent().setBlack();
                        z.getParent().getParent().setRed();
                        leftRotate(z.getParent().getParent());
                    }
                }
            }
        }
        
        _root.setBlack();
    }
    
    /***
     * Deletes a node from the tree
     * @param d The node to delete
     ***/
    public void delete(Node d)
    {
        Node x, y;
        
        if (d.getLeft() == null && d.getRight() == null)
            y = d;
        else if (d == _max)
            y = d;
        else
            y = suc(d);
        
        if (d.getLeft() != null && !d.getLeft().isNil())
            x = y.getLeft();
        else
            x = y.getRight();
        
        if (x != null)
        {
            if(x.isNil())
                x = null;
                
            else
                x.setParent(y.getParent());
        }
        
        if (y.getParent() == null || y.isNil())
            _root = x;
        else if(y.isLeftSon())
            y.getParent().setLeft(x);   
        else
            y.getParent().setRight(x);
        
        if (y != d)
            d.setKey(y.getKey());
        
        if (y.isBlack() && x != null && !x.isNil())
            deleteFix(x);
        // original code returns y
    }
    
    // fixes the coloring after deleting the node
    private void deleteFix(Node x) {
        Node w, l, r;
        while (x != _root && x.isBlack())
        {
            if (x.isLeftSon())
            {
                w = x.getParent().getRight(); // right brother
                
                if(w == null || w.isNil())
                    break;
                
                if (w.isRed())
                {
                    w.setBlack();
                    x.getParent().setRed();
                    if(x.getParent().getRight() != null && !x.getParent().getRight().isNil())
                        leftRotate(x.getParent());
                    w = x.getParent().getRight();
                }
                
                if(w.getLeft() == null) // if left son doesnt exsist, generates a NIL as a left son
                {
                    l = new Node();
                    w.setLeft(l);
                    l.setParent(w);
                }
                
                if(w.getRight() == null) // if right son doesnt exsist, generates a NIL as a right son
                {
                    r = new Node();
                    w.setRight(r);
                    r.setParent(w);
                }
                
                if(w.getLeft().isBlack() && w.getRight().isRed())
                {
                    w.setRed();
                    x = x.getParent();
                }
                
                else if (w.getRight().isBlack())
                {
                    w.getLeft().setBlack();
                    w.setRed();
                    if(w.getLeft() != null && !w.getLeft().isNil())
                        rightRotate(w);
                    w = x.getParent().getRight();
                }
                
                copyColor(x.getParent(), w);
                if(x.getParent() != null)
                    x.getParent().setBlack();
                w.getRight().setBlack();
                if(x.getParent() != null && x.getParent().getRight() != null && !x.getParent().getRight().isNil())
                    leftRotate(x.getParent());
                x = _root;
            }
            
            else if (x.isRightSon())
            {
                w = x.getParent().getLeft(); // left brother
                
                if(w == null || w.isNil())
                    break;
                
                if (w.isRed())
                {
                    w.setBlack();
                    x.getParent().setRed();
                    if(x.getParent().getLeft() != null && !x.getParent().getLeft().isNil())
                        rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                }
                
                if(w.getLeft() == null) // if left son doesnt exsist, generates a NIL as a left son
                {
                    l = new Node();
                    w.setLeft(l);
                    l.setParent(w);
                }
                
                if(w.getRight() == null) // if right son doesnt exsist, generates a NIL as a right son
                {
                    r = new Node();
                    w.setRight(r);
                    r.setParent(w);
                }
                
                if(w.getLeft().isBlack() && w.getRight().isRed())
                {
                    w.setRed();
                    x = x.getParent();
                }
                
                else if (w.getLeft().isBlack())
                {
                    w.getRight().setBlack();
                    w.setRed();
                    if(w.getRight() != null && !w.getRight().isNil())
                        leftRotate(w);
                    w = x.getParent().getLeft();
                }
                
                copyColor(x.getParent(), w);
                if(x.getParent() != null)
                    x.getParent().setBlack();
                w.getLeft().setBlack();
                if(x.getParent() != null && x.getParent().getLeft() != null && !x.getParent().getLeft().isNil())
                    rightRotate(x.getParent());
                x = _root;
            }
        }
    }

    // left rotate - according to the book
    private void leftRotate(Node x)
    {
        Node y = x.getRight();
        Node l;
        
        if(y == null)
        {
            _root = x;
            return;
        }
        
        if(y.getLeft() == null) // if left son doesnt exsist, generates a NIL as a left son
        {
            l = new Node();
            y.setLeft(l);
            l.setParent(y);
        }
        
        x.setRight(y.getLeft());
        if (y.getLeft() != null)
            y.getLeft().setParent(x);
        
        y.setParent(x.getParent());
        if (x.getParent() == null)
            this._root = y;
        
        else if (x.isLeftSon())
            x.getParent().setLeft(y);
        
        else if (x.isRightSon())
            x.getParent().setRight(y);
        
        y.setLeft(x);
        x.setParent(y);
    }
    
    // right rotate - according to the book
    private void rightRotate(Node x)
    {
        Node y = x.getLeft();
        Node r;
        
        if(y == null)
        {
            _root = x;
            return;
        }
        
        if(y.getRight() == null) // if right son doesnt exsist, generates a NIL as a right son
        {
            r = new Node();
            y.setRight(r);
            r.setParent(y);
        }
        
        x.setLeft(y.getRight());
        if (y.getRight() != null)
            y.getRight().setParent(x);
        
        y.setParent(x.getParent());
        if (x.getParent() == null)
            this._root = y;
        
        else if (x.isLeftSon())
            x.getParent().setLeft(y);
        
        else if (x.isRightSon())
            x.getParent().setRight(y);
        
        y.setRight(x);
        x.setParent(y);
    }
    
    // finds the maximal node in the tree
    private Node maximum(Node x)
    {
        while(x.getRight() != null && !x.getRight().isNil())
            x = x.getRight();
        return x;
    }
    
    // finds the minimal node in the tree
    private Node minimum(Node x)
    {
        while(x.getLeft() != null && !x.getLeft().isNil())
            x = x.getLeft();
        return x;
    }
    
    // private method -
    // finds the succesor of a node x
    private Node suc(Node x) {
        if (x.getRight() != null)
            return minimum(x.getRight());
        
        Node y = x.getParent();
        while (y != null && x.equals(y.getRight()))
        {
            x = y;
            y = y.getParent();
        }
        
        return y;
    }
    
    /***
     * Inorder Walk on the tree
     ***/
    // the first call of the Inorder Walk
    public void inorderWalk()
    {
        inorderWalk(_root);
    }
    
    // inorderWalk - according to the book
    private void inorderWalk(Node x)
    {
        if (x != null)
        {
            inorderWalk(x.getLeft());
            if(!x.isNil()) // print x if and only if x isnt null or NIL
                System.out.println(x);
            inorderWalk(x.getRight());
        }
    }
    
    // private method -
    // copies the color from x to y
    private void copyColor(Node x, Node y)
    {
        if(x != null && x.isBlack())
            y.setBlack();
        
        else
            y.setRed();
    }
    
    // returns the maximal node saved in the tree
    public Node getMax()
    {
        return _max; // returns max and not a copy of max
    }
    
    // returns if the true is full
    public boolean isFull()
    {
        return _size == _total;
    }
}
