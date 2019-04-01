import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName BOJ16235.java
 * @date 2019. 4. 1.
 * @author Park JunYoung
 * @description 나무 재테크
 * 
 */

public class BOJ16235 {
	static int[] dRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Tree[][] map = new Tree[N + 1][N + 1];
		int[][] addFood = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = new Tree(5);
				addFood[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x, y, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			map[x][y].age.add(z);
		}

		for (int year = 0; year < K; year++) {
			// 봄
			int age = 0;
			int[][] tmp = new int[N + 1][N + 1]; // 여름에 양분으로 저장
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					Collections.sort(map[i][j].age);
					for (int k = 0; k < map[i][j].age.size(); k++) {
						age = map[i][j].age.get(k);
						if (age <= map[i][j].food) {
							map[i][j].age.set(k, age + 1);
							map[i][j].food -= age; // 맵의 양분 제거
						} else { // 양분을 못주면 이후 나무들은 다 죽음
							while (k < map[i][j].age.size()) {
								tmp[i][j] += map[i][j].age.get(k) / 2;
								map[i][j].age.remove(k);
							}
							break;
						}
					}
				}
			}

			// 여름
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j].food += tmp[i][j];
				}
			}

			// 가을
			int nRow = 0;
			int nCol = 0;
			int addTree = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 심을 나무의 개수
					addTree = 0;
					for (int k = 0; k < map[i][j].age.size(); k++) {
						if (map[i][j].age.get(k) % 5 == 0) // 나이가 5의 배수이면 심기
							addTree++;
					}

					for (int k = 0; k < 8; k++) {
						nRow = i + dRow[k];
						nCol = j + dCol[k];

						if (1 <= nRow && nRow <= N && 1 <= nCol && nCol <= N) {
							for (int l = 0; l < addTree; l++)
								map[nRow][nCol].age.add(1);
						}
					}
				}
			}

			// 겨울
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j].food += addFood[i][j];
				}
			}
		}

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt += map[i][j].age.size();
			}
		}

		System.out.println(cnt);
	}

	static class Tree {
		List<Integer> age;
		int food;

		public Tree(int food) {
			age = new ArrayList<Integer>();
			this.food = food;
		}
	}
}