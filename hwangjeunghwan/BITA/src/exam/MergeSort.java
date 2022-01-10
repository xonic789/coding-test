package exam;
import java.util.Scanner;

public class MergeSort {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    arr = new int[N];
    for(int i=0; i<N; i++) {
    	arr[i] = sc.nextInt();
    }
    MergeSort(0, arr.length-1);
    printArray(arr);
	}
	static void printArray(int[] arr){
    	for(int data : arr){
        	System.out.print(data + " ");
        }
    
    }
	public static void MergeSort(int start, int end) {
		if(start<end) {
			int mid = (start+end)/2;
			MergeSort(start, mid);
			MergeSort(mid+1, end);
			Merge(arr, start, mid, end);
		}
	}
	public static void Merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1 ;
        int n2 = end - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i]  = arr[start + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int p = 0;
        int q = 0;

        int k = start;
  
        while (p < n1 && q < n2) {
            // L 배열의 값 <= R배열의 값
            if (L[p] <= R[q]) {
                // L값 arr에 담아주기
                arr[k] = L[p];
                //L 을 담아주었으니 L의 인덱스 증가
                p++;
            }else {
                // L 배열의 값 > R배열의 값
                // R값 arr에 담아주기
                arr[k] = R[q];
                //R 을 담아주었으니 R의 인덱스 증가
                q++;
            }
            k++;
        }

        //L에 남은 값이 있다면 복사
        while(p < n1) {
            arr[k] = L[p];
            p++;
            k++;
        }

        //R에 남은 값이 있다면 복사  
        while (q < n2) {
            arr[k] = R[q];
            q++;
            k++;
        }
	}
}
