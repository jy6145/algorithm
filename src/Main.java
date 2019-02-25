import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] ref = new int[n][2];

		int a, b;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			ref[i][0] = a;
			ref[i][1] = b;
		}

		Arrays.sort(ref, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int min = ref[0][0];
		int max = ref[0][1];
		System.out.println(min + " " + max);
		int answer = 1;

		for (int i = 1; i < ref.length; i++) {
			if (!(min <= ref[i][0] && ref[i][0] <= max)) {
				min = ref[i][0];
				max = ref[i][1];
				System.out.println(min + " " + max);

				answer++;
			}
		}

		System.out.println(answer);
	}
}
