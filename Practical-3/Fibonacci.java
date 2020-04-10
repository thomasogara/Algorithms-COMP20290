import java.util.ArrayList;
import java.lang.Math;

public class Fibonacci{
	public static ArrayList<Integer> cache = new ArrayList<>();

	public static int fibonacciRecursive(int n){
		if(n < cache.size()){
			return cache.get(n);
		}else{           
            int res;
            try{
                res = Math.addExact(fibonacciRecursive(n-1), fibonacciRecursive(n-2));
            } catch(Exception e){
                throw new IllegalArgumentException(String.format("integer overflow occured at %d", n));
            }
            cache.add(n);
			return fibonacciRecursive(n);
		}
	}

	public static void main(String[] args){
		cache.add(0);
		cache.add(1);
        try{
    		System.out.println(fibonacciRecursive(100));
        } catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(cache);
	}
}
