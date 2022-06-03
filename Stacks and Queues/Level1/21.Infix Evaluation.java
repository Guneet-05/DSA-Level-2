import java.io.*;
import java.util.*;

public class Main{
 
public static int calculate(int a,char op, int b) {
    if(op == '+') {
        return a + b;
    } else if(op == '-') {
        return a - b;
    } else if(op == '*') {
        return a * b;
    } else {
        return a/b;
    }
}  

public static int precedence(char op) {
    if(op == '*' || op =='/') return 2;
    else if(op == '+' || op == '-') return 1;
    return 0;
}

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

    // code
    Stack<Character> operator = new Stack<>();
    Stack<Integer> operand = new Stack<>();
    
    for(int i=0;i<exp.length();i++) {
        char ch = exp.charAt(i);
        if(Character.isDigit(ch) == true) {
            operand.push(ch-'0');
        } else if(ch == '(') {
            operator.push(ch);
        } else if(ch == ')') {
            while(operator.peek() != '(') {
                int b = operand.pop();
                int a = operand.pop();
                char op = operator.pop();
                operand.push(calculate(a,op,b));
            }
            operator.pop();
        } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            while(operator.size() > 0 && operator.peek() != '(' && precedence(operator.peek()) >= precedence(ch)) {
                int b = operand.pop();
                int a = operand.pop();
                char op = operator.pop();
                operand.push(calculate(a,op,b));
            }
            operator.push(ch);
        }
    }
    
    while(operator.size() > 0) {
        int b = operand.pop();
        int a = operand.pop();
        char op = operator.pop();
        operand.push(calculate(a,op,b));
    }
    
    System.out.println(operand.pop());
 }
}
