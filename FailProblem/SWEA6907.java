import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @fileName SWEA6907.java
 * @date 2019. 2. 20.
 * @author Park JunYoung
 * @description 단위 변환기 프로그램, hashMap
 * 
 */

public class SWEA6907 {
	static Map<String, Integer> prefixs;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());

			prefixs = new HashMap<String, Integer>();
			prefixs.put("", 0);
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
			int dotIdx = -1;
			for (int i = 0; i < num.length(); i++) {
				if (num.charAt(i) == '.') {
					dotIdx = i;
					break;
				}
			}

			if (dotIdx == -1) // 정수일 경우
				dotIdx = num.length();

			// 소수점 기준 왼쪽
			String leftNum = "";
			int leftCnt = 0; // 0의 개수
			if ((dotIdx == 1) && (num.charAt(0) == '0')) { // 0.XXXX
				leftNum = "";
				leftCnt = 0;
			} else { // abc.XXXX
				leftNum = num.substring(0, dotIdx);
				leftCnt = dotIdx - 1;
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

			int signiNum = 0; // 유효숫자 개수
			StringBuilder result = new StringBuilder(num);
			if (leftNum.equals("") && rightNum.equals("")) { // num = 0.00 , 0.0, 0 같은 경우
				result.append(" * 10^" + prefixs.get(prefix) + " " + measure);

			} else if (leftNum.equals("")) { // 0 < num < 1 경우
				signiNum = rightNum.length();
				result.insert(dotIdx + rightCnt + 2, '.'); // 소수점 추가
				result.deleteCharAt(dotIdx); // 소수점 제거

				while (result.charAt(0) == '0') { // 앞에 0 제거 ex)000000123.XXX => 123.XXX
					result.deleteCharAt(0);
				}

				if (rightNum.equals("1")) { // 정수일 때 소수점 제거 ex) 123. => 123
					result.deleteCharAt(1);
				}

				result.append(" * 10^" + (-rightCnt - 1 + prefixs.get(prefix)) + " " + measure);

			} else { // num >=1
				signiNum = num.length() - 1;
				if (dotIdx != num.length()) {
					result.deleteCharAt(dotIdx); // 소수점 제거
				}
				result.insert(1, '.'); // 소수점 추가
				result.append(" * 10^" + (leftCnt + prefixs.get(prefix)) + " " + measure);
			}

			System.out.println("#" + testCase + " " + result.toString());
		}
	}
}
