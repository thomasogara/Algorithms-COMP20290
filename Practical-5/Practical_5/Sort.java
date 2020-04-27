package org.algorithms.thomasogara.Practical_5;

import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;

public class Sort{
    public static int CUTOFF = 100;
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
        int[] a = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            a[i] = list.get(i);
        }
        return a;
	}

    public static int[] mergeSort(int[] a){
        if(a.length <= 1){
            return a;
        }
        
        int[] left = new int[a.length / 2 + ((a.length % 2) == 0 ? 0 : 1)];
        int[] right = new int[a.length / 2];
        int i = 0;

        for(; i < a.length / 2 + ((a.length % 2) == 0 ? 0 : 1); i++){
            left[i] = a[i];
        }
        for(; i< a.length; i++){
            right[i - ((a.length / 2) + ((a.length % 2) == 0 ? 0 : 1))] = a[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        int[] mergedArr = merge(left, right);

        return mergedArr;
    }

    public static int[] mergeSortImproved(int[] a){
        if(a.length <= 1){
            return a;
        }

        if(a.length <= CUTOFF){
            return insertionSort(a);
        }
        
        int[] left = new int[a.length / 2 + (a.length % 2)];
        int[] right = new int[a.length / 2];
        int i = 0;

        for(; i < a.length / 2 + (a.length % 2); i++){
            left[i] = a[i];
        }
        for(; i< a.length; i++){
            right[i - ((a.length / 2) + (a.length % 2))] = a[i];
        }        

        left = mergeSort(left);
        right = mergeSort(right);

        int[] mergedArr;

        if(left[left.length - 1] <= right[0]){
            mergedArr = new int[a.length];
            for(int j = 0; j < left.length; j++){
                mergedArr[j] = left[j];
            }
            for(int j = left.length; j < a.length; j++){
                mergedArr[j] = right[j - left.length];
            }
        }

        mergedArr = merge(left, right);

        return mergedArr;
    }

    public static int[] merge(int[] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int left_index = 0;
        int right_index = 0;
        int i = 0;
        for(i = 0; i < merged.length && left_index < left.length && right_index < right.length; i++){
            if(left[left_index] < right[right_index]){
                merged[i] = left[left_index++];
            }else{
                merged[i] = right[right_index++];
            }
        }
        while(left_index < left.length){
            merged[i++] = left[left_index++];
        }
        while(right_index < right.length){
            merged[i++] = right[right_index++];
        }
        return merged;
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
        for(int i = 1_000; i < 100_000; i += 1_000){
            timeRun(sort, randomArray(i, 0, i), algorithm);
        }
	}
    
    public static void main(String[] args){
           SortingMethod insertion = Sort::insertionSort;
           SortingMethod mergeDefault = Sort::mergeSort;
           SortingMethod mergeImproved = Sort::mergeSortImproved;
           timer(insertion, "insertion sort");
           timer(mergeDefault, "default merge sort");
           timer(mergeImproved, "improved merge sort");
    }
}
