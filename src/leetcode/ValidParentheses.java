package leetcode;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0)
			return false;
		char[] charArray = s.toCharArray();
		
		if(charArray[0] == ')' ||
				charArray[0] == '}'||
				charArray[0] == ']')
			return false;
					
		Stack<Character> stack = new Stack<Character>();
		
		
		for(int i = 0 ; i < charArray.length ; i ++) {
			if(charArray[i] == '(' ||
				charArray[i] == '{'||
				charArray[i] == '[') {
				
				stack.push(charArray[i]);
			}else {
				if(stack.isEmpty())
					return false;
				
				char c = stack.pop();
				
				if(!isPair(c,charArray[i])) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	private boolean isPair(char c, char d) {
		if(c == '(' && d == ')')
			return true;
		if(c == '[' && d == ']')
			return true;
		if(c == '{' && d == '}')
			return true;
		return false;
	}

	public static void main(String[] args) {
		boolean valid = new ValidParentheses().isValid("{}[])");
		System.out.println(valid);
	}
}
