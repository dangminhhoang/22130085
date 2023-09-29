package lab1;

import java.util.ArrayList;

public class MyArray {
	private int[] array;
	public MyArray(int[] array) {
	this.array = array;
	}
	//Method mirror that outputs the contents of an array in a 
	//reverse order like a mirror 
	//Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		//TODO
		int[] mirrorArray = new int[array.length*2];
		for (int i = 0; i < array.length; i++) {
			mirrorArray[i]= array[i];
			mirrorArray[array.length*2-i-1]= array[i];
		}
		return mirrorArray;
		}
	// removes all duplicate elements from an array and returns a 
	// new array
	//Input: 1 3 5 1 3 7 9 8
	//Output: 1 3 5 7 9 8
	public int[] removeDuplicates() {
		// TODO
		ArrayList<Integer> uniqueElements = new ArrayList<>();
	    
	    for (int i = 0; i < array.length; i++) {
	        if (!uniqueElements.contains(array[i])) {
	            uniqueElements.add(array[i]);
	        }
	    }
	    
	    int[] result = new int[uniqueElements.size()];
	    for (int i = 0; i < uniqueElements.size(); i++) {
	        result[i] = uniqueElements.get(i);
	    }
	    
	    return result;
		}
	// Input: 10 11 12 13 14 16 17 19 20 
	// Output: 15 18

	public int[] getMissingValues() {
		// TODO
		int min = array[0];
	    int max = array[0];
	    
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] < min) {
	            min = array[i];
	        }
	        if (array[i] > max) {
	            max = array[i];
	        }
	    }
	    
	    ArrayList<Integer> missingValues = new ArrayList<>();
	    
	    for (int i = min; i <= max; i++) {
	        if (!contains(array, i)) {
	            missingValues.add(i);
	        }
	    }
	    
	    int[] result = new int[missingValues.size()];
	    for (int i = 0; i < missingValues.size(); i++) {
	        result[i] = missingValues.get(i);
	    }
	    
	    return result;
		}
	private boolean contains(int[] array, int value) {
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == value) {
	            return true;
	        }
	    }
	    return false;
	}
	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k, int[]inputArray) {
		int[] outputArray = new int[inputArray.length];

	    for (int i = 0; i < inputArray.length; i++) {
	        if (inputArray[i] == -1) {
	            int sum = 0;
	            int count = 0;

	            for (int j = Math.max(0, i - k); j <= Math.min(inputArray.length - 1, i + k); j++) {
	                if (inputArray[j] != -1) {
	                    sum += inputArray[j];
	                    count++;
	                }
	            }

	            outputArray[i] = count > 0 ? sum / count : 0;
	        } else {
	            outputArray[i] = inputArray[i];
	        }
	    }

	    return outputArray;
		}
public static void main(String[] args) {
int[] inputArray = {10 ,11 ,12, -1, 14, 10, 17, 19, 20};
    
    // Create a MyArray object with the input array
    MyArray myArray = new MyArray(inputArray);
    
    // Test the mirror method
    int[] mirroredResult = myArray.fillMissingValues(3, inputArray);
    for (int num : mirroredResult) {
      System.out.print(num + " ");
  }

}
}
