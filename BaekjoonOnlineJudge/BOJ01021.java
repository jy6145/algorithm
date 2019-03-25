import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @fileName BOJ01021.java
 * @date 2019. 3. 25.
 * @author Park JunYoung
 * @description 회전하는 큐
 *
 */

public class BOJ01021 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++)
			queue.add(i);

		int goal = 0;
		int leftIdx = 0;
		int rightIdx = 0;
		int idx = 0;
		int move = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			goal = Integer.parseInt(st.nextToken());

			if (queue.get(idx) == goal) {
				queue.remove(idx);
				if (idx >= queue.size()) // 가장 끝 데이터를 삭제할 경우
					idx = 0;
				continue;
			}

			leftIdx = idx;
			rightIdx = idx;
			while (true) {
				if (leftIdx - 1 < 0)
					leftIdx = queue.size() - 1;
				else
					leftIdx--;

				if (rightIdx + 1 >= queue.size())
					rightIdx = 0;
				else
					rightIdx++;

				move++;
				if (queue.get(leftIdx) == goal) {
					idx = leftIdx;
					queue.remove(idx);
					if (idx >= queue.size())
						idx = 0;
					break;
				} else if (queue.get(rightIdx) == goal) {
					idx = rightIdx;
					queue.remove(idx);
					if (idx >= queue.size())
						idx = 0;
					break;
				}
			}
		}

		System.out.println(move);
		br.close();

	}// main
}