import static java.lang.Integer.max;

public class NaiveLCS {
        /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
        int lcs( char[] X, char[] Y, int m, int n )
        {
            if (m == 0 || n == 0)
                return 0;
            if (X[m-1] == Y[n-1])
                return 1 + lcs(X, Y, m-1, n-1);
            else
                return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
        }


        public static void main(String[] args)
        {

            String str = "ABCDEFGHIJKLMNOPQRSTUV";
            String s2 = "ABCDEFGHIJKABCDEFGHIJK";

            char[] X=str.toCharArray();
            char[] Y=s2.toCharArray();
            int m = X.length;
            int n = Y.length;
            System.out.println(m);
            System.out.println(n);

            long start = System.currentTimeMillis();

            NaiveLCS lcs = new NaiveLCS();
            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            System.out.println("Length of LCS is" + " " +
                    lcs.lcs( X, Y, m, n ) );
            long end = System.currentTimeMillis();
            System.out.println("search takes " +  (end - start)*0.001 + "seconds");
            long mem = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("memory consumed in MB" + (mem)/1000000);
        }

    }



