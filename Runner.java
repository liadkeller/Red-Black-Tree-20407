import java.util.Random;

/***
 * The main class which runs the program
 * @author Liad Keller
 ***/
public class Runner {
    public static void main(String[] args) {
        Random r = new Random();
        
        final int RAND = 1023;
        final int ARRAY_SIZE_1 = 200;
        final int ARRAY_SIZE_2 = 400;
        final int ARRAY_SIZE_3 = 800;
        final int TREE_SIZE_1 = 10;
        final int TREE_SIZE_2 = 50;
        final int TREE_SIZE_3 = 100;
        
        int[] A = new int[ARRAY_SIZE_1];
        int[] B = new int[ARRAY_SIZE_2];
        int[] C = new int[ARRAY_SIZE_3];
        
        for(int i = 0; i < A.length; i++)
            A[i] = r.nextInt(RAND);
        
        for(int i = 0; i < B.length; i++)
            B[i] = r.nextInt(RAND);
        
        for(int i = 0; i < C.length; i++)
            C[i] = r.nextInt(RAND);
        
        KMinTree A1 = new KMinTree(TREE_SIZE_1);
        KMinTree A2 = new KMinTree(TREE_SIZE_2);
        KMinTree A3 = new KMinTree(TREE_SIZE_3);

        KMinTree B1 = new KMinTree(TREE_SIZE_1);
        KMinTree B2 = new KMinTree(TREE_SIZE_2);
        KMinTree B3 = new KMinTree(TREE_SIZE_3);
        
        KMinTree C1 = new KMinTree(TREE_SIZE_1);
        KMinTree C2 = new KMinTree(TREE_SIZE_2);
        KMinTree C3 = new KMinTree(TREE_SIZE_3);
        
        
        System.out.println("k = 10:");
        System.out.println();
        
        int n = A.length;
        for(int i = 0; i < n; i++)
        {
            A1.insert(A[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - A");
                A1.printkMin();
                System.out.println();
            }   
        }
        
        n = B.length;
        for(int i = 0; i < n; i++)
        {
            B1.insert(B[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - B");
                B1.printkMin();
                System.out.println();
            }   
        }
        
        n = C.length;
        for(int i = 0; i < n; i++)
        {
            C1.insert(C[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - C");
                C1.printkMin();
                System.out.println();
            }   
        }

        
        System.out.println();
        System.out.println("k = 50:");
        System.out.println();
        
        n = A.length;
        for(int i = 0; i < n; i++)
        {
            A2.insert(A[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - A");
                A2.printkMin();
                System.out.println();
            }   
        }
        
        n = B.length;
        for(int i = 0; i < n; i++)
        {
            B2.insert(B[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - B");
                B2.printkMin();
                System.out.println();
            }   
        }
        
        n = C.length;
        for(int i = 0; i < n; i++)
        {
            C2.insert(C[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - C");
                C2.printkMin();
                System.out.println();
            }   
        }

        
        System.out.println();
        System.out.println("k = 100:");
        System.out.println();
        
        n = A.length;
        for(int i = 0; i < n; i++)
        {
            A3.insert(A[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - A");
                A3.printkMin();
                System.out.println();
            }   
        }
        
        n = B.length;
        for(int i = 0; i < n; i++)
        {
            B3.insert(B[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - B");
                B3.printkMin();
                System.out.println();
            }   
        }
        
        n = C.length;
        for(int i = 0; i < n; i++)
        {
            C3.insert(C[i]);
            
            if(i == n/4 || i == n/2 || i == 3*n/4)
            {
            	System.out.println("First " + i + " - C");
                C3.printkMin();
                System.out.println();
            }   
        }
    }   
}
