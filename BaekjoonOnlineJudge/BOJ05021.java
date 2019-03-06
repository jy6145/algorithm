import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ05021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String king = br.readLine();

		ArrayList<Person> people = new ArrayList<Person>(); // 중복되지 않게 모든 사람들을 저장하는 배열

		Person child = null;
		Person parent1 = null;
		Person parent2 = null;
		boolean flagP1 = false;
		boolean flagP2 = false;
		boolean flagC = false;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()); // 자식, 부모1, 부모2 순으로 입력
			child = new Person(st.nextToken(), 0);

			flagC = false;
			for (Person p : people) { // 자식이 이미 리스트에 있는지 확인
				if (p.name.equals(child.name)) {
					child = p;
					flagC = true;
					break;
				}
			}

			if (!flagC) // 없으면 새로운 객체 생성 후 리스트에 추가
				people.add(child);

			parent1 = new Person(st.nextToken(), 0);
			parent1.child.add(child);
			parent2 = new Person(st.nextToken(), 0);
			parent2.child.add(child);

			flagP1 = false; // true면 리스트에 이미 존재
			flagP2 = false;
			for (Person p : people) { // 부모가 이미 있는지 확인
				if (p.name.equals(parent1.name) && !flagP1) {
					flagP1 = true;
					p.child.add(child);
				}
				if (p.name.equals(parent2.name) && !flagP2) {
					flagP2 = true;
					p.child.add(child);
				}
			}

			if (!flagP1) // 없으면 새로운 객체 생성 후 리스트에 추가
				people.add(parent1);
			if (!flagP2)
				people.add(parent2);
		}

		// 혈통 계산
		Queue<Person> q = new LinkedList<Person>();
		for (Person p : people) {
			if (p.name.equals(king)) { // 왕을 찾음
				p.blood = Math.pow(2, 10); // 숫자 계산을 쉽게 하기 위해 왕의 피를 2^10이라고 임의로 지정

				for (Person p2 : p.child) {
					p2.blood += p.blood / 2; // 왕의 혈통 절반을 직속 자식들에게 부여
					q.offer(p2);
				}
				Person tmp;
				while (!q.isEmpty()) {
					tmp = q.poll();

					if (tmp.visit)
						continue;
					tmp.visit = true;

					// 추가 피를 제공해야하는 케이스
					// c a b
					// d a c
					// f e d

					for (Person p3 : tmp.child) {
						p3.blood += tmp.blood / 2;
						if (!p3.visit) // 자식들에게 피를 주지 않았을 경우
							q.offer(p3);
						else { // 피를 줬지만, 다른쪽에서 새로운 피가 추가되어 자식들에게 주어야 할 경우
							Person copyP = new Person(p3.name, tmp.blood / 2);
							copyP.child = p3.child;
							q.offer(copyP);
						}
					}
				}
				break;
			}
		}

		// 후보 판별
		String answer = "";
		double maxBlood = -1;
		String candidate = "";
		for (int i = 0; i < m; i++) {
			candidate = br.readLine();
			for (Person p : people) {
				if (p.name.equals(candidate)) {
					if (maxBlood < p.blood) {
						maxBlood = p.blood;
						answer = p.name;
					}
					break;
				}
			}
		}

		System.out.println(answer);
	}

	static class Person {
		String name;
		double blood;
		List<Person> child;
		boolean visit; // 혈통계산시 사용

		public Person(String name, double blood) {
			this.name = name;
			this.blood = blood;
			child = new ArrayList<Person>();
			visit = false;
		}
	}
}
