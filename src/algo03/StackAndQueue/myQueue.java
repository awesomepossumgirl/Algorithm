package algo03.StackAndQueue;

public class myQueue {

	public static void main(String[] args) {
		// 큐 구현한 코드
		// Queue는 선입선출(FIFO, First In First Out) 방식으로 동작한다
		// 큐 구현을 위해 배열을 사옹함
		// 큐 기본 연산 enqueue(삽입), dequeue(삭제), peek(맨 앞 값 보기), isEmpty(비어있는지 확인) 구현
		QueueExample queue = new QueueExample(5); // 크기가 5인 큐 생성

		// 큐에 값 추가 (enqueue)
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);

		// 큐의 가장 앞의 값 확인 (peek)
		System.out.println("큐의 가장 앞의 값: " + queue.peek());

		// 큐에서 값 제거 (dequeue)
		System.out.println("dequeue: " + queue.dequeue());
		System.out.println("dequeue: " + queue.dequeue());

		// 큐가 비었는지 확인
		System.out.println("큐가 비었나요? " + queue.isEmpty());

		// 큐의 크기 확인
		System.out.println("큐 크기: " + queue.size());

		// 큐에서 값을 더 제거
		System.out.println("dequeue: " + queue.dequeue());
		System.out.println("dequeue: " + queue.dequeue()); // 이때는 큐가 비어 있음
	}

	// QueueExample 클래스 정의
	public static class QueueExample {
		// 큐를 구현할 배열
		private int[] queue;
		private int front; // 큐의 앞 인덱스를 추적
		private int rear; // 큐의 뒤 인덱스를 추적
		private int size; // 큐에 들어 있는 요소의 개수

		// 생성자: 큐의 크기를 지정하여 배열을 초기화
		public QueueExample(int capacity) {
			queue = new int[capacity]; // 주어진 크기의 배열을 생성
			front = 0;
			rear = -1;
			size = 0; // 큐가 비어있으므로 size는 0
		}

		// 큐에 값을 추가하는 메소드 (enqueue)
		public void enqueue(int value) {
			// 큐가 꽉 찼을 때 예외 처리
			if (size == queue.length) {
				System.out.println("큐가 꽉 찼습니다.");
			} else {
				rear = (rear + 1) % queue.length; // rear는 순환하여 값을 추가
				queue[rear] = value; // rear 위치에 값을 추가
				size++; // 큐의 크기 증가
				System.out.println(value + "이(가) 큐에 추가되었습니다.");
			}
		}

		// 큐에서 값을 제거하고 반환하는 메소드 (dequeue)
		public int dequeue() {
			// 큐가 비었을 때 예외 처리
			if (size == 0) {
				System.out.println("큐가 비어 있습니다.");
				return -1; // 큐가 비었으면 -1 반환
			} else {
				int dequeuedValue = queue[front]; // front 위치에서 값을 꺼내고
				front = (front + 1) % queue.length; // front는 순환하여 증가
				size--; // 큐의 크기 감소
				return dequeuedValue; // 꺼낸 값 반환
			}
		}

		// 큐의 가장 앞의 값을 반환하는 메소드 (값을 제거하지 않음, peek)
		public int peek() {
			// 큐가 비었을 때 예외 처리
			if (size == 0) {
				System.out.println("큐가 비어 있습니다.");
				return -1; // 큐가 비었으면 -1 반환
			} else {
				return queue[front]; // front에 있는 값 반환
			}
		}

		// 큐가 비었는지 확인하는 메소드
		public boolean isEmpty() {
			return size == 0; // 큐의 크기가 0이면 비어 있다는 의미
		}

		// 큐의 크기를 반환하는 메소드
		public int size() {
			return size; // 큐에 들어 있는 요소의 개수 반환
		}
	}
}
