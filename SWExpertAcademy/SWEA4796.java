import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4796.java
 * @date 2019. 3. 13.
 * @author author
 * @description 의석이의 우뚝 선 산, bufferedReader 안먹힘
 * 
 */

public class SWEA4796 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;

		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = sc.nextInt();

			boolean flag = false; // false : / true : \
			long num = 0;
			long left = 0; // 첫번째 값 카운트
			long right = 1;
			long answer = 0;
			long pre = sc.nextLong();
			for (int i = 1; i < n; i++) {
				num = sc.nextLong();
				if (!flag) {
					if (pre < num)
						left++;
					else {
						flag = !flag;
					}
				} else {
					if (pre > num)
						right++;
					else {
						answer += left * right;
						left = 1;
						right = 1;
						flag = !flag;
					}
				}
				pre = num;
			}

			if (flag)
				answer += left * right; // 끝나는 지점에서 남아있을 경우

			System.out.println("#" + testCase + " " + answer);
		}
	}
}