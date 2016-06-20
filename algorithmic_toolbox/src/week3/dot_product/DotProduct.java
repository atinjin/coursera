import java.util.*;

public class DotProduct {
    private static long minDotProduct(int[] a, int[] b) {
        //write your code here
        //(-) (+) 가장 큰 수 조합으로
        //같은 부호는 가장 작은 수 조합으로
        List<Integer> a_positive = new ArrayList();
        List<Integer> a_negative = new ArrayList();
        List<Integer> b_positive = new ArrayList();
        List<Integer> b_negative = new ArrayList();
        
        get(a, a_positive, a_negative);
        get(b, b_positive, b_negative);

        Collections.sort(a_positive);
        Collections.sort(a_negative);
        Collections.sort(b_positive);
        Collections.sort(b_negative);
        int sum = 0;
        for(int i=a_positive.size()-1; i>=0; i--) {
//            System.out.println("sum = " + sum);
            if(b_negative.size() > 0) {
                sum = sum  +  a_positive.get(i) * b_negative.get(b_negative.size()-1);
                b_negative.remove(b_negative.size()-1);
                continue;
            }else{
                sum = sum +  a_positive.get(i) * b_positive.get(0);
                b_positive.remove(0);
                continue;
            }
        }
        for(int i=a_negative.size()-1; i>=0; i--) {
//            System.out.println("sum = " + sum);
            if(b_positive.size() > 0) {
                sum = sum  +  a_negative.get(i) * b_positive.get(b_positive.size()-1);
                b_positive.remove(b_positive.size()-1);
                continue;
            }else{
                sum = sum +  a_negative.get(i) * b_negative.get(0);
                b_positive.remove(0);
                continue;
            }
        }

        return sum;
    }

    private static void get(int[] a, List<Integer> a_positive, List<Integer> a_negative) {
        for(int aa: a) {
            if(aa >= 0)
                    a_positive.add(aa);
            else
                    a_negative.add(aa);
        }

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

