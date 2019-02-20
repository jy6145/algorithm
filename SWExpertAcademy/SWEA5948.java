
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5948.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 새샘이의 7-3-5 게임, hashset 정렬, 조합(combination)
 *
 */

public class SWEA5948 {

	static int[] select;
	static Set<Integer> sum;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			int[] num = new int[7];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(num);

			select = new int[3];
			sum = new HashSet<Integer>();
			perm(num, 0, 0);

			List<Integer> list = new ArrayList(sum);
			Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

			System.out.println("#" + testCase + " " + list.get(4));
		}
	}

	static void perm(int[] num, int pivot, int selectCnt) {
		if (selectCnt == 3) {
			sum.add(select[0] + select[1] + select[2]);
			return;
		}

		if (pivot == num.length) {
			return;
		}

		// 선택했을 때
		select[selectCnt] = num[pivot];
		perm(num, pivot + 1, selectCnt + 1);

		// 선택 안했을 때
		perm(num, pivot + 1, selectCnt);
	}
}
