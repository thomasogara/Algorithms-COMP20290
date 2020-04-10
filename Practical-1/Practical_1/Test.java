package Practical_1;

import java.io.File;
import java.io.FileWriter;
import java.math.BigInteger;

public class Test {
    static FileWriter fw;

    public static void main(String[] args) throws Exception{
        fw = new FileWriter(new File("Practical-1/test_out.txt"));
        for(long i = 1_000_000; i <= 10_000_000; i += 500_000){
            for(int j = 1_000_000; j <= 10_000_000; j += 500_000) {
                try {
                    timeRun(i, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        fw.close();
    }

    static void timeRun(long a, long b) throws Exception{
        // calculate the average runtime over 100 runs
        // to decrease the probability of outliers in the dataset
        int runs = 100;

        // the average runtime
        double average = 0;

        // The BigInteger library is used to verify results
        // I took the liberty of assuming the BigInteger library
        // has a guaranteed accuracy, as for the purposes of this
        // practical, it might as well.
        BigInteger BigIntA = new BigInteger(String.valueOf(a));
        BigInteger BigIntB = new BigInteger(String.valueOf(b));
        String BigIntResult = BigIntA.multiply(BigIntB).toString();

        // run the algorithm 100 times
        for(int i = 0; i < runs; i++) {
            long result;
            // time the run
            long start = System.nanoTime();
            result = RussianPeasant.russianPeasantAlgorithm(a, b);
            long elapsed = System.nanoTime() - start;

            // increase the average by this run's runtime
            average += (double)elapsed;

            // if the result is not equal to a * b,  throw an exception
            if(!BigIntResult.equals(String.valueOf(result))) throw new Exception(String.format("russian peasant failed for a = %d, b = %d", a, b));
        }
        // divide the average by the number of runs so that we get the
        // actual average runtime of the 100 cycles
        average /= runs;

        //write the result to a file
        fw.write(String.format("%-20d\t\t%-20f\n", a*b, average));
    }
}
