public class iMergeSort {
	static int exchangesCouner = 0; //Used to store the number of swaps. i.e. exchanges 
	public static void main(String[] args) {
		int[] arr = {12,9,4,99,120,1,3,10,23,45,75,69,31,88,101,14,29,91,2,0,77};
		arr = MergeSort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Number of exchanges: " + exchangesCouner);
	}
	 
	static int[] MergeSort(int[] arr) {
		//Declaring two additional arrays to store the subarryas - left and right parts
		int[] leftPart;
		int[] rightPart;

		if((arr.length % 2) == 0) { //If==true, then the array has even number of elements and we split it into two haves with equal length
			leftPart = new int[arr.length/2];
			rightPart = new int[arr.length/2];
		}
		else { //if the number is odd, then one of the sub arrays should be 1 item larger than the other
			leftPart = new int[arr.length/2];
			rightPart = new int[(arr.length/2) + 1]; 
		}
		
	  // fill up left and right subarrays
	    for (int i = 0; i < arr.length; i++) {
	        if (i < arr.length/2) {
	            leftPart[i] = arr[i];
	        }
	        else {
	            rightPart[i-arr.length/2] = arr[i];
	        }
	    }
		
		//use recursion to split the subarrays into two smaler smaller subarrays
	    //Creating the bottom of the recursion, otherwise we will get never ending recursive calls
	    if(arr.length <= 2) {
	    	return MergeArrays(leftPart, rightPart);
	    }
	    
		leftPart = MergeSort(leftPart);
		rightPart = MergeSort(rightPart);
		
		return MergeArrays(leftPart, rightPart);
		
	}
	
	//Helper function, its purpose is to merge the two arrays
	static int[] MergeArrays(int[] leftPartArray, int[] rightPartArray) {

		int[] mergedArray = new int[leftPartArray.length + rightPartArray.length]; //declaring a new array with size equal to the sum of the two arrays that we are gpoing to merge
		//helper variables to use for exchange and to store the two pointers 
		
		int leftArrayPointer = 0; //will be used to point to the items in the left array. starting at 0 i.e. the first item
		int rightArrayPointer = 0; //will be used to point to the items in the right array. starting at 0 i.e. the first item
		int indexer = 0; //will be used to store the current available slot of the final array
		
		while(leftArrayPointer < leftPartArray.length && rightArrayPointer < rightPartArray.length) {
			if(leftPartArray[leftArrayPointer] < rightPartArray[rightArrayPointer]) { //Finding the smaller of two numbers. In this case, the item in the left array is smaller
				mergedArray[indexer++] = leftPartArray[leftArrayPointer++]; //Writing the smaller to the next available free slot of the array, 
															//increasing indexer with 1 to point to the next available position. Increasing i, so we take the next item of the left array
				exchangesCouner++; //increasing the counter of exchanges, as we have registered an exchange 
			}
			else { //in this case, the item in the right array is smaller or equal to the current item in the left array
				mergedArray[indexer++] = rightPartArray[rightArrayPointer++]; //Writing the value of the item from the right array in the next free slot
																			//and increasing the indexer and the pointer to point to the nexr free slot and to the next item of the right array
				exchangesCouner++; //increasing the counter of exchanges, as we have registered an exchange 
			}
		}
		
		//including single elements left from spliting odd number of items in an array
	    while (leftArrayPointer < leftPartArray.length) {
	        mergedArray[indexer++] = leftPartArray[leftArrayPointer++];
	    }
	    while (rightArrayPointer < rightPartArray.length) {
	        mergedArray[indexer++] = rightPartArray[rightArrayPointer++];
	    }
		return mergedArray;
	}
}




















