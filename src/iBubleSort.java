
public class iBubleSort {

	public static void main(String[] args) {
		int[] arr = {12,9,4,99,120,1,3,10,23,45,75,69,31,88,101,14,29,91,2,0,77};
		arr = BubleSort(arr);
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] BubleSort(int[] inputArray) {
		boolean swapped;
		int count =0;
		do {
			swapped = false;
			for(int i=0; i < inputArray.length-1; i++) {
				if(inputArray[i] > inputArray[i+1]) {
					int temp = inputArray[i]; count++;
					inputArray[i] = inputArray[i+1]; count++;
					inputArray[i+1] = temp;count++;
					swapped = true;
				}
			}
		}while(swapped);
		System.out.println(count);
		return inputArray;
	}
}
