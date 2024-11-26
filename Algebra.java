// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		while (x2 != 0){
			if (x2 > 0) {
				x1++;
				x2--;
			}
			else {
				x1--;
				x2++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		while (x2 != 0){
			if (x2 > 0){
				x1--;
				x2--;
			}
			else {
				x1++;
				x2++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		boolean oneNegative = (x1 < 0 && x2 > 0 ) || (x1 > 0 && x2 < 0);
		x1 = x1 < 0 ? minus(0, x1) : x1;
		x2 = x2 < 0 ? minus(0, x2) : x2;
		int times = 0;
		while (x2 != 0){
			times = plus(times , x1);
			x2 = minus(x2, 1);
		}
		return oneNegative ? minus(0, times) : times;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n < 0){
			return 0;
		}
		int pow = 1;
		while (n != 0) {
			pow = times(pow, x);
			n = minus(n, 1);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		boolean oneNegative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);
		x1 = x1 < 0 ? minus(0, x1) : x1;
		x2 = x2 < 0 ? minus(0, x2) : x2;
		int div = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			div = plus(div, 1);
		}

		return oneNegative ? minus(0, div) : div;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int division = div(x1, x2);
		int reminder = minus(x1, times(division, x2));

		return reminder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int root = 0;
		while (times(root, root) <= x){
			root = plus(root, 1);

		}
		return minus(root, 1);
	}	  	  
}