import java.util.*;
import java.math.*;

public class FractionalKnapsack2 {
    private static double getOptimalValue(int cap, int[] valueIn, int[] weightIn) {
        BigDecimal capacity = BigDecimal.valueOf(cap);
        BigDecimal value = BigDecimal.ZERO;
        List<Integer> values = toList(valueIn);
        List<Integer> weights = toList(weightIn);

        //Fill the values
        while(true) {
            int i = findMax(values, weights);
            BigDecimal w = BigDecimal.valueOf(weights.get(i));
            BigDecimal v = BigDecimal.valueOf(values.get(i));
            values.remove(i);
            weights.remove(i);

            BigDecimal min = (capacity.compareTo(w) < 0 )?capacity:w;
            capacity = capacity.subtract(min);
            
            value = value.add( min.multiply( (v.divide(w,5,BigDecimal.ROUND_HALF_DOWN) )));
            if(capacity.equals(BigDecimal.ZERO) || values.size() ==0)
                    break;
        }

        return value.doubleValue();
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
        String result = String.format("%.3f", getOptimalValue(capacity, values, weights));
        System.out.println(result);
    }

} 
