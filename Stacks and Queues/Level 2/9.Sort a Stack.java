import java.util.*;
public class Solution {

    public static void insertAtSorted(Stack<Integer> stack,int val) {
        if(stack.empty() || stack.peek() <= val) {
            stack.push(val);
            return;
        }
        
        int top = stack.pop();
        insertAtSorted(stack,val);
        stack.push(top);
    }
    
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(stack.empty()) {
            return;
        }
        
        int top = stack.pop();
        sortStack(stack);
        insertAtSorted(stack,top);
	}

}
