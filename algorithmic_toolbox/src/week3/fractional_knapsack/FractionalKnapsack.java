import java.util.Scanner;
import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] valueIn, int[] weightIn) {
        double value = 0;
        List<Integer> values = toList(valueIn);
        List<Integer> weights = toList(weightIn);

        //Fill the values
        while(true) {
            int i = findMax(values, weights);
            int w = weights.get(i);
            int v = values.get(i);
            values.remove(i);
            weights.remove(i);

            int min = (w<capacity)?w:capacity;
            capacity-=min;
            value = value + min * (v/w);

 //           System.out.println("w, cap : " +w+ ", "+capacity);
            if(capacity == 0 || values.size() ==0)
                    break;
        }

        return value;
    }

    private static List<Integer> toList(int[] in) {
        List<Integer> result = new ArrayList<Integer>(in.length);
        for(int i : in) {
            result.add(i);
        }
        return result;
    }

    private static int findMax(List<Integer> values, List<Integer> weights) {
        int maxIndex = 0;
        double maxValue = 0.0;
        for(int i=0; i<values.size();i++) {
            double valPerWeight = values.get(i) / weights.get(i);
            if(maxValue < valPerWeight) {
                maxValue = valPerWeight;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        String result = String.format("%.4f", getOptimalValue(capacity, values, weights));
        System.out.println(result);
    }

} 
