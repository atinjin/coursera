import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Fibonacci {
	public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        System.out.print("Find the nth fibonacci number : ");
        int n = scanner.nextInt();
        
        BigInteger fn = BigInteger.valueOf(1);
        BigInteger fn_1 = BigInteger.valueOf(1);
        BigInteger fn_2 = BigInteger.valueOf(0);
        
        if(n < 0)
            System.out.println("Result : n shound be larger than 0");
        else if (n > 1)
            for(int i=0; i < n; i++) {
                fn = fn_1.add(fn_2);
                fn_2 = fn_1;
                fn_1 = fn;
            }
        System.out.println("Result : "+ fn);

	}

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
