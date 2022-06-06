import java.io.*;
import java.util.*;

public class Main{

public static int operation(int val1, char op, int val2) {
    
    if(op == '+') {
        return val1 + val2;
    } else if(op == '-') {
        return val1 - val2;
    } else if(op == '*') {
        return val1 * val2;
    }
    
    return val1/val2;
}  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Integer> value = new Stack<>();
    Stack<String> infix = new Stack<>();
    Stack<String> prefix = new Stack<>();
    
    for(int i=0;i<exp.length();i++) {
        char ch = exp.charAt(i);
        
        if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            int v2 = value.pop();
            int v1 = value.pop();
            int val = operation(v1,ch,v2);
            value.push(val);
            
            String inv2 = infix.pop();
            String inv1 = infix.pop();
            String inv = "(" + inv1 + ch + inv2 + ")"; 
            infix.push(inv);
            
            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String prev = "" + ch + prev1 + prev2;
            prefix.push(prev);
        } else {
            value.push(ch - '0');
            infix.push("" + ch);
            prefix.push("" + ch);
        }
    }
    
    System.out.println(value.pop());
    System.out.println(infix.pop());
    System.out.println(prefix.pop());
    
 }
}
