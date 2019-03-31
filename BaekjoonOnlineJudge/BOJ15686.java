import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName BOJ15686.java
 * @date 2019. 4. 1.
 * @author Park JunYoung
 * @description 치킨 배달, DFS
 *
 */

public class BOJ15686 {
	static int N;
	static int M;
	static List<Coordi> chicken;
	static List<Coordi> house;
	static boolean[] select;
	static int cityDist;
	static int minCityDist;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<Coordi>();
		house = new ArrayList<Coordi>();

		int tmp = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1)
					house.add(new Coordi(i, j));
				else if (tmp == 2)
					chicken.add(new Coordi(i, j));
			}
		}

		select = new boolean[chicken.size()];
		minCityDist = Integer.MAX_VALUE;
		dfs(0, 0, M);

		System.out.println(minCityDist);
	}

	static void dfs(int pivot, int cnt, int goal) {
		if (cnt == goal) {
			List<Coordi> selectChicken = new ArrayList<Coordi>();

			for (int i = 0; i < select.length; i++) {
				if (select[i])
					selectChicken.add(chicken.get(i));
			}

			List<Integer> chickenDist = new ArrayList<Integer>();
			int dist = 0;
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < house.size(); i++) {
				min = Integer.MAX_VALUE;
				for (int j = 0; j < selectChicken.size(); j++) {
					dist = Math.abs(house.get(i).row - selectChicken.get(j).row)
							+ Math.abs(house.get(i).col - selectChicken.get(j).col);
					min = Math.min(dist, min);
				}
				chickenDist.add(min);
			}

			Collections.sort(chickenDist);
			cityDist = 0;
			for (int i = 0; i < house.size(); i++)
				cityDist += chickenDist.get(i);

			minCityDist = Math.min(minCityDist, cityDist);

			return;
		}

		if (pivot == chicken.size())
			return;

		// pivot 치킨집을 선택했을 경우
		select[pivot] = true;
		dfs(pivot + 1, cnt + 1, goal);

		// pivot 치킨집을 선택하지 않을 경우
		select[pivot] = false;
		dfs(pivot + 1, cnt, goal);
	}

	static class Coordi {
		int row;
		int col;

		public Coordi(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}