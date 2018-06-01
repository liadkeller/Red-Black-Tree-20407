/***
 * A node in a Red Black Tree
 ***/

public class Node {
    private int _key;
    private Node _p;
    private Node _right;
    private Node _left;
    private int _color;
    private boolean _nil; // is NIL? (A leaf)
    
    private final int BLACK = 0;
    private final int RED = 1;

    /***
     * Constructs a node
     * @param z The key of the node
     ***/
    public Node(int z)
    {
        _key = z;
        _nil = false;
    }
    
    /***
     * Constructs a leaf
     ***/
    public Node()
    {
        _key = 0;
        _nil = true;
        _color = BLACK;
    }
    
    /***
     * Copy constructor
     * @param other The other node
     ***/
    public Node(Node other)
    {
        this._key = other._key;
        this._p = other._p;
        this._right = other._right;
        this._left = other._left;
        this._nil = other._nil;
    }
    
    /***
     * Sets key
     * @param key The key
     ***/
    public void setKey(int key)
    {
        _key = key;
    }
    
    /***
     * Sets parent
     * @param p The parent
     ***/
    public void setParent(Node p)
    {
        _p = p;
    }
    
    /***
     * Sets right son
     * @param r The right son
     ***/
    public void setRight(Node r)
    {
        _right = r;
    }
    
    /***
     * Sets left son
     * @param l The left son
     ***/
    public void setLeft(Node l)
    {
        _left = l;
    }
    
    /***
     * Colors the node in red
     ***/
    public void setRed()
    {
        _color = RED;
    }
    
    /***
     * Colors the node in black
     ***/
    public void setBlack()
    {
        _color = BLACK;
    }
    
    /***
     * Checks if the node is red
     * @return return true if the node is red
     ***/
    public boolean isRed()
    {
        return _color == RED;
    }
    
    /***
     * Checks if the node is black
     * @return return true if the node is black
     ***/
    public boolean isBlack()
    {
        return _color == BLACK;
    }
    
    /***
     * Checks if the node is a leaf
     * @return returns true if the node is a leaf
     ***/
    public boolean isNil()
    {
        return _nil;
    }
    
    /***
     * @return returns the node key
     ***/
    public int getKey()
    {
        return _key;
    }

    /***
     * @return returns the node parent
     ***/
    public Node getParent()
    {
        return _p;
    }
    
    /***
     * @return returns the node right son
     ***/
    public Node getRight()
    {
        return _right;
    }
    
    /***
     * @return returns the node left son
     ***/
    public Node getLeft()
    {
        return _left;
    }
    
    /***
     * Generates a string of the node
     * @return returns a string with the node key
     ***/
    public String toString()
    {
        String s = "";
        s += _key;
        
        return s;
    }

    /***
     * Checks if the node is a left son of his parent
     * @return returns true if the node is a left son
     ***/
    public boolean isLeftSon()
    {
        return _p != null && _p.getLeft() != null && this.equals(_p.getLeft());
    }
    
    /***
     * Checks if the node is a right son of his parent
     * @return returns true if the node is a right son
     ***/
    public boolean isRightSon()
    {
        return _p != null && _p.getRight() != null && this.equals(_p.getRight());
    }
}
