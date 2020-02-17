import java.util.ArrayList;
import static java.lang.Math.multiplyExact;
import java.math.BigInteger;

public class Main{
	public static ArrayList<BigInteger> cache = new ArrayList<>();
	public static void main(String[] args){
		cache.add(new BigInteger("1"));
		cache.add(new BigInteger("1"));
		for(int i = 0; i <= 500; i++){
			System.out.println(String.format("%d! = %s", i, factorial(i).toString()));
		}
	}

	public static BigInteger factorial(int n){
		int i;
		for(i = cache.size(); i <= n; i++){
			cache.add(cache.get(i-1).multiply(new BigInteger(String.valueOf(i))));
		}
		return cache.get(n);
	}
}
