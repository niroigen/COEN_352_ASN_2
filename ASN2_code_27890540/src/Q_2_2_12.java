import java.util.Random;
import java.util.Scanner;

public class Q_2_2_12 {	
	public static void sort(Integer[] array, int M) {
		int N = array.length;
		for (int i = 0; i < N/M; i++) {
			sort(array, i * M, (i + 1) * M - 1);
		}
		
		for (int i = 0; i < N/M - 1; i++) {
			merge(array, M, (i+2) * M);
		}
		
		return;
	}
	
	public static void sort(Integer[] array, int low, int high) {
		for(int i = low; i <= high; i++) {
			int minIndex = i;
			
			for (int j = i; j <= high; j++) {
				minIndex = array[j] < array[minIndex] ? j : minIndex;
			}
			
			int tempValue = array[minIndex];
			array[minIndex] = array[i];
			array[i] = tempValue;
		}
	}
	
	public static void merge(Integer[] array, int M, int endIndex) {
		Integer[] temp = new Integer[M];
		
		System.arraycopy(array, endIndex - M, temp, 0, M);
		
		int i = 0;
		int leftEnd = endIndex - M - 1;

		while(i <= leftEnd) {
			if (array[i] > temp[0]) {
				int tempValue = array[i];
				array[i] = temp[0];
				temp[0] = tempValue;
			}
			
			i++;
			sort(temp, 0, M - 1);
		}
		
		System.arraycopy(temp, 0, array, endIndex - M, M);
	}
	
	public static void print(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the size of the array");
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		System.out.println("Enter the size of the block");
		int M = scanner.nextInt();
		
		Integer[] numbers = new Integer[N];
		
		Random random = new Random();
		
		for (int i = 0; i < N; i++) {
	        numbers[i] = random.nextInt(10);
		}
		
		System.out.println("Original array");
		
		print(numbers);
		
		sort(numbers, M);
		
		System.out.println("Sorted array");
		
		print(numbers);
	}
}
