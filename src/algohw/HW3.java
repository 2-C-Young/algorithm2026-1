//22212022 이시영

package algohw;

import java.util.Scanner;

public class HW3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++) 
		A[i] = sc.nextInt();
		sc.close();
		
		int[] aux = new int[n];
		int[] sortedarr = A;
		mergeSort(sortedarr,aux,0,n-1);
		
		int[] index = new int[n];
		int rank = 0;
		for(int i = 0; i < n; i++) {
			if(i != 0 && sortedarr[i-1] != sortedarr[i]) rank++;
			for(int j = 0; j < n; j++) {
				index[i] = rank;
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(sortedarr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print(index[i] + " ");
		}
	}
	static void merge(int a[], int aux[], int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++)	aux[k] = a[k]; 
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)              a[k] = aux[j++];
			else if (j > hi)          a[k] = aux[i++];
			else if (aux[j] < aux[i]) a[k] = aux[j++];
			else                      a[k] = aux[i++];
		}
	}
	static void mergeSort(int a[], int aux[], int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		mergeSort(a,aux,lo,mid);
		mergeSort(a,aux,mid+1,hi);
		merge(a,aux,lo,mid,hi);
	}
}
