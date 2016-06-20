import java.math.BigInteger;

public class Gcd {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        System.out.print("Input two numbers : ");
        BigInteger value1 = BigInteger.valueOf(scanner.nextNumber());
        BigInteger value2 = BigInteger.valueOf(scanner.nextNumber());
        
        BigInteger remainder = BigInteger.valueOf(1);
        while(remainder.compareTo(BigInteger.ZERO) ==  0) {
            remainder = value1.remainder(value2);
            value1 = value2;
            value2 = remainder;
            
        }

        System.out.println("Output : " + value1);

    }
    
}
