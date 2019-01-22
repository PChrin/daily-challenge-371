public class NQueensValidator {
	public static void main(String[] args) {
	/**
		qcheck({4, 2, 7, 3, 6, 8, 5, 1}) => true
		qcheck({2, 5, 7, 4, 1, 8, 6, 3}) => true
		qcheck({5, 3, 1, 4, 2, 8, 6, 3}) => false   (b3 and h3 are on the same row)
		qcheck({5, 8, 2, 4, 7, 1, 3, 6}) => false   (b8 and g3 are on the same diagonal)
		qcheck({4, 3, 1, 8, 1, 3, 5, 2}) => false   (multiple problems)	
	*/
		
		//Test arrays.
		int[] array = {4, 2, 7, 3, 6, 8, 5, 1};
		int[] array2 = {2, 5, 7, 4, 1, 8, 6, 3};
		int[] array3 = {5, 3, 1, 4, 2, 8, 6, 3};
		int[] array4 = {5, 8, 2, 4, 7, 1, 3, 6};
		int[] array5 = {4, 3, 1, 8, 1, 3, 5, 2};
		int[] array6 = {8, 6, 4, 2, 7, 1, 3, 5};
		
		//Print results to console.
		System.out.println(qcheck(array));
		System.out.println(qcheck(array2));
		System.out.println(qcheck(array3));
		System.out.println(qcheck(array4));
		System.out.println(qcheck(array5));
		System.out.println(qcheck(array6));
		
		//Calling qfix method to fix array 6.
		qfix(array6);
		
		//Print array 6 to console.
		for(int i = 0; i < array6.length; i++) {
			System.out.print(array6[i]);
		}
		
	}
	
	//Method that checks validity of queens arrangement.
	public static boolean qcheck (int[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] == array[j] || Math.abs(array[i] - array[j]) == Math.abs(i - j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Method to fix array that fails qcheck validation.
	public static int[] qfix(int[] array) {
		int[] temp = array;
		for(int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				swap(temp, i, j);
				if(qcheck(temp)) {
					return temp;
				}
				swap(temp, i, j);
			}
		}
		return temp;
	}
	
	//Method to swap two index in an array.
	public static void swap(int[] array, int index, int index2) {
		int temp;
		temp = array[index];
		array[index] = array[index2];
		array[index2] = temp;
	}
}
