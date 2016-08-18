package ssa;

import java.util.Stack;

public class RPNCalculator {

	public static void main(String[] args) {
		char[] problem = new char[] {'7','3','*','9','-','3','/'};
		String popoff1 = "";
		String popoff2 = "";
		String popoff3 = "";
		String aString = String.copyValueOf(problem);
		int answer = 0;
		Stack<String> stk = new Stack<String>();
		for(int i = problem.length; i > 0; i--) {
			stk.push(aString.substring(i-1, i));
		}
		do {
			System.out.printf(popoff1 = stk.pop());
			System.out.printf(popoff2 = stk.pop());
			System.out.printf(popoff3 = stk.pop());
		
		
		switch (popoff3)  {
        case "+":
            answer = Integer.parseInt(popoff1) + Integer.parseInt(popoff2);
            System.out.println("Your answer is " + answer);
            break;
        case "-":
            answer = Integer.parseInt(popoff1) - Integer.parseInt(popoff2);
            System.out.println("Your answer is " + answer);
            break;

        case "/":
            answer = Integer.parseInt(popoff1) / Integer.parseInt(popoff2);
            System.out.println("Your answer is " + answer);
            break;

        case "*":
            answer = Integer.parseInt(popoff1) * Integer.parseInt(popoff2);
            System.out.println("Your answer is " + answer);
            break;
		}
		stk.push(answer + "");
		} while(stk.size()>1);
			
	}

}
