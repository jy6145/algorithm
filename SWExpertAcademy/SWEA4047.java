import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA4047.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 영준이의 카드 카운팅, hashSet
 * 
 */

public class SWEA4047 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			Set<String> cards = new HashSet<String>();

			String s = br.readLine();
			String tmp = "";
			Boolean flag = false; // true 이면 Error

			int[] cnt = new int[4]; // S, D, H, C
			for (int i = 0; i < s.length(); i += 3) { // 3칸씩 확인
				tmp = s.substring(i, i + 3);
				if (cards.contains(tmp)) {
					flag = true;
					break;
				}

				cards.add(tmp);

				switch (tmp.charAt(0)) {
				case 'S':
					cnt[0]++;
					break;
				case 'D':
					cnt[1]++;
					break;
				case 'H':
					cnt[2]++;
					break;
				case 'C':
					cnt[3]++;
					break;
				}
			}

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			if (flag) // ERROR일 경우
				answer.append("ERROR");
			else {
				for (int i = 0; i < 4; i++)
					answer.append(13 - cnt[i] + " ");
			}

			System.out.println(answer.toString());
		}
	}
}