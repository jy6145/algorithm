
/**
 * @fileName SWEA3131.java
 * @date 2019. 3. 3.
 * @author Park JunYoung
 * @description 100만 이하의 모든 소수, 이클립스에서 출력 시 숫자가 너무 많아서 콘솔에 출력이 안됨
 *
 */

public class SWEA3131 {
	public static void main(String[] args) {
		long goal = 1000000;

		StringBuilder answer = new StringBuilder("2 ");

		boolean flag = false;
		for (long i = 3; i <= goal; i += 2) { // 2를 제외한 짝수는 소수가 아님
			flag = false; // false이면 소수
			for (long j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				answer.append(i + " ");
		}

		System.out.println(answer.toString());
	}
}