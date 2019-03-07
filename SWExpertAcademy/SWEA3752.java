import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3752.java
 * @date 2019. 3. 7.
 * @author Park JunYoung
 * @description 가능한 시험 점수, Set 	
 * 
 */

public class SWEA3752 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int score = 0;
			Set<Integer> set = new HashSet<Integer>();
			set.add(0);

			Iterator<Integer> it;
			Set<Integer> tmp;
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				score = Integer.parseInt(st.nextToken());
				tmp = new HashSet<Integer>();

				it = set.iterator();

				while (it.hasNext()) {
					tmp.add(it.next() + score);
				}

				set.addAll(tmp);
			}

			System.out.println("#" + testCase + " " + set.size());
		}
	}
}