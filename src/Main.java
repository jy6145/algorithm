import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		System.out.println(func(A, B, C));
	}

	static long func(long a, long b, long c) {
		if (b == 0)
			return 1;

		long num = func(a, b / 2, c);
		long tmp = (num % c * num % c) % c;
		if (b % 2 == 0)
			return tmp;
		else
			return tmp * a % c;
	}
}
