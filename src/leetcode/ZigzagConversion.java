package leetcode;

public class ZigzagConversion {
	public String convert(String s, int numRows) {
		if(s == null)
			return null;
		if(numRows == 1)
			return s;
		
		StringBuilder result = new StringBuilder();
		//计算临时数组长度
		int len = numRows > s.length() ? s.length() : numRows;
				
		StringBuilder[] sbs = new StringBuilder[len];
		//初始化临时数组
		for(int i = 0 ; i < len ; i ++ ) {
			sbs[i] = new StringBuilder();
		}
		
		boolean turn = false;
		
		for(int i = 0,index = 0 ; i < s.length() ; i++ ) {
			//如果走到第一个或者最后一个位置则换方向
			if(index == 0 || index == len-1) {
				turn = !turn;
			}
			sbs[index].append(s.charAt(i));
			//调整下标
			index = index+(turn ? 1:-1);
		}
		
		//字符串拼接
		for(StringBuilder sb :sbs) {
			result.append(sb);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String convert = new ZigzagConversion().convert("", 2);
		
		System.out.println(convert);
		
	}
}
