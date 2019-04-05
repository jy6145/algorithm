import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3501.java
 * @date 2019. 4. 5.
 * @author Park JunYoung
 * @description 순환소수 짧게 표현하기
 * 
 */

public class SWEA3501 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			int a = p / q; // 몫
			int b = p % q; // 나머지

			StringBuilder answer = new StringBuilder(String.valueOf(a));
			if (b != 0) {// 나머지가 존재할때
				int[] chk = new int[q];
				Arrays.fill(chk, -1);
				int idx = 0;
				List<Integer> list = new ArrayList<>();
				answer.append(".");

				while (true) {
					// 나머지 확인
					if (b == 0) {
						for (int i = 0; i < list.size(); i++)
							answer.append(list.get(i));
						break;
					} else if (chk[b] == -1) {// 나머지를 처음 방문
						chk[b] = idx;
					} else {// 순환 확인됨
						// 처음부터 순환 시작 전까지는 한번
						for (int i = 0; i < chk[b]; i++)
							answer.append(list.get(i));
						// tmp부터 지금 전까지 반복
						answer.append("(");
						for (int i = chk[b]; i < idx; i++)
							answer.append(list.get(i));
						answer.append(")");
						break;
					}

					b *= 10; // 나머지에 10을 곱함
					a = b / q; // 몫
					b %= q; // 나머지

					// 몫 저장
					list.add(a);

					idx++;
				}
			}
			System.out.println("#" + testCase + " " + answer.toString());
		}
	}
}
