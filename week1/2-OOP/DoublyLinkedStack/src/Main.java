public class Main {
    public static void main(String[] arguments) {
        DoublyLinkedStack myStack = new DoublyLinkedStack(10);
        
        myStack.push(3);
        myStack.push(5);
        myStack.push(7);
        myStack.push(7);
        myStack.push(8);
        
        System.out.println("Stack Length: " + myStack.length());
        myStack.printElements();
        
        System.out.println("Peek At The Stack: " + myStack.peek());     
        
        System.out.println("Popped Element: " + myStack.pop());
        
        System.out.println("Peek At The Stack: " + myStack.peek()); 
        
        System.out.println("Stack Empty? " + myStack.isEmpty());
        
        System.out.println("Stack Cleared...!");
        myStack.clear();
        
        System.out.println("Stack Empty? " + myStack.isEmpty());
        
    }
}
