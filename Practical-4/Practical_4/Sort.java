package Practical_4;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort{
	public static void selectionSort(int[] arr){
		int min_index = 0;
		for(int i = 0; i < arr.length; i++){
			min_index = i;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[j] < arr[min_index]){
					min_index = j;
				}
			}
			int temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr){
		int key = 0;
		int j = 0;
		for(int i = 1; i < arr.length; i++){
			key = arr[i];
			j = i - 1;
			while( j >= 0 && arr[j] > key){
				arr[j+1] = arr[j--];
				arr[j+1] = key;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void stalinSort(int[] arr){
		ArrayList<Integer> list = new ArrayList<>();
		for(Integer a : arr){
			list.add(a);
		}
		for(int i = 1; i < list.size(); i++){
			if(list.get(i) < list.get(i-1)){
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
	}

	public static int[] randomArray(int size, int min, int max){
		int[] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = min + ((int)Math.floor(Math.random() * (max + 1)));
		}
		return arr;
	}

	public static void timeRun(SortingMethod sort, int[] arr, String algorithm){
		long start = System.nanoTime();
		sort.sorter(arr);
		long elapsed = System.nanoTime() - start;
		System.out.println("Sorted array of size " + arr.length + " in " + elapsed + " nanoseconds using " + algorithm + " algorithm");
	}

	public static void timer(SortingMethod sort, String algorithm, int times){
		System.out.println("Beginning testing of " + algorithm + " algorithm");
		for(int i = 0; i < times; i++){
			timeRun(sort, randomArray(1000, 0, 1000), algorithm);
		}
	}

	public static void main(String[] args){
		SortingMethod stalin = Sort::stalinSort;
		timer(stalin, "stalin sort", 10);
	}
}
