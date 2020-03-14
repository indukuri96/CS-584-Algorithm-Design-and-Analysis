import static java.lang.Integer.max;

public class Hirschberg {
    public Hirschberg() {}
    public int[] solve_lcs(int m, int n, String a, String b) {
        int[][] L = new int[2][n+1];
        for( int j=0; j<=n; j++) {
            L[1][j] = 0;
        }

        for(int i=1; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                L[0][j] = L[1][j];
            }

            for(int j=1; j<=n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    L[1][j] = L[0][j-1] + 1;
                }else{
                    L[1][j] = max(L[1][j-1], L[0][j]);
                }
            }
        }
        return L[1];

    }

    public String alg(int m, int n, String a, String b) {
        int i=0;
        int j=0;
        String c = "";

        if( n==0 ) {
            c = "";
        } else if( m==1 ) {
            c = "";
            for( j=0; j<n; j++ ) {
                if( a.charAt(0)==b.charAt(j) ) {
                    c= ""+a.charAt(0);
                    break;
                }
            }

        } else {
            i= (int) Math.floor(((double)m)/2);

            int[] l1 = solve_lcs(i, n, a.substring(0,i), b);
            int[] l2 = solve_lcs(m-i, n, reverseString(a.substring(i)), reverseString(b));

            int k = findK(l1, l2, n);

            String c1 = alg(i, k, a.substring(0, i), b.substring(0, k));
            String c2 = alg(m-i, n-k, a.substring(i), b.substring(k));

            c = c1+c2;
        }

        return c; //  LCS
    }

    public String reverseString(String in) {
        String out = "";

        for(int i=in.length()-1; i>=0; i--) {
            out = out+in.charAt(i);
        }

        return out;
    }

    public int findK(int[] l1, int[] l2, int n) {
        int m = 0;
        int k = 0;

        for(int j=0; j<=n; j++) {
            if(m < (l1[j]+l2[n-j])) {
                m = l1[j]+l2[n-j];
                k = j;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        InputSource inputSource = new InputSource("src/file1.txt");
        String str = inputSource.inputString;
        InputSource1 inputSource1 = new InputSource1("src/file2.txt");
        String str2 = inputSource1.inputString;
        System.out.println(str.length());
        System.out.println(str2.length());
                /*String x = "ABCDDEFG";
                String y = "ABDEBD";*/
        Hirschberg h = new Hirschberg();
        long start = System.currentTimeMillis();
        String z = h.alg(str.length(), str2.length(), str, str2);
        int lcs = z.length();
        System.out.println("lcs length"+lcs);
        System.out.println("LCS: " + h.alg(str.length(), str2.length(), str, str2));
        long end = System.currentTimeMillis();
        System.out.println("search takes " +  (end - start)*0.001 + "s");
        Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        double memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is mb: " + (memory)/1000000);
    }
}



