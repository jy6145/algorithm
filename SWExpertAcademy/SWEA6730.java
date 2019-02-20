import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6730.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 장애물 경주 난이도 	
 * 
 */

public class SWEA6730 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			int preBlock = Integer.parseInt(st.nextToken());
			int now = 0;
			int maxUp = 0;
			int maxDown = 0;
			int diff = 0;
			while (st.hasMoreElements()) {
				now = Integer.parseInt(st.nextToken());

				diff = now - preBlock;

				if (diff > 0 && maxUp < diff) { // 올라갈 때
					maxUp = diff;
				} else if (diff < 0 && maxDown < (-1) * diff) { // 내렬갈 때
					maxDown = (-1) * diff;
				}

				preBlock = now;
			}

			System.out.println("#" + testCase + " " + maxUp + " " + maxDown);
		}
	}
}
