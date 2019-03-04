import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1494.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description 사랑의 카운슬러, DFS
 * 
 */

public class SWEA1494 {
	static long min;
	static Location[] arr;
	static Location[] tmp;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());
			arr = new Location[n];

			long x = 0;
			long y = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[i] = new Location(x, y);
			}

			min = Long.MAX_VALUE;
			tmp = new Location[n / 2];
			func(tmp, 0, 0, n / 2);

			System.out.println("#" + testCase + " " + min);
		}
	}

	static void func(Location[] tmp, int pivot, int cnt, int goal) {
		if (cnt == goal) {
			long sumX = 0;
			long sumY = 0;
			long sum = 0;

			for (int i = 0; i < arr.length; i++) {
				sumX += arr[i].x;
				sumY += arr[i].y;
			}
			for (int i = 0; i < tmp.length; i++) { // tmp에 저장된 것은 빼야하는데 위에서 1번 더해줘서 2배를 뺌
				sumX -= tmp[i].x * 2;
				sumY -= tmp[i].y * 2;
			}

			sum = (sumX * sumX) + (sumY * sumY);

			if (min > sum)
				min = sum;
			return;
		}

		if (pivot == arr.length) // 끝까지 goal만큼 못고르면 return
			return;

		tmp[cnt] = arr[pivot];
		func(tmp, pivot + 1, cnt + 1, goal); // 선택했을 경우

		func(tmp, pivot + 1, cnt, goal); // 선택하지 않을 경우
	}

	static void swap(Location[] arr, int i, int j) {
		Location tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	static class Location {
		long x;
		long y;

		public Location(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}