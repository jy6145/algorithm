import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName BOJ02869.java
 * @date 2019. 4. 2.
 * @author Park JunYoung
 * @description 달팽이는 올라가고 싶다, 이진탐색
 * 
 */

public class BOJ02869 {
	static long A, B, V, diff;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		diff = A - B;

		biSearch(0, 1000000000);
	}

	static void biSearch(long left, long right) {
		if (left > right)
			return;

		long mid = (left + right) / 2;

		long preSum = (mid - 2) * diff + A;
		long sum = (mid - 1) * diff + A;
		if (preSum < V && sum >= V)
			System.out.println(mid);
		else if (sum > V)
			biSearch(left, mid - 1);
		else
			biSearch(mid + 1, right);
	}
}