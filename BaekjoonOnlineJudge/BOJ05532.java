import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @fileName BOJ05532.java
 * @date 2019. 3. 20.
 * @author Park JunYoung
 * @description 방학 숙제
 * 
 */

public class BOJ05532 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());

		while (!(A <= 0 && B <= 0)) {
			L--;
			A -= C;
			B -= D;
		}

		System.out.println(L);
	}
}