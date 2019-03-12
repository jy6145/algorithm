import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 4796. 의석이의 우뚝 선 산
public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine().trim());

			boolean flag = false; // false : / true : \
			long num = 0;
			long left = 0; // 첫번째 값 카운트
			long right = 1;
			long answer = 0;
			st = new StringTokenizer(br.readLine());
			long pre = Integer.parseInt(st.nextToken());
			for (int i = 1; i < n; i++) {
				num = Integer.parseInt(st.nextToken());
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