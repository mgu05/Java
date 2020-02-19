// This program finds the longest sorted (non-decreasing) sequence of an array.

import java.util.*;
public class Problem2{
	public static void main(String[] args){
		//Prompt the user; determine the size of the array
		Scanner console = new Scanner(System.in);
		System.out.print("How many numbers are in your sequence? ");
		int number = console.nextInt();

		int[] data = new int[number];
		for(int i = 0; i < number; i++){
			System.out.print("Enter number " + (i+1) + ": ");
			data[i] = console.nextInt();
		}
		//Call for method longestSortedSequence()
		System.out.println("The longest sorted sequence is: " + longestSortedSequence(data));
	}

	public static int longestSortedSequence(int[] data){
		int count = 1;
		int maximum = 1;
		
		//Check whether if values inside the array is keep increasing
		for(int j = 0; j < data.length - 1; j++){
			//If it is increasing, count increments by 1
			if(data[j+1] >= data[j]){
				count++;

			//Otherwise check if current count is greater the previous maximum length of the sorted sequence
			}else{
				//If current count is larger than the previous maximum length, then maximum length equals to count
				if(count > maximum){
					maximum = count;
				//Count is reset to 1 if the increasing sequence ends (to start over calculating the maximum length)
				}
				count = 1;
			}
		}

		//If passed array is empty, return 0
		if(data.length == 0){
			return 0;
		//Otherwise return the maximum length so far 
		}else{
			return Math.max(count, maximum);
		}
	}
}