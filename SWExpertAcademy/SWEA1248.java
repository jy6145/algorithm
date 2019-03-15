import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1248.java
 * @date 2019. 3. 15.
 * @author Park JunYoung
 * @description [S/W 문제해결 응용] 3일차 - 공통조상
 * 
 */

public class SWEA1248 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] parent = new int[V + 1];

			int p = 0;
			int c = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				p = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				parent[c] = p;
			}

			ArrayList<Integer> aList = new ArrayList<Integer>(); // A 의 부모
			int tmp = a;
			while (tmp != 0) {
				aList.add(parent[tmp]);
				tmp = parent[tmp];
			}

			tmp = b;
			int root = 0;
			while (tmp != 0) {
				// aList 에 있으면 종료
				if (aList.contains(tmp)) {
					root = tmp;
					break;
				}
				tmp = parent[tmp];
			}

			int cnt = 0;
			for (int i = 1; i <= V; i++) {
				tmp = i;
				while (tmp != 0 && tmp != root) {
					tmp = parent[tmp];
				}

				if (tmp == root) {
					parent[i] = root;
					cnt++;
				} else {
					parent[i] = 0; // 부모 없는 쪽이면 바로 빠져나오게 설정
				}
			}

			System.out.println("#" + testCase + " " + root + " " + cnt);
		}
	}
}
