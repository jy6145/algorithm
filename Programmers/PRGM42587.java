import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * @fileName PRGM42584.java
 * @date 2020. 4. 26.
 * @author Park JunYoung
 * @description 42587. 프린터
 *
 */

public class PRGM42587 {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("../input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		System.out.println(Solution.solution(priorities, location));
	}

	static class Solution {
		public static int solution(int[] priorities, int location) {
			int answer = 0;
			int printCnt = 0;

			LinkedList<Paper> q = new LinkedList<Paper>();

			// 대기 목록 추가
			for (int i = 0; i < priorities.length; i++) {
				q.add(new Paper(priorities[i], i));
			}

			while (true) {
				Paper now = new Paper(q.get(0).priority, q.get(0).location); // 첫번째꺼를 받음

				boolean isPrintAvaliable = true; // true일 경우 프린트 가능
				for (int i = 1; i < q.size(); i++) {
					if (now.priority < q.get(i).priority) {
						isPrintAvaliable = false;
						break;
					}
				}

				if (!isPrintAvaliable) { // 불가능이면
					q.remove(0);
					q.add(now);
				} else { // 프린트할 경우
					printCnt++;
//					System.out.println("프린트함 : " + now);
					q.remove(0);

					if (now.location == location) {
						answer = printCnt;
						break;
					}
				}
			}

			return answer;
		}
	}

	static class Paper {
		int priority;
		int location;

		public Paper(int priority, int location) {
			this.priority = priority;
			this.location = location;
		}

		@Override
		public String toString() {
			return "Paper [priority=" + priority + ", location=" + location + "]";
		}
	}
}
