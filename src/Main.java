import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @fileName Main.java (BOJ06549)
 * @date 2019. 2. 17.
 * @author Park JunYoung
 * @description ??
 *
 */

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			if (n == 0) {
				break;
			}

			long[] rectangles = new long[n];
			long maxHeight = 0;
			long height = 0;

			long[] heights = new long[n]; // 모든 건물의 높이를 저장, 정렬할때 사용

			for (int i = 0; i < n; i++) {
				height = Long.parseLong(st.nextToken());
				rectangles[i] = height;
				heights[i] = height;

				if (maxHeight < height) {
					maxHeight = height;
				}
			}

			Arrays.sort(heights);

			long tmp = 0;
			long preHeight = 0;
			long nowHeight = 0;
			for (int i = 1; i < heights.length; i++) { // 높이
				nowHeight = rectangles[i];

				if (nowHeight == preHeight) { // 이미 나왔던 높이는 skip
					continue;
				}

				for (int j = 0; j < n; j++) { // 사각형 위치
					if (rectangles[j] >= nowHeight) {
						tmp += nowHeight;
						if (tmp > maxHeight) {
							maxHeight = tmp;
						}
					} else {
						tmp = 0;
					}
				}

				preHeight = rectangles[i];
				tmp = 0;
			}

			System.out.println(maxHeight);
		}
	}
}
