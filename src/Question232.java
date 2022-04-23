import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class Question232 {
    public static void main(String[] args) {

    }
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> queue = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            while(!queue.empty())
                stack.push(queue.pop());

            stack.push(x);
        }

        public int pop() {
            while(!stack.empty())
                queue.push(stack.pop());

            return queue.pop();
        }

        public int peek() {
            while(!stack.empty())
                queue.push(stack.pop());

            return queue.peek();
        }

        public boolean empty() {
            return stack.empty() && queue.empty();

        }
    }


}
