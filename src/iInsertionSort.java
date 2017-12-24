
public class iInsertionSort {

	public static void main(String[] args) {
		int[] arr = {12,9,4,99,120,1,3,10,23,45,75,69,31,88,101,14,29,91,2,0,77};
		
		InsertionSort(arr);
		
		
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		} 
	}
	
	
	public static int[] InsertionSort(int[] arr) {
		int count = 0;
		for(int i=1; i <= arr.length-1;i++) {
			int key = arr[i];
			for(int j=i-1; j>=0;j--) {
				if(key < arr[j]) {
					arr[j+1] = arr[j];
					count++;
					if(j == 0) {		//Border case
						arr[0] = key;
						count++;
					}
				}
				else {
					arr[j+1] = key;
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		return arr;
	}

}
