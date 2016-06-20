import java.util.Scanner;

public class Fibonacci_small {
  private static long calc_fib(int n) {
    long fn = 1;
    long fn_1 = 1;
    long fn_2 = 1;

    if(n <= 0)
       return 0;
    else if(n == 1 || n ==2)
        fn = 1;
    else if(n > 2) {
        for(int i=3; i<n+1; i++) {
            fn = fn_1 + fn_2;
            fn_2 = fn_1;
            fn_1 = fn;
        }
    }
    return fn;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
