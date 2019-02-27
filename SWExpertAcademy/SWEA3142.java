
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA3142.java
 * @date 2019. 2. 27.
 * @author Park JunYoung
 * @description 영준이와 신비한 뿔의 숲, 2차방정식 	
 * 
 */

public class SWEA3142 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int unicorn = 2 * m - n;
			int twinHorn = n - m;
			
			System.out.println("#" + testCase + " " + unicorn + " " + twinHorn);
		} // tc
	}
}