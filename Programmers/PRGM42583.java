import java.util.LinkedList;
import java.util.Queue;

/**
 * @fileName PRGM42583.java
 * @date 2021. 5. 2.
 * @author Park JunYoung
 * @description 42863. 다리를 지나는 트럭
 * 
 */
public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;

		Queue<Integer> truckQ = new LinkedList<>();
		Queue<Integer> timeQ = new LinkedList<>();

		int nowWeight = 0;
		int time = 1;
		int idx = 0;

		truckQ.offer(truck_weights[idx]);
		timeQ.offer(time);
		nowWeight += truck_weights[idx];
		idx++;

		while (idx < truck_weights.length) {
			time++;

			if (!truckQ.isEmpty()) {
				if (time - timeQ.peek() == bridge_length) {
					nowWeight -= truckQ.poll();
					timeQ.poll();
				}
			}

			if (nowWeight + truck_weights[idx] <= weight) {
				truckQ.offer(truck_weights[idx]);
				timeQ.offer(time);
				nowWeight += truck_weights[idx];
				idx++;
			}
		}

		while (!truckQ.isEmpty()) {
			time++;
			if (time - timeQ.peek() == bridge_length) {
				nowWeight -= truckQ.poll();
				timeQ.poll();
			}
		}

		answer = time;
		System.out.println(answer);

		return answer;
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] arr = { 7, 4, 5, 6 };
		s.solution(2, 10, arr);
	}
}
