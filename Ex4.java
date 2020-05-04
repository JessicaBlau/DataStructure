package semester2;
import java.util.HashSet; 
import java.util.Arrays;
import java.util.HashMap;

public class Ex4 {
	public static void main(String[] args) {
		int [] arr = {3,5, 9, 6, 8, 20, 10, 12, 18, 9};
		System.out.println("isMinHeap? "+isMinHeap(arr));
		int arr1[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9}; 
		int n = arr1.length; 

		System.out.print("Min Heap array : "); 
		printArray(arr1, n); 

		convert(arr1); 

		System.out.print("\nMax Heap array : "); 
		printArray(arr1, n); 

		String s = "to,be,or,not,not,to,be,be,that,the,not,abcdefghijklmnop,is,the,not,question";
		System.out.println("\n"+Words(s));
		int [] a2 = {34,2,2,34,10};
		int [] a1 = {11,34,2,7,10};
		System.out.println(IsSubArr(a2,a1));
	}
	// Question 1 C'
	static void printArray(int arr[], int size) 
	{ 
		for (int i = 0; i < size; ++i) 
			System.out.print(arr[i]+" "); 
	} 
	static void MaxHeapify(int arr[], int i, int n) 
	{ 
		int l = 2*i + 1; 
		int r = 2*i + 2; 
		int largest = i; 
		if (l < n && arr[l] > arr[i]) 
			largest = l; 
		if (r < n && arr[r] > arr[largest]) 
			largest = r; 
		if (largest != i) 
		{ 
			int temp = arr[i]; 
			arr[i] = arr[largest]; 
			arr[largest] = temp; 
			MaxHeapify(arr, largest, n); 
		} 
	} 

	public static void convert(int[] A){ 
		for (int i = (A.length-2)/2; i >= 0; --i) {
			MaxHeapify(A, i, A.length); 
		}
	} 
	// Question 1 D'
	public static boolean isMinHeap(int[] arr) {
		boolean flag = true;
		for (int i = 0; flag==true  && (i*2+2) < arr.length; i++) {
			flag = false;
			if (arr[i]<arr[i*2+1]);{
				if (arr[i]<arr[i*2+2]) {
					flag = true;
				}
			}
		}
		return flag;
	}
	// Question 3
	public static String Words(String s) {
		String [] words = s.split(",");
		int DifWords = 0, counter = 0, temp = 0;
		HashMap<String, Integer> Times = new HashMap<>();
		String longest = words[0], answer = "";
		for (int i = 0; i < words.length; i++) {// O(n)
			if (Times.get(words[i]) == null) {// O(1)
				Times.put(words[i], 1);// O(1)
				DifWords++;// O(1)
				if(counter == 0) {// O(1)
					answer = words[i];// O(1)
					counter++;// O(1)
				}
			}
			else {
				temp = Times.get(words[i]);// O(1)
				Times.replace(words[i], ++temp);// O(1)
				if(temp > counter) {// O(1)
					counter = temp;// O(1)
					answer = words[i];// O(1)
				}
			}
		}
		for (int i = 1; i < words.length; i++) {// O(n)
			if(longest.length() < words[i].length()) {// O(1)
				longest = words[i];
			}
		}
		return ("Number of words: "+words.length+"\n"+"the amount of different words: "+DifWords+"\nthe word that repeats the most: "+answer+"\nhow many times: "+counter+"\nthe longest word is: "+longest);
	}
	// Question 4
	public static boolean IsSubArr(int a2[], int a1[]) {
		HashSet <Integer> A = new HashSet<>();// O(1)
		for (int i = 0; i < a1.length; i++) {// O(n) - length of a1
			A.add(a1[i]);// O(1)
		}
		boolean flag = true;// O(1)
		for (int i = 0; i < a2.length && flag == true; i++) {// O(m) - length of a2
			flag = false;// O(1)
			if(A.contains(a2[i])) {// O(1)
				flag = true; // O(1)
			}
		}
		return flag;// O(1)
	}
}
