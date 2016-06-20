import java.util.*;
import java.math.*;

public class DotProduct2 {
    private static long minDotProduct(int[] a, int[] b) {
        BigInteger sum = BigInteger.ZERO;
        
        List<BigInteger> aList = getList(a);
        List<BigInteger> bList = getList(b);

        Collections.sort(aList, Collections.reverseOrder());
        Collections.sort(bList);

        for(int i=0; i<aList.size(); i++) {
            sum = sum.add(aList.get(i).multiply(bList.get(i)));
        }
        return sum.longValue();
    }

    private static List getList(int[] a) {
        List<BigInteger> list = new ArrayList<>();
        for(int aa: a)
            list.add(BigInteger.valueOf(aa));
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(minDotProduct(a, b));
    }
}

