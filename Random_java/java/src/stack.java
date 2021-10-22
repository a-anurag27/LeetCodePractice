public class stack{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public stack(int s){
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long k){
        stackArray[++top] = k;
    }
    public long pop(){
        return stackArray[top--];
    }
    public long peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxSize-1);
    }

    public static void main(String[] args) {
        stack newStack = new stack(10);
        newStack.push(32);
        newStack.push(35);
        newStack.push(10);
        newStack.push(13);
        newStack.push(28);

        while (! newStack.isEmpty()){
            long value = newStack.pop();
            System.out.print(value + " ");
        }

    }


}
