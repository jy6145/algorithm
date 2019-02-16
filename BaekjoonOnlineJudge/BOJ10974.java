import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 *  19. 02. 17.
 *	BOJ10974 : 순열, 사전순
 *
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		perm(arr, 0);
	}

	static void perm(int[] arr, int pivot) {
		if (arr.length == pivot) {
			for (int x : arr) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			rightRotation(arr, pivot + 1, i);
			perm(arr, pivot + 1);
			leftRotation(arr, pivot + 1, i);
			swap(arr, i, pivot);
		}
	}

	static void rightRotation(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}

		int tmp = arr[end];
		for (int i = end; i > start; i--) {
			arr[i] = arr[i - 1];
		}
		arr[start] = tmp;
	}

	static void leftRotation(int[] arr, int start, int end) {
		if (start > end) {
			return;
		}

		int tmp = arr[start];
		for (int i = start; i < end; i++) {
			arr[i] = arr[i + 1];
		}
		arr[end] = tmp;
	}

	static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}