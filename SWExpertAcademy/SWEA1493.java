import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1493.java
 * @date 2019. 3. 6.
 * @author Park JunYoung
 * @description 수의 새로운 연산, 수열찾기
 * 
 */

public class SWEA1493 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int answer = calcStar(p, q);

			System.out.println("#" + testCase + " " + answer);
		}
	}

	static int calcShop(Coordi c) {
		int n = c.x + c.y;
		int p = 1 + (n - 1) * (n - 2) / 2;

		return p + Math.abs(c.x - 1);
	}

	static Coordi calcAmpersand(int p) {
		if (p == 1)
			return new Coordi(1, 1);

		Coordi result = null;
		int n = 1;
		int sum = 0;
		while (1 + (n - 1) * (n - 2) / 2 <= p) {
			n++;
		}

		n--; // 이전꺼 기준으로 찾기
		sum = 1 + (n - 1) * (n - 2) / 2;

		for (int i = 1; i < n; i++) {
			if (sum == p) {
				result = new Coordi(i, n - i);
				break;
			}
			sum++;
		}

		return result;
	}

	static int calcStar(int p, int q) {
		Coordi ampP = calcAmpersand(p);
		Coordi ampQ = calcAmpersand(q);

		Coordi c = new Coordi(ampP.x + ampQ.x, ampP.y + ampQ.y);
		return calcShop(c);
	}

	static class Coordi {
		int x;
		int y;

		public Coordi(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}