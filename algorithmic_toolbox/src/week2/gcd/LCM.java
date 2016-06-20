import java.util.*;

public class LCM {
  private static long gcd(long a, long b) {
     long orig_a = a;
     long orig_b = b;
     if( b > a) {
        long c = a;
        a = b;
        b = c;
    }
    long  mod = 1L;
    while(mod != 0L) {
       mod = a%b;
       a = b;
       b = mod; 
    }



    return orig_a * orig_b / a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
