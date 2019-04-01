import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA3378 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			Stack<Character> stk = new Stack<Character>();

			String line = "";
			char now = ' ';
			int cnt = 0;
			int[] indent = new int[7]; // (, {, [, ({, {[, [(, ({[
			boolean[] chk = new boolean[7];
			int[] bracketCnt = new int[3];

			int idx = 0;
			boolean subFlag = false;
			for (int i = 0; i < p; i++) {
				line = br.readLine();
				idx = 0;
				cnt = 0;
				now = line.charAt(idx);

				while (now == '.') {
					cnt++;
					now = line.charAt(++idx);
				}
				if (!stk.isEmpty()) {

					// 괄호 개수 세기
					bracketCnt = new int[3];
					for (int j = 0; j < stk.size(); j++) {
						if (stk.get(j) == '(')
							bracketCnt[0]++;
						else if (stk.get(j) == '{')
							bracketCnt[1]++;
						else if (stk.get(j) == '[')
							bracketCnt[2]++;
					}

					subFlag = true; // true면 계속 확인, 알수 있는거 다빼기
					int tmp = 0;
					while (subFlag) {
						subFlag = false;
						for (int j = 0; j < 3; j++) {
							if (chk[j] && bracketCnt[j] > 0) {
								cnt -= indent[j] * bracketCnt[j];
								bracketCnt[j] = 0;
								subFlag = true;
							}
						}
						if (chk[3] && bracketCnt[0] > 0 && bracketCnt[1] > 0) {
							tmp = Math.min(bracketCnt[0], bracketCnt[1]);
							cnt -= indent[3] * tmp;
							bracketCnt[0] -= tmp;
							bracketCnt[1] -= tmp;
							subFlag = true;
						} else if (chk[4] && bracketCnt[1] > 0 && bracketCnt[2] > 0) {
							tmp = Math.min(bracketCnt[1], bracketCnt[2]);
							cnt -= indent[4] * tmp;
							bracketCnt[1] -= tmp;
							bracketCnt[2] -= tmp;
							subFlag = true;
						} else if (chk[5] && bracketCnt[2] > 0 && bracketCnt[0] > 0) {
							tmp = Math.min(bracketCnt[2], bracketCnt[0]);
							cnt -= indent[5] * tmp;
							bracketCnt[2] -= tmp;
							bracketCnt[0] -= tmp;
							subFlag = true;
						} else if (chk[6] && bracketCnt[0] > 0 && bracketCnt[1] > 0 && bracketCnt[2] > 0) {
							tmp = Math.min(bracketCnt[0], Math.min(bracketCnt[1], bracketCnt[2]));
							cnt -= indent[6] * tmp;
							bracketCnt[0] -= tmp;
							bracketCnt[1] -= tmp;
							bracketCnt[2] -= tmp;
							subFlag = true;
						}
					}

					if (bracketCnt[0] == 0 && bracketCnt[1] == 0 && bracketCnt[2] == 0)
						continue;

					// 남은거 계산
					if (bracketCnt[0] > 0 && bracketCnt[1] == 0 && bracketCnt[2] == 0) {
						indent[0] = cnt / bracketCnt[0];
						chk[0] = true;
					} else if (bracketCnt[0] == 0 && bracketCnt[1] > 0 && bracketCnt[2] == 0) {
						indent[1] = cnt / bracketCnt[1];
						chk[1] = true;
					} else if (bracketCnt[0] == 0 && bracketCnt[1] == 0 && bracketCnt[2] > 0) {
						indent[2] = cnt / bracketCnt[2];
						chk[2] = true;
					} else if (bracketCnt[0] == bracketCnt[1] && bracketCnt[2] == 0) {
						indent[3] = cnt / bracketCnt[0];
						chk[3] = true;
						if (cnt == 2 || cnt == 40) {
							for (int j = 0; j < 2; j++) {
								indent[j] = cnt / bracketCnt[j] / 2;
								chk[j] = true;
							}
						}
					} else if (bracketCnt[1] == bracketCnt[2] && bracketCnt[0] == 0) {
						indent[4] = cnt / bracketCnt[1];
						chk[4] = true;
						if (cnt == 2 || cnt == 40) {
							for (int j = 0; j < 2; j++) {
								indent[j + 1] = cnt / bracketCnt[j + 1] / 2;
								chk[j + 1] = true;
							}
						}
					} else if (bracketCnt[2] == bracketCnt[0] && bracketCnt[1] == 0) {
						indent[5] = cnt / bracketCnt[2];
						chk[5] = true;
						if (cnt == 2 || cnt == 40) {
							for (int j = 0; j < 2; j++) {
								indent[j * 2] = cnt / bracketCnt[j * 2] / 2;
								chk[j * 2] = true;
							}
						}
					} else if (bracketCnt[0] == bracketCnt[1] && bracketCnt[1] == bracketCnt[2]) {
						indent[6] = cnt / bracketCnt[0];
						chk[6] = true;
						if (cnt == 3 || cnt == 60) {
							indent[3] = cnt / bracketCnt[0] / 2;
							chk[3] = true;
							indent[4] = cnt / bracketCnt[1] / 2;
							chk[4] = true;
							indent[5] = cnt / bracketCnt[2] / 2;
							chk[5] = true;

							for (int j = 0; j < 3; j++) {
								indent[j] = cnt / bracketCnt[j] / 3;
								chk[j] = true;
							}
						}
					}
				}

				for (int j = idx; j < line.length(); j++) {
					now = line.charAt(j);
					if (now == '(' || now == '{' || now == '[') {
						stk.push(now);
					} else if (now == ')' || now == '}' || now == ']') {
						stk.pop();
					}
				}
			}

			System.out.print("#" + testCase + " ");

			boolean flag = false; // true이면 괄호 개수를 모름
			stk.clear();
			for (int i = 0; i < q; i++) {
				// 괄호 개수 세기
				bracketCnt = new int[3];
				for (int j = 0; j < stk.size(); j++) {
					if (stk.get(j) == '(')
						bracketCnt[0]++;
					else if (stk.get(j) == '{')
						bracketCnt[1]++;
					else if (stk.get(j) == '[')
						bracketCnt[2]++;
				}

				subFlag = true; // true면 계속 확인, 알수 있는거 다빼기
				flag = false;
				int tmp = 0;
				cnt = 0;
				while (subFlag) {
					subFlag = false;
					for (int j = 0; j < 3; j++) {
						if (chk[j] && bracketCnt[j] > 0) {
							cnt += indent[j] * bracketCnt[j];
							bracketCnt[j] = 0;
							subFlag = true;
						}
					}
					if (chk[3] && bracketCnt[0] > 0 && bracketCnt[1] > 0) {
						tmp = Math.min(bracketCnt[0], bracketCnt[1]);
						cnt += indent[3] * tmp;
						bracketCnt[0] -= tmp;
						bracketCnt[1] -= tmp;
						subFlag = true;
					} else if (chk[4] && bracketCnt[1] > 0 && bracketCnt[2] > 0) {
						tmp = Math.min(bracketCnt[1], bracketCnt[2]);
						cnt += indent[4] * tmp;
						bracketCnt[1] -= tmp;
						bracketCnt[2] -= tmp;
						subFlag = true;
					} else if (chk[5] && bracketCnt[2] > 0 && bracketCnt[0] > 0) {
						tmp = Math.min(bracketCnt[2], bracketCnt[0]);
						cnt += indent[5] * tmp;
						bracketCnt[2] -= tmp;
						bracketCnt[0] -= tmp;
						subFlag = true;
					} else if (chk[6] && bracketCnt[0] > 0 && bracketCnt[1] > 0 && bracketCnt[2] > 0) {
						tmp = Math.min(bracketCnt[0], Math.min(bracketCnt[1], bracketCnt[2]));
						cnt += indent[6] * tmp;
						bracketCnt[0] -= tmp;
						bracketCnt[1] -= tmp;
						bracketCnt[2] -= tmp;
						subFlag = true;
					}
				}

				if (bracketCnt[0] != 0 || bracketCnt[1] != 0 || bracketCnt[2] != 0)
					System.out.print("-1 ");
				else
					System.out.print(cnt + " ");

				line = br.readLine();
				for (int j = 0; j < line.length(); j++) {
					now = line.charAt(j);

					if (now == '(' || now == '{' || now == '[')
						stk.push(now);
					else if (now == ')' || now == '}' || now == ']')
						stk.pop();
				}
			}
			System.out.println();
		}
	}
}
