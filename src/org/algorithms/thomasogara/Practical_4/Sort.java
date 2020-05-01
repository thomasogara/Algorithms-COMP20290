package org.algorithms.thomasogara.Practical_4;

import java.util.LinkedList;

/**
 * @author: Thomas O'Gara, 18379576, thomas.ogara@ucdconnect.ie
 */


/**
 * The main class implementing the sorting techniques assigned
 */
public class Sort{
	public static int[] selectionSort(int[] arr){
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
		return arr;
	}

	public static int[] insertionSort(int[] arr){
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
		return arr;
	}

	public static int[] stalinSort(int[] arr){
	    LinkedList<Integer> list = new LinkedList<>();
		for(Integer a : arr){
			list.add(a);
		}
		for(int i = 1; i < list.size(); i++){
			if(list.get(i) < list.get(i-1)){
				list.remove(i);
				i--;
			}
		}
		int[] a = new int[list.size()];
		for(int i = 0; i < list.size(); i++){
			a[i] = list.get(i);
		}
		return a;
	}

	public static int[] randomArray(int size, int min, int max){
		int[] arr = new int[size];
		for(int i = 0; i < size; i++){
			arr[i] = min + ((int)Math.floor(Math.random() * (max + 1)));
		}
		return arr;
	}

	public static boolean isSorted(int[] a){
		for (int i = 0; i < a.length - 1; i++){
			if (a[i] > a[i + 1]) return false;
		}
		return true;
	}

	public static void timeRun(SortingMethod sort, int[] arr, String algorithm){
		double avg = 0;
		int[] a = null;
		for(int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			a = sort.sorter(arr);
			long elapsed = System.nanoTime() - start;
			if(!isSorted(a)) System.out.println("error sorting with " + algorithm + " algorithm");
			avg += (double) elapsed / 10;
		}
		System.out.println(arr.length + "\t" + avg);
		// System.out.println(Arrays.toString(a));
		// System.out.println("Sorted array of size " + arr.length + " in " + avg + " nanoseconds using " + algorithm + " algorithm");
	}

	public static void timer(SortingMethod sort, String algorithm){
		System.out.println("Beginning testing of " + algorithm + " algorithm");
		for(int i = 1_000; i < 100_000; i += 5_000) {
			timeRun(sort, randomArray(i, 0, i), algorithm);
		}
	}

	public static void main(String[] args){
		SortingMethod stalin = Sort::stalinSort;
		SortingMethod selection = Sort::selectionSort;
		SortingMethod insertion = Sort::insertionSort;
		timer(stalin, "stalin sort");
		timer(selection, "selection sort");
		timer(insertion, "insertion sort");
	}
}
