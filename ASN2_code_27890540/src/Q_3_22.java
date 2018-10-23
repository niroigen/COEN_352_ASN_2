
public class Q_3_22 {

	static int[] a;
	static int i;
	static int j;
	static int p;
	static int q;
	
	public static void phase1(int lo, int hi) {
		i = lo + 1;
		j = hi;
		p = lo + 1;
		q = hi;
		
		if (lo >= hi) {
			return;
		}
		
		while(i <= j) {
			while(a[++i] < a[lo])
				if (i == hi) break;
			while(a[--j] > a[lo])
				if (j == lo) break;
			
			swap(i, j);
			
			if (a[i] == a[lo])
				swap(i, p++);
			
			if (a[j] == a[lo])
				swap(j, q--);
		}
		
		p--;
		i--;
		j--;
		
		phase2();
		
		phase1(lo, j);
		phase1(i, hi);
		
		return;
	}
	
	public static void phase2() {
		while(p > 0)
			swap(j--, p--);
		
		while(q < a.length - 1)
			swap(i++, q++);
	}
	
	public static void swap(int i, int j) {
		int tempValue = a[i];
		a[i] = a[j];
		a[j] = tempValue;
	}
	
	public static void main(String[] args) {		
		a = new int[]{10, 2, 10, 4 };
		
		phase1(0, a.length - 1);
	}
}
