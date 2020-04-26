package org.algorithms.thomasogara.Practical_6;

import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Math;

public class Sort{
    public static int CUTOFF = 10;

    public static int[] quickSortImproved(int[] a){
        return quickSortImproved(a, 0, a.length - 1);
    }

    public static int[] quickSortImproved(int[] a, int lo, int hi){
//        System.out.println("hi: " + hi + ", lo: " + lo);
        if(hi <= lo){
            return a;
        }
        
        /*
        if(hi-lo <= CUTOFF){
            return insertionSort(a);
        }
        */
        
        int pivot = partitionImproved(a, lo, hi);

        quickSortImproved(a, lo, pivot - 1);
        quickSortImproved(a, pivot + 1, hi);
        return a;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int partitionImproved(int[] a, int lo, int hi){
        int middle = (hi + lo) / 2;
        if(a[lo] > a[middle]){
            swap(a, lo, middle);
        }
        if(a[lo] > a[hi]){
            swap(a, lo, hi);
        }
        if(a[middle] > a[hi]){
            swap(a, hi, middle);
        }
        int pivot = a[middle];
        swap(a, hi, middle);

        int left = lo - 1;
        for(int i = lo; i < hi; i++){
            if(a[i] < pivot){
                left++;
                swap(a, i, left);
            }
        }
        swap(a, hi, left + 1);
        return left + 1;
    }

    public static int[] quickSortDefault(int[] a){
        return quickSortDefault(a, 0, a.length - 1);
    }

    public static int[] quickSortDefault(int[] a, int lo, int hi){
        if(lo < hi){
            int pivot = partitionDefault(a, lo, hi);

            quickSortDefault(a, lo, pivot - 1);
            quickSortDefault(a, pivot + 1, hi);
            return a;
        }
        return a;        
    }

    public static int partitionDefault(int[] a, int lo, int hi){
        int pivot = a[hi];
        int temp = 0;
        int left = lo - 1;
        for(int i = lo; i < hi; i++){
            if(a[i] < pivot){
                left++;
                temp = a[left];
                a[left] = a[i];
                a[i] = temp;
            }
        }
        temp = a[hi];
        a[hi] = a[left + 1];
        a[left + 1] = temp;
        return left + 1;
    }


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

        for(; i < a.length / 2 + (a.length % 2); i++){
            left[i] = a[i];
        }
        for(; i< a.length; i++){
            right[i - ((a.length / 2) + (a.length % 2))] = a[i];
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
			arr[i] = size - i;
		}
		return arr;
	}


    public static boolean isSorted(int[] a){
		for (int i = 0; i < a.length - 1; i++){
			if (a[i] > a[i + 1]) return false;
		}
		return true;
	}

    public static void timeRun(SortingMethod sort, String algorithm, int size){
		double avg = 0;
		int[] a = null;
		for(int i = 0; i < 10; i++) {
            int[] arr = randomArray(size, -size, size);
            KnuthShuffle.shuffle(arr);
			long start = System.nanoTime();
            try{
			    a = sort.sorter(arr);
            } catch(StackOverflowError e){
                System.out.println("algorithm " + algorithm + " encountered stackoverflow error");
            }
			long elapsed = System.nanoTime() - start;
			if(!isSorted(a)) System.out.println("error sorting with " + algorithm + " algorithm");
			avg += (double) elapsed / 10;
		}
		System.out.println(size + "\t" + avg);
		// System.out.println(Arrays.toString(a));
		// System.out.println("Sorted array of size " + arr.length + " in " + avg + " nanoseconds using " + algorithm + " algorithm");
	}

	public static void timer(SortingMethod sort, String algorithm){
		System.out.println("Beginning testing of " + algorithm + " algorithm");
        for(int i = 10_000; i <= 1_000_000; i += 10_000){
            timeRun(sort, algorithm, i);
        }
	}
    
    public static void main(String[] args){
           SortingMethod mergeDefault = Sort::mergeSort;
           SortingMethod quickSortDefault = Sort::quickSortDefault;
           SortingMethod quickSortImproved = Sort::quickSortImproved;
           timer(mergeDefault, "mergesort");
           timer(quickSortDefault, "default quicksort");
           timer(quickSortImproved, "enhanced quicksort");
    }
}
