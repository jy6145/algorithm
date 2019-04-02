import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @fileName SWEA5644.java
 * @date 2019. 4. 2.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 무선 충전, 시뮬레이션
 * 
 */

public class SWEA5644 {
	static Info[][] map;
	static List<Integer> BC_Charge;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			int[][] moveCmd = new int[2][M];// A,B의 이동 명령
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					moveCmd[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			map = new Info[10 + 1][10 + 1];
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					map[i][j] = new Info();
				}
			}

			BC_Charge = new ArrayList<>(); // 충전양 정보 저장

			int row, col, c;
			int nRow, nCol;
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());

				for (int j = row - c; j <= row + c; j++) {
					for (int k = col - c; k <= col + c; k++) {
						nRow = j;
						nCol = k;
						if (1 <= nRow && nRow <= 10 && 1 <= nCol && nCol <= 10
								&& (Math.abs(nRow - row) + Math.abs(nCol - col) <= c)) {
							map[nRow][nCol].bc.add(i); // 충전 영역 설정
						}
					}
				}
				BC_Charge.add(Integer.parseInt(st.nextToken())); // 충전양
			}

			// 충전양 많은 순으로 내림 차순
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					if (!map[i][j].bc.isEmpty()) {
						Collections.sort(map[i][j].bc, new Comparator<Integer>() {
							@Override
							public int compare(Integer o1, Integer o2) {
								return BC_Charge.get(o2) - BC_Charge.get(o1);
							}
						});
					}
				}
			}

			Coordi[] p = { new Coordi(1, 1), new Coordi(10, 10) }; // 사람
			int chargeSum = charge(p[0], p[1]);

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < 2; j++) {
					switch (moveCmd[j][i]) {
					case 0:
						// nothing..
						break;
					case 1: // 상
						p[j].row--;
						break;
					case 2: // 우
						p[j].col++;
						break;
					case 3: // 하
						p[j].row++;
						break;
					case 4: // 좌
						p[j].col--;
						break;
					}
				}

				chargeSum += charge(p[0], p[1]);
			}

			System.out.println("#" + testCase + " " + chargeSum);
		}
	}

	static int charge(Coordi p1, Coordi p2) {
		int p1_size = map[p1.row][p1.col].bc.size();// p1 위치에 접속 가능한 충전 수
		int p2_size = map[p2.row][p2.col].bc.size();// p2 위치에 접속 가능한 충전 수

		// 충전소가 둘다 있는데 같은 지점일 경우
		if (p1_size != 0 && p2_size != 0 && map[p1.row][p1.col].bc.get(0) == map[p2.row][p2.col].bc.get(0)) {
			int commonIdx = map[p1.row][p1.col].bc.get(0); // 공통으로 접속하고 있는 충전소 번호
			int p1SecondIdx = 0;
			int p2SecondIdx = 0;

			if (p1_size >= 2 && p2_size >= 2) {
				p1SecondIdx = map[p1.row][p1.col].bc.get(1);
				p2SecondIdx = map[p2.row][p2.col].bc.get(1);
				return BC_Charge.get(commonIdx) + Math.max(BC_Charge.get(p1SecondIdx), BC_Charge.get(p2SecondIdx));
			} else if (p1_size >= 2) {
				p1SecondIdx = map[p1.row][p1.col].bc.get(1);
				return BC_Charge.get(commonIdx) + BC_Charge.get(p1SecondIdx);
			} else if (p2_size >= 2) {
				p2SecondIdx = map[p2.row][p2.col].bc.get(1);
				return BC_Charge.get(commonIdx) + BC_Charge.get(p2SecondIdx);
			} else
				return BC_Charge.get(commonIdx);
		} else {
			int charge1 = 0;
			int charge2 = 0;

			if (p1_size != 0)
				charge1 = BC_Charge.get(map[p1.row][p1.col].bc.get(0));
			if (p2_size != 0)
				charge2 = BC_Charge.get(map[p2.row][p2.col].bc.get(0));

			return charge1 + charge2;
		}
	}

	static class Coordi {
		int row;
		int col;

		public Coordi(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static class Info {
		List<Integer> bc;

		public Info() {
			bc = new ArrayList<Integer>();
		}
	}
}
