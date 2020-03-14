import java.util.Arrays;

public class MemoizedLCS {
    static int lcs(String X, String Y, int m, int n, Integer dp[][]) {
        // base case
        if (m == 0 || n == 0) {
            return 0;
        }

        // if the same state has already been
        // computed
        if (dp[m - 1][n - 1] != -1) {
            return dp[m - 1][n - 1];
        }

        // if equal, then store the value of the

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {


            dp[m - 1][n - 1] = 1 + lcs(X, Y, m - 1, n - 1, dp);

            return dp[m - 1][n - 1];
        } else {


            dp[m - 1][n - 1] = Math.max(lcs(X, Y, m, n - 1, dp),
                    lcs(X, Y, m - 1, n, dp));

            return dp[m - 1][n - 1];
        }
    }
    public static void main(String[] args)
    {
        InputSource inputSource = new InputSource("src/examplefile1.txt");
        String str = inputSource.inputString;
        InputSource1 inputSource1 = new InputSource1("src/examplefile2.txt");
        String str2 = inputSource1.inputString;

        int m = str.length();
        int n = str2.length();

        Integer[][] dp = new Integer[m + 1][n + 1];
        for (Integer[] row : dp) {
            Arrays.fill(row, -1);
        }

        long start = System.currentTimeMillis();
        MemoizedLCS m_lcs = new MemoizedLCS();

        System.out.println("Length of LCS is" + " " +
                m_lcs.lcs( str, str2, m, n , dp) );
        long end = System.currentTimeMillis();
        System.out.println("search takes " +  (end - start)*0.001 + "ms");
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        double memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + (memory)/1000000);
//            System.out.println("Used memory is megabytes: "
//                    + bytesToMegabytes(memory));
    }

}
