import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @fileName SWEA4371.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 항구에 들어오는 배
 *
 */

public class SWEA4371 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			long day = 0;
			boolean flag = false;
			List<Long> goodDays = new ArrayList<Long>(); // 항구에 배오는 간격
			br.readLine(); // 첫날 제외

			for (int i = 0; i < n - 1; i++) {
				day = Long.parseLong(br.readLine());

				flag = false; // false이면 goodDay 추가
				for (Long goodDay : goodDays) {
					if ((day - 1) % goodDay == 0) {
						flag = true;
						break;
					}
				}

				if (!flag)
					goodDays.add(day - 1);
			}

			System.out.println("#" + testCase + " " + goodDays.size());
		}
	}
}