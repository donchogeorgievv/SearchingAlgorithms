
public class iSelectionSort {

	public static void main(String[] args) {
		int[] arr = {12,9,4,99,120,1,3,10,23,45,75,69,31,88,101,14,29,91,2,0,77};
		SelectionSort(arr);
				
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static int[] SelectionSort(int[] arr) {
		if(arr.length == 1) {
			return arr;
		}
		
		for(int i=0; i<arr.length-1;i++) {
			int minValue = arr[i];
			int index = i;
			for(int j = i; j<arr.length; j++) {
				if(arr[j] < minValue) {
					minValue = arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		
		
		return arr;
	}
}
