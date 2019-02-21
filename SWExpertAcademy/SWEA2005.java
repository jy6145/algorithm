
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName SWEA2005.java
 * @date 2019. 2. 21.
 * @author Park JunYoung
 * @description 파스칼의 삼각형
 * 
 */

public class SWEA2005 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[] arrA = new int[10]; // 이전 높이 배열
			int[] arrB = new int[10]; // 현재 높이 배열

			System.out.println("#" + testCase);
			// 파스칼 삼각형
			arrA[0] = 1;
			for (int i = 0; i < n; i++) {
				arrB[0] = 1;
				for (int j = 1; j <= i - 1; j++) {
					arrB[j] = arrA[j - 1] + arrA[j];
				}
				arrB[i] = 1;

				for (int j = 0; j <= i; j++) {
					System.out.print(arrB[j] + " ");
				}
				System.out.println();

				System.arraycopy(arrB, 0, arrA, 0, arrB.length);
			}
		}
	}
}
