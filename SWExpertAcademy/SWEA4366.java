import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @fileName SWEA4366.java
 * @date 2019. 4. 5.
 * @author Park JunYoung
 * @description 정식이의 은행업무, 브루트 포스
 * 
 */

public class SWEA4366 {
	static boolean[] flag;
	static int N;
	static int[] weights;
	static int answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			Set<Integer> set1, set2;
			set1 = new HashSet<>();
			set2 = new HashSet<>();

			String n1 = br.readLine();
			String n2 = br.readLine();

			StringBuilder sb = new StringBuilder(n1);
			for (int i = 0; i < n1.length(); i++) {
				if (n1.charAt(i) == '0') {
					sb.setCharAt(i, '1');
					set1.add(Integer.parseInt(sb.toString(), 2));
					sb.setCharAt(i, '0');
				} else {
					sb.setCharAt(i, '0');
					set1.add(Integer.parseInt(sb.toString(), 2));
					sb.setCharAt(i, '1');
				}
			}

			sb = new StringBuilder(n2);
			for (int i = 0; i < n2.length(); i++) {
				if (n2.charAt(i) == '0') {
					sb.setCharAt(i, '1');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '0');

					sb.setCharAt(i, '2');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '0');
				} else if (n2.charAt(i) == '1') {
					sb.setCharAt(i, '0');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '1');

					sb.setCharAt(i, '2');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '1');
				} else if (n2.charAt(i) == '2') {
					sb.setCharAt(i, '0');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '2');

					sb.setCharAt(i, '1');
					set2.add(Integer.parseInt(sb.toString(), 3));
					sb.setCharAt(i, '2');
				}
			}

			int answer = 0;
			Iterator<Integer> it = set1.iterator();
			while (it.hasNext())
				if (set2.contains(answer = it.next()))
					break;

			System.out.println("#" + testCase + " " + answer);
		}
	}
}
