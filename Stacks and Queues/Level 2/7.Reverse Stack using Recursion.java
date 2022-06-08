import java.util.Stack;

public class Solution {
    
    public static void insertAtBottom(Stack<Integer> stk, int val) {
        if(stk.empty()) {
            stk.push(val);
            return;
        }
        
        int top = stk.pop();
        insertAtBottom(stk,val);
        stk.push(top);
    }
    
	public static void reverseStack(Stack<Integer> stack) {
		// write your code here
		if(stack.empty()) {
            return;
        }
        
        int val = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack,val);
	}

}
