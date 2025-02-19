package algo03.StackAndQueue;

import java.util.Stack;

public class stack_rectangularArea {

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(heights)); // 10
	}

	public static int largestRectangleArea(int[] heights) {
		// 히스토그램에서 직사각형 넓이 구하기
		// 주어진 히스토그램에서 가장 큰 직사각형의 넓이를 구하는 문제
		// 스택을 사용하여 높이를 추적하면서 넓이를 계산한다.
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		int i = 0;

		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i++);
			} else {
				int h = heights[stack.pop()];
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, h * width);
			}
		}

		while (!stack.isEmpty()) {
			int h = heights[stack.pop()];
			int width = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, h * width);
		}
		return maxArea;
	}
}
