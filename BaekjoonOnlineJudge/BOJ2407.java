import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/*
 *  19. 02. 16.
 *	BOJ2407 : 조합, bigInteger
 *
 */

public class Main {
	static BigInteger[][] arr;

	public static void main(String[] args) throws Exception {

//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new BigInteger[n + 1][n + 1];

		System.out.println(combi(n, m));
	}

	static BigInteger combi(int n, int m) {
		if (arr[n][m] != null)
			return arr[n][m];

		if (n == m || m == 0) {
			arr[n][m] = new BigInteger("1");
			return arr[n][m];
		}

		BigInteger a = arr[n - 1][m];
		BigInteger b = arr[n - 1][m - 1];
		if (a == null) {
			a = combi(n - 1, m);
		}
		if (b == null) {
			b = combi(n - 1, m - 1);
		}

		arr[n][m] = a.add(b);
		return arr[n][m];
	}
}
