import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static Map<String, Integer> prefixs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			prefixs = new HashMap<String, Integer>();
			prefixs.put("yotta", 24);
			prefixs.put("zetta", 21);
			prefixs.put("exa", 18);
			prefixs.put("peta", 15);
			prefixs.put("tera", 12);
			prefixs.put("giga", 9);
			prefixs.put("mega", 6);
			prefixs.put("kilo", 3);
			prefixs.put("hecto", 2);
			prefixs.put("deca", 1);
			prefixs.put("deci", -1);
			prefixs.put("centi", -2);
			prefixs.put("milli", -3);
			prefixs.put("micro", -6);
			prefixs.put("nano", -9);
			prefixs.put("pico", -12);
			prefixs.put("femto", -15);
			prefixs.put("ato", -18);
			prefixs.put("zepto", -21);
			prefixs.put("yocto", -24);

			String num = st.nextToken();
			String prefix = "";
			String measure = "";
			if (st.countTokens() == 2) { // 접두사가 있을 경우
				prefix = st.nextToken();
			}
			measure = st.nextToken();

			// 소수점 위치 찾기
			int dotIdx = 0;
			for (int i = 0; i < num.length(); i++) {
				if (num.charAt(i) == '.') {
					dotIdx = i;
					break;
				}
			}

			// 소수점 기준 왼쪽
			String leftNum = "";
			int leftCnt = 0; // 0의 개수
			for (int i = dotIdx - 1; i >= 0; i--) {
				if (num.charAt(i) != '0') {
					leftNum = num.substring(0, i + 1);
					leftCnt = (dotIdx - 1) - i;
					break;
				}
			}

			// 소수점 기준 오른쪽
			String rightNum = "";
			int rightCnt = 0; // 0의 개수
			for (int i = dotIdx + 1; i < num.length(); i++) {
				if (num.charAt(i) != '0') {
					rightNum = num.substring(i, num.length());
					rightCnt = i - (dotIdx + 1);
					break;
				}
			}

			

			System.out.println("num : " + num + " dotIdx : " + dotIdx);
			System.out.println(leftNum + " " + leftCnt);
			System.out.println(rightNum + " " + rightCnt);

			StringBuilder sb = new StringBuilder();
			sb.append("#" + testCase + " ");

		}
	}
}
