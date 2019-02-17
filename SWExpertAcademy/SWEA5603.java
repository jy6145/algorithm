import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @fileName SWEA5603.java
 * @date 2019. 2. 17.
 * @author Park JunYoung
 * @description 건초더미
 *
 */

public class SWEA5603 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			int sum = 0;
			int avg = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
				sum += arr[i];
			}

			avg = sum / n;

			Arrays.sort(arr);

			int result = 0;
			int i = 0;
			while (true) {
				if (arr[i] > avg)
					break;

				result += (avg - arr[i++]);
			}

			System.out.println("#" + test_case + " " + result);
		}
	}

}
