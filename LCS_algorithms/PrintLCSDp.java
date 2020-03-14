public class PrintLCSDp {


        static void lcs(String X, String Y, int m, int n)
        {
            int[][] L = new int[m+1][n+1];

            for (int i=0; i<=m; i++)
            {
                for (int j=0; j<=n; j++)
                {
                    if (i == 0 || j == 0)
                        L[i][j] = 0;
                    else if (X.charAt(i-1) == Y.charAt(j-1))
                        L[i][j] = L[i-1][j-1] + 1;
                    else
                        L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }

            // Following code is used to print LCS
            int index = L[m][n];
            int temp = index;


            char[] lcs = new char[index+1];
            lcs[index] = '\0';

            int i = m, j = n;
            while (i > 0 && j > 0)
            {

                if (X.charAt(i-1) == Y.charAt(j-1))
                {

                    lcs[index-1] = X.charAt(i-1);

                    i--;
                    j--;
                    index--;
                }

                else if (L[i-1][j] > L[i][j-1])
                    i--;
                else
                    j--;
            }


            // Print the lcs
            System.out.print("LCS of "+X+" and "+Y+" is ");
            for(int k=0;k<=temp;k++)
                System.out.print(lcs[k]);
        }

        // driver program
        public static void main (String[] args)
        {
            InputSource inputSource = new InputSource("src/file1.txt");
            String str = inputSource.inputString;
            InputSource1 inputSource1 = new InputSource1("src/file2.txt");
            String str2 = inputSource1.inputString;
           /* String X = "AGGTAB";
            String Y = "GXTXAYB";*/
            int m = str.length();
            int n = str2.length();
            /*System.out.println(m);
            System.out.println(n);*/

            long start = System.currentTimeMillis();
            lcs(str, str2, m, n);
            long end = System.currentTimeMillis();
            System.out.println("search takes " +  (end - start)*0.001 + "s");
            Runtime runtime = Runtime.getRuntime();
            // Run the garbage collector
            runtime.gc();
            // Calculate the used memory
            double memory = runtime.totalMemory() - runtime.freeMemory();
            System.out.println("Used memory is bytes: " + (memory)/1000000);
        }
    }

