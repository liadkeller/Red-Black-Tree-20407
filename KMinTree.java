/***
 * The K Minimum Tree data structure contains an extended Red Black Tree
 * It supports 2 methods:
 * Insert,
 * Print minimum K values.
 ***/

public class KMinTree {
	RBTree _T;
	
	/***
	 * Constructs a Red Black Tree sized k
	 * @param k The total size of the tree
	 ***/
	public KMinTree(int k)
	{
		_T = new RBTree(k);
	}
	
	/***
	 * Prints the minimum k values in the tree
	 ***/
	public void printkMin()
	{
		_T.inorderWalk();
	}
	
	/***
	 * Inserts key to the tree
	 * @param x The new key
	 ***/
	public void insert(int x)
	{
		if (_T.isFull())
		{
			if (x < _T.getMax().getKey())
			{
				_T.delete(_T.getMax());
				_T.insert(x);
			}
		}
		
		else
			_T.insert(x);
	}
}
