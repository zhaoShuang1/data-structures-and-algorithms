package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int max = 0,left = 0,right = 0,len = s.length();
		boolean[] flags = new boolean[128];
		
		while(right<len) {
			if(!flags[s.charAt(right)]) {
				flags[s.charAt(right)] = true;
				right++;
				max = Math.max(max, right-left);
			}else {
				while(s.charAt(left) != s.charAt(right)) {
					flags[s.charAt(left++)] = false;
				}
				left++;
				right++;
			}
		}
		return max==0?len:max;
	}
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = 
				new LongestSubstringWithoutRepeatingCharacters();
		int i = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aab");
		
		System.out.println(i);
	}

}
