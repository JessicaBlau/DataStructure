package school;
import java.awt.Point;
public class Ex1 {
	 
	public static int maximumX(Point [] vertices) {// function that calls the max x point in array 
		return findPeakX(vertices,0,vertices.length-1, vertices.length);// calls the function that uses recursion to find max x
	}
	public static int maximumY(Point [] vertices) {// function that calls the max y point in array 
		return findPeakY(vertices,0,vertices.length-1, vertices.length);// calls the function that uses recursion to find max y
	}
    public static int findPeakX(Point arr[], int low, int high, int n) 
    { 
        // Find index of middle element 
        int mid = low + (high - low)/2;  /* (low + high)/2 */
      
        // Compare middle element with its neighbors (if neighbors exist) 
        if ((mid == 0 || arr[mid-1].x <= arr[mid].x) && 
                (mid == n-1 || arr[mid+1].x <= arr[mid].x)) 
            return mid; 
      
        // If middle element is not peak and its left neighbor is greater  
        // than it, then left half must have a peak element 
        else if (mid > 0 && arr[mid-1].x > arr[mid].x) 
            return findPeakX(arr, low, (mid -1), n); 
      
        // If middle element is not peak and its right neighbor is greater 
        // than it, then right half must have a peak element 
        else return findPeakX(arr, (mid + 1), high, n); 
    }
    public static int findPeakY(Point arr[], int low, int high, int n) 
    { 
        // Find index of middle element 
        int mid = low + (high - low)/2;  /* (low + high)/2 */
      
        // Compare middle element with its neighbors (if neighbors exist) 
        if ((mid == 0 || arr[mid-1].y <= arr[mid].y) && 
                (mid == n-1 || arr[mid+1].y <= arr[mid].y)) 
            return mid; 
      
        // If middle element is not peak and its left neighbor is greater  
        // than it, then left half must have a peak element 
        else if (mid > 0 && arr[mid-1].y > arr[mid].y) 
            return findPeakY(arr, low, (mid -1), n); 
      
        // If middle element is not peak and its right neighbor is greater 
        // than it, then right half must have a peak element 
        else return findPeakY(arr, (mid + 1), high, n); 
    } 
}