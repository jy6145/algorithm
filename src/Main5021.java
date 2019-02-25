import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main5021 {
	static List<Person> root;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String founder = br.readLine();

		Person child = null;
		Person p1 = null;
		Person p2 = null;

		root = new LinkedList<Person>();

		String p1Name = "";
		String p2Name = "";
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			child = new Person(st.nextToken(), p1, p2);

			p1Name = st.nextToken();
			p2Name = st.nextToken();

			if ((p1 = findPerson(p1Name)) == null) { // 부모가 없으면 객체 생성
				p1 = new Person(p1Name, null, null);
			}
			if ((p2 = findPerson(p2Name)) == null) {
				p2 = new Person(p2Name, null, null);
			}

			if (root.size() == 0) {
				root.add(child);
			} else {
				for (Person p : root) { // 부모가 root와 연결되있다면 새로운 자식을 root를 비우고 root에 연결
					if (p.name.equals(p1.name) || p.name.equals(p2.name)) {
						root.clear();
						root.add(child);
						break;
					}
				}
			}
		}

		System.out.println();

	}

	static Person findPerson(String name) {
		Person nextP = null;

		for (Person p : root) {
			if (p.name.equals(name)) {
				return p;
			} else {
				// p1 방향으로
				nextP = p.p1;
				while (nextP != null) {
					if (nextP.name.equals(name)) {
						return nextP;
					}

					nextP = nextP.p1;
				}

				// p12방향으로
				nextP = p.p2;
				while (nextP != null) {
					if (nextP.name.equals(name)) {
						return nextP;
					}

					nextP = nextP.p2;
				}
			}
		}

		return null;
	}

	static class Person {
		String name;
		Person p1; // 부모1
		Person p2; // 부모2

		Person(String name, Person p1, Person p2) {
			this.name = name;
			this.p1 = p1;
			this.p2 = p2;
		}
	}
}
