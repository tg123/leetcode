class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> swap = new LinkedList<>();

        swap.add(x);

        while(!queue.isEmpty()){
            swap.add(queue.remove());
        }

        queue = swap;
    }

    // Removes the element on top of the stack.
    public void pop() {
        // pop from front
        queue.remove();
    }

    // Get the top element.
    public int top() {
        // peek from front
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
