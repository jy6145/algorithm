
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3456.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 직사각형 길이 찾기
 * 
 */

public class SWEA3456 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[3];

			int i = 0;
			while (st.hasMoreElements()) {
				arr[i++] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;
			if (arr[0] == arr[1])
				answer = arr[2];
			else if (arr[1] == arr[2])
				answer = arr[0];
			else
				answer = arr[1];

			System.out.println("#" + testCase + " " + answer);
		} // tc
	}
}