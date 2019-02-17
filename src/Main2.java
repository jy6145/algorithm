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

public class Main2 {
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
			boolean[] chkArr = new boolean[n];
			long height = 0;

			for (int i = 0; i < n; i++) {
				height = Long.parseLong(st.nextToken());
				rectangles[i] = height;

				if (height == 1)
					chkArr[i] = true;
			}

			long max = n;
			int left = 0;
			int right = 0;
			long now = 0;
			long tmp = 0;
			for (int i = 0; i < n; i++) {
				if (chkArr[i])
					continue;

				chkArr[i] = true;
				now = rectangles[i]; // 현재 기준 높이
				if (now * n < max) // 현재 기준 높이 최대치로 해도 안될때
					continue;

				left = right = i;
				while (left - 1 >= 0 && rectangles[left - 1] >= now) { // 왼쪽
					if (rectangles[left - 1] == now) { // 최대치로 확인함
						chkArr[left - 1] = true;
					}
					left--;
				}
				while (right + 1 < n && rectangles[right + 1] >= now) { // 오른쪽
					if (rectangles[right + 1] == now) { // 최대치로 확인함
						chkArr[right + 1] = true;
					}
					right++;
				}

				tmp = (right - left + 1) * now;
				if (tmp > max) {
					max = tmp;
				}
			}

			System.out.println(max);
		}
	}
}
