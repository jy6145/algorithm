import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3459.java
 * @date 2019. 3. 5.
 * @author Park JunYoung
 * @description 승자 예측하기, bigInteger, 규칙 찾기 	
 * 
 */

public class SWEA3459 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int testCase = 1; testCase <= T; testCase++) {
			String num = br.readLine();
			BigInteger bNum = new BigInteger(num);
			BigInteger bTmp = new BigInteger(num);
//			bNum = bNum.add(new BigInteger("1"));

			int cnt = 0;
			while (!bTmp.toString().equals("0")) {
				bTmp = bTmp.shiftRight(1);
				cnt++;
			}

			System.out.print("#" + testCase + " ");

			int tmp = 1;
			BigInteger bX = new BigInteger("1");
			if (cnt % 2 == 0) {
				// 위 아래 위 아래 => *2 -> *2+1 -> *2 -> *2+1 ...
				while (true) {
					if (tmp % 2 == 1)
						bX = bX.multiply(new BigInteger("2"));
					else
						bX = bX.multiply(new BigInteger("2")).add(new BigInteger("1"));

					tmp++;
					if (bX.compareTo(bNum) == 1) {
						if (tmp % 2 == 1)
							System.out.println("Alice");
						else
							System.out.println("Bob");
						break;
					}
				}
			} else {
				// 아래 위 아래 위
				while (true) {
					if (tmp % 2 == 0)
						bX = bX.multiply(new BigInteger("2"));
					else
						bX = bX.multiply(new BigInteger("2")).add(new BigInteger("1"));

					tmp++;
					if (bX.compareTo(bNum) == 1) { // bX > bNum
						if (tmp % 2 == 1)
							System.out.println("Alice");
						else
							System.out.println("Bob");
						break;
					}
				}
			}

		}
	}
}