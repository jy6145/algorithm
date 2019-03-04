import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @fileName SWEA1258.java
 * @date 2019. 3. 4.
 * @author Park JunYoung
 * @description [S/W 문제해결 응용] 7일차 - 행렬찾기 	
 * 
 */

public class SWEA1258 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(br.readLine());

			int[][] map = new int[n][n];
			boolean[][] visit = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<Area> areas = new ArrayList<Area>();

			int tmpRow = 0;
			int tmpCol = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visit[i][j] && map[i][j] != 0) {
						int x = i;
						while (x < n && map[x][j] != 0) { // 행 끝까지 검사
							x++;
						}
						tmpRow = x - i;

						int y = j;
						while (y < n && map[i][y] != 0) { // 열 끝까지 검사
							y++;
						}
						tmpCol = y - j;

						areas.add(new Area(tmpRow, tmpCol));

						for (int k = i; k < x; k++) {
							for (int l = j; l < y; l++) {
								visit[k][l] = true;
							}
						}
					}
				}
			}

			Collections.sort(areas, new Comparator<Area>() {
				@Override
				public int compare(Area o1, Area o2) {
					return (o1.x * o1.y) == (o2.x * o2.y) ? o1.x - o2.x : (o1.x * o1.y) - (o2.x * o2.y);
				}
			});

			StringBuilder answer = new StringBuilder("#" + testCase + " ");
			answer.append(areas.size() + " ");
			for (Area area : areas) {
				answer.append(area.x + " " + area.y + " ");
			}

			System.out.println(answer.toString());
		}
	}

	static class Area {
		int x;
		int y;

		public Area(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
