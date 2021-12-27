package Chapter2;
import java.util.Arrays;
import java.util.Scanner;

public class Chapter2_1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] su = new int[n];
		for(int i=0; i<n; i++)
			su[i] = sc.nextInt();
		Arrays.sort(su);
		int k = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<k; i++) {
			
			
			if(binarySearch(su, sc.nextInt())>=0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
		}
		System.out.print(sb);
		
	}
	
	
	static boolean check(int[] su, int m, int low, int high) {
		if(low>high)
			return false;
		
		int mid = (low+high)/2;
		if(su[mid] == m) {
			return true;
		}
		else if(su[mid]>m) {
			return check(su, m, low, mid-1);
		}
		else {
			return check(su, m, mid+1, high);
		}
	}
	
	public static int binarySearch(int[] arr, int key) {
		 
		int lo = 0;					// 탐색 범위의 왼쪽 끝 인덱스
		int hi = arr.length - 1;	// 탐색 범위의 오른쪽 끝 인덱스
 
		// lo가 hi보다 커지기 전까지 반복한다.
		while(lo <= hi) {
 
			int mid = (lo + hi) / 2;	// 중간위치를 구한다.
 
			// key값이 중간 위치의 값보다 작을 경우
			if(key < arr[mid]) {
				hi = mid - 1;
			}
			// key값이 중간 위치의 값보다 클 경우
			else if(key > arr[mid]) {
				lo = mid + 1;
			}
			// key값과 중간 위치의 값이 같을 경우
			else {
				return mid;
			}
		}
 
		// 찾고자 하는 값이 존재하지 않을 경우
		return -1;
 
	}
	
}
