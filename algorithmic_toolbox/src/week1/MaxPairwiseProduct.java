import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(int[] numbers) {
        int[] maxNumbers = new int[2];
        for(int num: numbers) {
//            System.out.println("input = "+ num);
            if(maxNumbers[0] <= num) {
                maxNumbers[1] = maxNumbers[0];
                maxNumbers[0] = num;
//                System.out.println("Set at max =" + maxNumbers[0] + ", "+ maxNumbers[1]);
            } else if(maxNumbers[1] <= num) {
                maxNumbers[1] = num;
            }
        }

        BigInteger result = BigInteger.valueOf(maxNumbers[0]).multiply(BigInteger.valueOf(maxNumbers[1]));
        return result;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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