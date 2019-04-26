import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dRow = { 0, -1, 1, 0, 0 };
	static int[] dCol = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		FishList[][] map = new FishList[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				map[i][j] = new FishList();
			}
		}

		int r, c, s, d, z;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());

			map[r][c].list.add(new Fish(r, c, d, s, z));
		}

		int sum = 0;
		Queue<Fish> addList = new LinkedList<Fish>();
//		printMap(map);
		for (int i = 1; i <= C; i++) {
			// 물고기 잡기
			for (int j = 1; j <= R; j++) {
				if (map[j][i].list.size() == 1) {
					sum += map[j][i].list.get(0).size;
					map[j][i].list.remove(0);
					break;
				}
			}

			// 물고기 이동
			int row, col;
			Fish now;
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if (map[j][k].list.size() > 0) {
						now = map[j][k].list.get(0);
						row = now.row;
						col = now.col;
						for (int l = 0; l < now.speed; l++) {
							row += dRow[now.dir];
							col += dCol[now.dir];

							if (row == 0) {
								row = 2;
								now.dir = 2;
							} else if (row == R + 1) {
								row = R - 1;
								now.dir = 1;
							} else if (col == 0) {
								col = 2;
								now.dir = 3;
							} else if (col == C + 1) {
								col = C - 1;
								now.dir = 4;
							}
//							System.out.println(row + " " + col);
						}

						addList.add(new Fish(row, col, now.dir, now.speed, now.size));
						map[j][k].list.remove(0);
					}
				}
			}

			// 물고기 이동 갱신
			while (!addList.isEmpty()) {
				now = addList.poll();
				map[now.row][now.col].list.add(now);
			}

			// 물고기 가장 큰거 생존
			for (int j = 1; j <= R; j++) {
				for (int k = 1; k <= C; k++) {
					if (map[j][k].list.size() >= 2) {
						Collections.sort(map[j][k].list, new Comparator<Fish>() {

							@Override
							public int compare(Fish o1, Fish o2) {
								return o2.size - o1.size;
							}
						});
					}

					int size = map[j][k].list.size();
					for (int l = 0; l < size - 1; l++) {
						map[j][k].list.remove(1);
					}
				}
			}

//			printMap(map);
		}

		System.out.println(sum);
	}

	static void printMap(FishList[][] map) {
		System.out.println("===================");
		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[i].length; j++) {
				if (map[i][j].list.size() > 0)
					System.out.print(map[i][j].list.get(0).size + " ");
				else
					System.out.print("0 ");
			}
			System.out.println();
		}
	}

	static class Fish {
		int size;
		int row;
		int col;
		int dir;
		int speed;

		public Fish(int row, int col, int dir, int speed, int size) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.speed = speed;
			this.size = size;
		}
	}

	static class FishList {
		ArrayList<Fish> list;

		public FishList() {
			list = new ArrayList<Fish>();
		}
	}
}
