import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @fileName SWEA2477.java
 * @date 2019. 3. 14.
 * @author Park JunYoung
 * @description [모의 SW 역량테스트] 차량 정비소, 시뮬레이션
 * 
 */

public class SWEA2477 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 접수 창구 수
			int M = Integer.parseInt(st.nextToken()); // 정비 창구 수
			int K = Integer.parseInt(st.nextToken()); // 고객 수
			int A = Integer.parseInt(st.nextToken()); // 찾아야하는 접수 창구번호
			int B = Integer.parseInt(st.nextToken()); // 찾아야하는 정비 창구번호

			int[] receiptTime = new int[N]; // 접수 처리 시간
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				receiptTime[i] = Integer.parseInt(st.nextToken());
			Customer[] receipt = new Customer[N]; // 접수 중인 고객 정보

			int[] maintenanceTime = new int[M]; // 정비 처리 시간
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				maintenanceTime[i] = Integer.parseInt(st.nextToken());
			Customer[] maintenance = new Customer[M]; // 정비 중인 고객 정보

			Queue<Customer> qCustomer = new LinkedList<Customer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++)
				qCustomer.offer(new Customer(i, Integer.parseInt(st.nextToken()))); // 고객 방문 시간 정보

			Queue<Customer> qWaitR = new LinkedList<Customer>(); // 접수 대기 중인 고객
			Queue<Customer> qWaitM = new LinkedList<Customer>(); // 정비 대기 중인 고객

			int nowTime = 0; // 기준 시간
			int answer = 0;
			Customer tmp = null;
			while (!qCustomer.isEmpty() || isWork(receipt, maintenance)) {
				while (!qCustomer.isEmpty() && qCustomer.peek().time == nowTime) {
					qWaitR.offer(qCustomer.poll());
				}

				// 접수처 확인
				for (int i = 0; i < receipt.length; i++) {
					if (receipt[i] != null && receipt[i].endTime == nowTime) { // 접수 완료
						qWaitM.offer(receipt[i]);
						receipt[i] = null;
					}
					if (receipt[i] == null && !qWaitR.isEmpty()) { // 다음 대기열 입장
						tmp = qWaitR.poll();
						tmp.rNum = i + 1;
						tmp.endTime = nowTime + receiptTime[i];
						receipt[i] = tmp;
					}
				}

				// 정비소 확인
				for (int i = 0; i < maintenance.length; i++) {
					if (maintenance[i] != null && maintenance[i].endTime == nowTime) { // 정비 완료
						if (maintenance[i].rNum == A && maintenance[i].mNum == B) {
							answer += maintenance[i].num;
						}
						maintenance[i] = null;
					}
					if (maintenance[i] == null && !qWaitM.isEmpty()) { // 다음 대기열 입장
						tmp = qWaitM.poll();
						tmp.mNum = i + 1;
						tmp.endTime = nowTime + maintenanceTime[i];
						maintenance[i] = tmp;
					}
				}
				nowTime++;
			}

			if (answer == 0)
				answer = -1;
			System.out.println("#" + testCase + " " + answer);
		}
	}

	static boolean isWork(Customer[] receipt, Customer[] maintenance) {
		for (int i = 0; i < receipt.length; i++)
			if (receipt[i] != null)
				return true;

		for (int i = 0; i < maintenance.length; i++)
			if (maintenance[i] != null)
				return true;

		return false;
	}

	static class Customer {
		int num; // 고객 번호
		int rNum; // 접수 번호
		int mNum; // 정비 번호
		int time; // 방문 시간
		int endTime; // 업무 처리 완료 시간

		public Customer(int num, int time) {
			this.num = num;
			rNum = -1;
			mNum = -1;
			this.time = time;
			endTime = -1;
		}
	}
}
