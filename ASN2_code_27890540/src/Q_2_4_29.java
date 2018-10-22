import java.util.Random;
import java.util.Scanner;

public class Q_2_4_29 {
	public static class MinMaxQueue{
		static int[] maxPQ;
		static int currentIndexMax = 0;
		static int currentIndexMin = 0;
		static int[] minPQ;
		
		public MinMaxQueue(int size) {
			maxPQ = new int[size];
			minPQ = new int[size];
		}
		
		public static void findMax() {
			System.out.println("Maximum item in heap: " + maxPQ[currentIndexMax - 1]);
		}
		
		public static void findMin() {
			System.out.println("Minimum item in heap: " + minPQ[currentIndexMin - 1]);
		}
		
		public static void deleteMax() {
			System.out.println("Delete items from heap in reverse order");
			
			if (currentIndexMax > 0) {
				for (int i = 0; i <= currentIndexMax/2 + 1; i++) {
					System.out.print(minPQ[--currentIndexMax] + "\t");
				}
			}
		}
		
		public static void deleteMin() {	
			System.out.println("Delete items from heap in natural order");
			
			if (currentIndexMin > 0) {
				for (int i = 0; i <= currentIndexMin/2 + 1; i++) {
					System.out.print(maxPQ[--currentIndexMin] + "\t");
				}
			}
			
			System.out.println();
		}
		
		public static void insert(int c) {
			insertToMax(c);
			insertToMin(c);
		}
		
		public static void insertToMax(int c) {
			if (currentIndexMax == 0) {
				maxPQ[currentIndexMax++] = c;
			} else {				
				for (int i = 0; i < currentIndexMax; i++) {
					if (c < maxPQ[i]) {
						int tempValue = maxPQ[i];
						maxPQ[i] = c;
						c = tempValue;
					}
				}
				
				maxPQ[currentIndexMax++] = c;
			}
		}
		
		public static void insertToMin(int c) {
			if (currentIndexMin == 0) {
				minPQ[currentIndexMin++] = c;
			} else {				
				for (int i = 0; i < currentIndexMin; i++) {
					if (c > minPQ[i]) {
						int tempValue = minPQ[i];
						minPQ[i] = c;
						c = tempValue;
					}
				}
				
				minPQ[currentIndexMin++] = c;
			}
		}
	}
	
    public static void main(String[] args) {
    	System.out.println("Enter the size of the heap");
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	int size = scanner.nextInt();
    	
    	MinMaxQueue test = new MinMaxQueue(size);
    	
    	Random random = new Random();
    	
    	System.out.println("Original Heap");
    	
    	for (int i = 0; i < size; i++) {
    		int number = random.nextInt(20); 
    		test.insert(number);
    		System.out.print(number + "\t");
    	}
    	System.out.println();

    	System.out.println("Count of items in heap: " + size);
    	
    	test.findMax();
    	test.findMin();
    	
    	test.deleteMin();
    	test.deleteMax();

    }
}
