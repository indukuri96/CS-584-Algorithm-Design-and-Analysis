public class MinEditLCS {

        static int editDistDP(String str1, String str2, int m, int n)
        {
            // Create a table to store results of subproblems
            int lcs = 0;
            int dp[][] = new int[m + 1][n + 1];


            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {

                    if (i == 0)
                        dp[i][j] = j;
                    else if (j == 0)
                        dp[i][j] = i;
                    else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];

                        // If the last character is different, consider all
                        // possibilities and find the minimum
                    else
                        dp[i][j] = 1 + min(dp[i][j - 1],
                                dp[i - 1][j],
                                dp[i - 1][j - 1]);
                }
            }

           lcs = (m +n - dp[m][n])/2;
            return lcs;
        }
    static int min(int x, int y, int z)
    {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

        public static void main(String args[]) {
            InputSource inputSource = new InputSource("src/file1.txt");
            String str = inputSource.inputString;
            InputSource1 inputSource1 = new InputSource1("src/file2.txt");
            String str2 = inputSource1.inputString;

            int m = str.length();
            int n = str2.length();
            long start = System.currentTimeMillis();
            System.out.println(n);
            System.out.println("Length of LCS is " +
                    editDistDP(str, str2, m, n));
            long end = System.currentTimeMillis();
            System.out.println("search takes " +  (end - start)*0.001 + "ms");
            Runtime runtime = Runtime.getRuntime();
            runtime.gc();
            // Calculate the used memory
            double memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Used memory is bytes: " + (memory)/1000000);
        }
    }

