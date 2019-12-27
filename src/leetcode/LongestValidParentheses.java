package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int max = 0 ;
		
		for(int i = 0 ; i < s.length() ; i ++) {
			for(int j = i+2 ; j <= s.length() ; j+=2) {
				if(isPair(s.substring(i,j))) {
					max = Math.max(max, j-i);
				}
			}
		}
		return max;
	}
	
	private boolean isPair(String s ) {
		Stack<Character> stack = new Stack<Character>();
		char[] charArray = s.toCharArray();
		
		for( int i = 0 ; i < charArray.length ; i ++) {
			if(charArray[i] == '(') {
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
		return false;
	}
	
	
	public static void main(String[] args) {
		int i = new LongestValidParentheses().longestValidParentheses("(()");
		System.out.println(i);
	}
}
