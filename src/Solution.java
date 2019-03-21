import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] t = new int[N];
			for (int i = 0; i < N; i++)
				t[i] = Integer.parseInt(br.readLine());

			Arrays.sort(t);

			int time = 1;
			int sum = 0; // 누적 사람
			boolean flag = false;
			time = t[t.length - 1];
			while (true) {
				sum = 0;
				for (int i = 0; i < t.length; i++)
					sum += time / t[i];

				if (!flag && sum < M) { // 실패하면 기존 숫자 더해주기
					time += t[t.length - 1];
				} else if (!flag && sum >= M) { // 발견하면
					flag = true;
				} else if (flag) {
					if (sum < M) {
						break;
					}
					time--;
				}
			}

			System.out.println("#" + testCase + " " + (time + 1));
		}
	}
}