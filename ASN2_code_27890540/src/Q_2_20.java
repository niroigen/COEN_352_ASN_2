import java.util.Random;
import java.util.Scanner;

public class Q_2_20 {
	static int[] aux;
	static int[] perm;
	
	public static int[] mergesort(int[] array) {
		aux = new int[array.length];
		perm = new int[array.length];
	
		for (int i = 0; i < array.length; i++) {
			perm[i] = i;
		}
		
		mergesort(array, 0, array.length - 1);
		
		return perm;
	}
	
	public static void mergesort(int[] array, int low, int high) {
		if (high <= low) {
			return;
		}
		
		int middle = (low + high) / 2;
		
		mergesort(array, low, middle);
		mergesort(array, middle + 1, high);
		merge(array, low, high);
	}
	
	public static void merge(int[] array, int low, int high) {
		int leftIndex = low;
		int middle = (low + high) / 2;
		int rightIndex = middle + 1;
		
		int index = low;
		
		while(leftIndex <= middle && rightIndex <= high) {
			aux[index++] = array[perm[leftIndex]] < array[perm[rightIndex]] ? perm[leftIndex++] : perm[rightIndex++];
		}

		System.arraycopy(perm, leftIndex, aux, index, middle - leftIndex + 1);
		System.arraycopy(perm, rightIndex, aux, index, high - rightIndex + 1);
		System.arraycopy(aux, low, perm, low, high - low + 1);
	}
	
	public static void print(int[] array) {
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			
			if (i != array.length - 1) {
				System.out.print(", ");
			}
		}
		
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the size of the array");
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int[] numbers = new int[N];
		
		Random random = new Random();
		
		for (int i = 0; i < N; i++) {
	        numbers[i] = random.nextInt(10);
		}
		
		System.out.println("Original array");
		
		print(numbers);
		
		mergesort(numbers);
		
		System.out.println("Sorted array");
		
		print(perm);
	}
}
