import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3809.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 화섭이의 정수 나열, set을 list로, Collections.sort
 *
 */

public class SWEA3809 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			Set<Integer> num = new HashSet<Integer>();

			st = new StringTokenizer(br.readLine());

			int answer = 0;

			if (n == 1) {
				answer = (Integer.parseInt(st.nextToken()) == 0) ? 1 : 0;
			} else {
				int tmp[] = new int[3];
				tmp[0] = Integer.parseInt(st.nextToken());
				tmp[1] = Integer.parseInt(st.nextToken());

				// n=2 일 경우 대비
				num.add(tmp[0]);
				num.add(tmp[1]);
				num.add(tmp[0] * 10 + tmp[1]);

				for (int i = 0; i < n - 2; i++) {
					if (!st.hasMoreTokens())
						st = new StringTokenizer(br.readLine());

					tmp[2] = Integer.parseInt(st.nextToken());

					num.add(tmp[0]);
					num.add(tmp[1]);
					num.add(tmp[2]);
					num.add(tmp[0] * 10 + tmp[1]);
					num.add(tmp[1] * 10 + tmp[2]);
					num.add(tmp[0] * 100 + tmp[1] * 10 + tmp[2]);

					tmp[0] = tmp[1];
					tmp[1] = tmp[2];
				}

				List<Integer> list = new ArrayList<Integer>(num);
				Collections.sort(list);

				int idx = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) < idx)
						continue;
					else if (list.get(i) == idx)
						idx++;
					else {
						answer = idx;
						break;
					}
				}
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
}