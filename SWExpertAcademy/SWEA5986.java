
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @fileName SWEA5986.java
 * @date 2019. 2. 26.
 * @author Park JunYoung
 * @description 새샘이와 세 소수, 3중for문
 *
 */

public class SWEA5986 {
	static ArrayList<Integer> prime;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		prime = new ArrayList<Integer>();

		calcPrime();

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int x, y, z;

			int answer = 0;
			int primeSize = prime.size();
			for (int i = 0; i < primeSize; i++) {
				x = prime.get(i);
				if (x >= n)
					break;

				for (int j = i; j < primeSize; j++) {
					y = prime.get(j);
					for (int k = j; k < primeSize; k++) {
						z = prime.get(k);

						if (x + y + z == n)
							answer++;
						else if (x + y + z > n)
							break;
					}
				}
			}
			System.out.println("#" + testCase + " " + answer);
		}
	}

	static void calcPrime() {
		prime.add(2);

		boolean flag = false;
		for (int i = 3; i <= 999; i++) {
			flag = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = true; // 소수가 아님
					break;
				}
			}

			if (!flag)
				prime.add(i);
		}
	}
}
