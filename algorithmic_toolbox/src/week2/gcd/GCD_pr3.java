import java.util.*;

public class GCD_pr3 {
  private static int gcd(int a, int b) {
 //   int current_gcd = 1;
 //   for(int d = 2; d <= a && d <= b; ++d) {
 //     if (a % d == 0 && b % d == 0) {
 //       if (d > current_gcd) {
 //         current_gcd = d;
  //      }
 //     }
//    }
    if( b > a) {
        int c = a;
        a = b;
        b = c;
    }
    int mod = 1;
    while(mod != 0) {
       mod = a%b;
       a = b;
       b = mod; 
    }

    return a;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
