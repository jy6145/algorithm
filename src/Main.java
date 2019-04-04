import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] relation;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		relation = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++)
			Arrays.fill(relation[i], 0, N + 1, 10000);

		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			relation[a][b] = 1;
			relation[b][a] = 1;
		}

		int[] sum = new int[N + 1];
		int min = Integer.MAX_VALUE;
		int answer = 0;

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;

					relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum[i] += relation[i][j];
			}

			if (sum[i] < min) {
				min = sum[i];
				answer = i;
			}
		}

		System.out.println(answer);
	}
}
