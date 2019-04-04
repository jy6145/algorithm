import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//2858
public class Main02858 {
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int endIdx = R * B;
		int L = 0;
		int W = 0;
		boolean flag = false;
		for (int i = 0; i <= R; i++) {
			for (int j = 0; j <= B; j++) {
				if ((L + W) * 2 - 4 == (L * W) - B) {
					L = i;
					W = j;
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}

		System.out.println(L + " " + W);
	}
}
