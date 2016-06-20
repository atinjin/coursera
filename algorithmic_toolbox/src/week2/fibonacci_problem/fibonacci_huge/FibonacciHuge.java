import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
    long fn = 1L;
    long fn_1 = 1L;
    long fn_2 = 1L;
    
    List<Long> pattern = new ArrayList<Long>();
    pattern.add(0L);
    pattern.add(1L);

    long size = 2L;

    for(int i=0; i < n+1; i++) {
        if(i==0)
         fn = 0L;
        else if(i==1) {
         fn = 1L;
         fn_1 = 0L;
        } else if(i>=2) {
         fn_2 = fn_1;
         fn_1 = fn;        
         fn = fn_1 + fn_2;
        }
        System.out.println(i+ "- fn_1:"+fn_1 + " fn_2:"+fn_2+" fn:"+fn);
        
        pattern.add(fn % m);
        if(i>1 && fn==1 && fn_1==0)
                size = i -1;
          
    }

    System.out.println("size ="+size);
    //return fn;
        long index = n % size;
        int xx = (int)index;
        return pattern.get(xx).longValue(); 
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

