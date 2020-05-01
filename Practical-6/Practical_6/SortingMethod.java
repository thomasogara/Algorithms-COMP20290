package org.algorithms.thomasogara.Practical_6;

/**
 * @author: Thomas O'Gara, 18379576, thomas.ogara@ucdconnect.ie
 */

/**
 * This interface allows for references to different sorting algorithms to be passed around within the program
 * All sorting methods must have this signature
 */
@FunctionalInterface
public interface SortingMethod{
	public int[] sorter(int[] arr);
}
