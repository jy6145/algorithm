import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName BOJ01475.java
 * @date 2019. 3. 27.
 * @author Park JunYoung
 * @description 방 번호
 * 
 */

public class BOJ01475 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] digit = new int[10];
		String N = br.readLine();
		for (int i = 0; i < N.length(); i++)
			digit[N.charAt(i) - '0']++;

		int max = 0;
		for (int i = 0; i < 9; i++) { // 9는 6이랑 더해서 나누기 2
			if (i != 6) {
				if (max < digit[i]) {
					max = digit[i];
				}
			} else {
				if (max < (digit[6] + digit[9] + 1) / 2) // 0.5일 경우 1세트 더 구매해야됨
					max = (digit[6] + digit[9] + 1) / 2;
			}
		}

		System.out.println(max);
	}
}