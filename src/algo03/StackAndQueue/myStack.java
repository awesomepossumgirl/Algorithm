package algo03.StackAndQueue;

public class myStack {
	public static void main(String[] args) {
		// 스택 구현한 코드
		// Stack은 후입선출(LIFO, Last In First Out) 방식으로 기능함

		StackExample stack = new StackExample(5); // 크기가 5인 스택 생성

		// 스택에 값 추가
		stack.push(10);
		stack.push(20);
		stack.push(30);

		// 스택의 가장 상단 값 확인
		System.out.println("스택의 가장 상단 값: " + stack.peek());

		// 스택에서 값 제거
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop());

		// 스택이 비었는지 확인
		System.out.println("스택이 비었나요? " + stack.isEmpty());

		// 스택의 크기 확인
		System.out.println("스택 크기: " + stack.size());

		// 스택에서 값을 더 제거
		System.out.println("pop: " + stack.pop());
		System.out.println("pop: " + stack.pop()); // 이때는 스택이 비어 있음
	}

	// StackExample 클래스 정의
	public static class StackExample {
		// Stack을 구현할 배열
		private int[] stack;
		private int top; // 스택의 가장 상단 인덱스를 추적

		// 생성자: 스택의 크기를 지정하여 배열을 초기화
		public StackExample(int size) {
			stack = new int[size]; // 주어진 크기의 배열을 생성
			top = -1; // 스택이 비어있으므로 top을 -1로 초기화
		}

		// 스택에 값을 추가하는 메소드
		public void push(int value) {
			// 스택이 꽉 찼을 때 예외 처리
			if (top == stack.length - 1) {
				System.out.println("스택이 꽉 찼습니다.");
			} else {
				stack[++top] = value; // top을 1 증가시키고 값을 추가
				System.out.println(value + "이(가) 스택에 추가되었습니다.");
			}
		}

		// 스택에서 값을 제거하고 반환하는 메소드
		public int pop() {
			// 스택이 비었을 때 예외 처리
			if (top == -1) {
				System.out.println("스택이 비어 있습니다.");
				return -1; // 스택이 비었으면 -1 반환
			} else {
				int poppedValue = stack[top--]; // top에서 값을 꺼내고 top을 1 감소
				return poppedValue; // 꺼낸 값 반환
			}
		}

		// 스택의 가장 상단 값을 반환하는 메소드 (값을 제거하지 않음)
		public int peek() {
			// 스택이 비었을 때 예외 처리
			if (top == -1) {
				System.out.println("스택이 비어 있습니다.");
				return -1; // 스택이 비었으면 -1 반환
			} else {
				return stack[top]; // top에 있는 값 반환
			}
		}

		// 스택이 비었는지 확인하는 메소드
		public boolean isEmpty() {
			return top == -1; // top이 -1이면 스택이 비어 있다는 의미
		}

		// 스택의 크기를 반환하는 메소드
		public int size() {
			return top + 1; // top 인덱스 + 1이 스택의 크기
		}
	}
}
