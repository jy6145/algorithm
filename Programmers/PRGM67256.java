/**
 * @fileName PRGM67256.java
 * @date 2021. 5. 15.
 * @author Park JunYoung
 * @description 67256. 키패드 누르기	
 * 
 */

public class PRGM67256 {
	public String solution(int[] numbers, String hand) {
		String answer = "";

		int left = 10; // *
		int right = 11; // #

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				answer += "L";
				left = number;
			} else if (number == 3 || number == 6 || number == 9) {
				answer += "R";
				right = number;
			} else {
				if (calcDist(left, number) < calcDist(right, number)) {
					answer += "L";
					left = number;
				} else if (calcDist(left, number) > calcDist(right, number)) {
					answer += "R";
					right = number;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						left = number;
					} else {
						answer += "R";
						right = number;
					}
				}
			}
		}

		return answer;
	}

	public int calcDist(int now, int target) {
		Coordi[] list = { new Coordi(3, 1), new Coordi(0, 0), new Coordi(0, 1), new Coordi(0, 2), new Coordi(1, 0),
				new Coordi(1, 1), new Coordi(1, 2), new Coordi(2, 0), new Coordi(2, 1), new Coordi(2, 2),
				new Coordi(3, 0), new Coordi(3, 2) };

		return Math.abs(list[now].x - list[target].x) + Math.abs(list[now].y - list[target].y);
	}

	public class Coordi {
		int x;
		int y;

		Coordi(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();

	}
}
