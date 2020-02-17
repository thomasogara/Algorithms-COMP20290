import java.util.Scanner;

public class RussianPeasant{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(String.format("%d * %d  = %d", a, b, russianPeasantAlgorithm(a, b)));
		}
	}

	public static int russianPeasantAlgorithm(int a, int b){
		int result = 0;
		while(b > 0){
			if((b % 2) == 1){
				result += a;
			}
			b /= 2;
			a *= 2;
		}
		return result;
	}

}
