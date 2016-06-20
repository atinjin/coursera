import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
        //Problem 1. Changing Money
        //coins with denominations 1, 5, and 10
        //Output the minimum number of coins with denominations 1, 5, 10 that changes n.
        //Greedy Algorithm
        int number = 0;
        int[] changes = {10,5,1};
        for(int change: changes) {
            int count = n / change;
            n = n - (change * count);
            number+=count;
        }

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

