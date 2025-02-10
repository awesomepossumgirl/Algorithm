package algo01.Greedy;

public class Joystick {

	public static void main(String[] args) {
		Joystick js = new Joystick();

		System.out.println(js.solution("JEROEN")); // Expected output: 56
		System.out.println(js.solution("JAN")); // Expected output: 23
		System.out.println(js.solution("AAAA")); // Expected output: 0
		System.out.println(js.solution("ABABAAAAABA")); // Expected output: 10
	}

	public int solution(String name) {
		int answer = 0;
		int length = name.length();
		int index = 0;
		int move = length - 1;

		for (int i = 0; i < length; i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

			index = i + 1;
			while (index < length && name.charAt(index) == 'A') {
				index++;
			}

			move = Math.min(move, i * 2 + length - index);
			move = Math.min(move, (length - index) * 2 + i);
		}

		return answer + move;
	}
}