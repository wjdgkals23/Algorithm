package basic;

public class SortFunc {
	
	public static int[] temps = {1,10,2,3,4,6,54,44,7};

	public void quickSort(int start, int end) {
		if(end<=start)
			return;
		
		int i = start + 1;
		int j = end;
		
		int key = start;
		
		while(i>=j) {
//			i는 key 보다 큰 값을 찾는 인덱싱변수
			while(i<=end && temps[key] >= temps[i]) {
				i++;
			}
//			j는 key 보다 작은 값을 찾는 인덱싱변수
			while(j > start && temps[key] <= temps[j]) {
				j--;
			}
			
			if(i>j) {
				int temp = temps[j];
				temps[j] = temps[key];
				temps[key] = temp;
			}
			else {
				int temp =  temps[i];
				temps[i] = temps[j];
				temps[j] = temp;
			}
		}
		
		quickSort(start, j-1);
		quickSort(j+1, end);
		
	}
	
	public void insertionSort(int [] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int j = i;
			while(j>=0 && arr[j]>arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				j--;
			}
		}
		
		printArr(arr);
	}
	
	public void selectionSort(int [] arr) {
		int index = 0;
		int min;
		int temp =0;
		
		for(int i=0; i<arr.length; i++) {
			min = 100000;
			for(int j=i; j<arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					index = j;
				}
			}
			
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		
		printArr(arr);	
	}
	
	public void printArr(int [] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortFunc calc = new SortFunc();
		int [] temp = {10,4,2,1,15,3};
		calc.selectionSort(temp);
		calc.insertionSort(temp);
		
		calc.quickSort(0, temps.length);
		for(int j=0; j<temps.length; j++) {
			System.out.print(temps[j] +" ");
		}
	}

}
