import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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
			boolean[] chk = new boolean[n];
			for (int i = 0; i < n; i++) {
				rectangles[i] = Integer.parseInt(st.nextToken());
			}

			int left = 0, right = 0;
			long now = 0, max = 0;
			for (int i = 0; i < n; i++) {
				if (chk[i])
					continue;

				now = rectangles[i];
				left = right = i;
				while (0 <= (left - 1) && rectangles[left - 1] >= now) {
					if (rectangles[left - 1] == now)
						chk[left - 1] = true;
					left--;
				}
				while ((right + 1) < n && rectangles[right + 1] >= now) {
					if (rectangles[right + 1] == now)
						chk[right + 1] = true;
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
