import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ06549.java
 * @date 2019. 2. 18.
 * @author Park JunYoung
 * @description 히스토그램에서 가장 큰 직사각형
 *
 */

public class BOJ06549 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;

			long[] rectangles = new long[n];
			for (int i = 0; i < n; i++) {
				rectangles[i] = Integer.parseInt(st.nextToken());
			}

			int left = 0, right = 0;
			long now = 0, max = 0;
			for (int i = 0; i < n; i++) {
				now = rectangles[i];
				left = right = i;
				while (0 <= (left - 1) && rectangles[left - 1] >= now) {
					left--;
				}
				while ((right + 1) < n && rectangles[right + 1] >= now) {
					right++;
				}

				if (max < (right - left + 1) * now) {
					max = (right - left + 1) * now;
				}
			}

			System.out.println(max);
		}
	}
}
