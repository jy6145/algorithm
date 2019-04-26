
public class Test {
	public static void main(String[] args) {
		String input = "012340123456780123450123012345";
		char ch = ' ';
		int pre = 0; // 이전 위치 문자 값(첨에 무조건 0나온다고 가정)
		int now = 0;
		int idx = 1;
		String result = "1";

		for (int i = 1; i < input.length(); i++) {
			if (pre <= 8) { // 한자리 수 확인
				now = input.charAt(i) - '0';
			} else { // 두자리 수 확인
				if (input.length() >= i + 1) // 두자리를 못만들 경우
					break;

				now = (input.charAt(i) - '0') * 10 + (input.charAt(i + 1) - '0');
			}

			if (pre + 1 == now) {
				result = result + idx;

				pre = now;
			} else {
				idx = idx + 1;
				result = result + "//" + idx;

				pre = 0;
			}
		}

		System.out.println(result);
	}
}