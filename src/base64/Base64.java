package base64;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public class Base64 {
	private static final String DICT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/";
	
	public static void main(String[] args) {
		String encode = encode("1231@$bashj");
		System.out.println(encode);
		String string = java.util.Base64.getEncoder().encodeToString("1231@$bashj".getBytes());
		System.out.println(string);
		
		String decode = decode("MTIzYWJj");
		System.out.println(decode);
		
	}
	
	public static String encode(final String content) {
		assertThat(content, notNullValue());
		
		final StringBuilder builder = new StringBuilder();
		//转成二进制字符串
		String binaryStr = toBinaryString(content);
		
		Splitter
			.fixedLength(6)	//按六位分隔
			.splitToList(binaryStr) 
			.stream().forEach((b)->{
				
				if(b.length() < 6) {
					b = b + Strings.repeat("0", 6-b.length());
				}
				builder.append(DICT.charAt(Integer.valueOf(b,2)));
			});
		
		int l = 6 - binaryStr.length()%6;
		for(int i = 0 ;i < l/2 ; i++ ) {
			builder.append("=");
		}
		
		return builder.toString();
	}
	


	public static String decode(String content) {
		assertThat(content, notNullValue());
		
		
		StringBuilder builder = new StringBuilder();
		String binaryString = toBase64BinaryString(content);
		
		
		Splitter
		.fixedLength(8)	//按八位分隔
		.splitToList(binaryString) 
		.stream().forEach((b)->{
			char c = Character.toChars(Integer.valueOf(b,2))[0];
			builder.append(c );
		});
		
		
		return builder.toString();
	}
	
	
	private static String toBinaryString(final String content) {
		final StringBuilder builder = new StringBuilder();
		
		for(int i = 0 ; i < content.length();i++) {
			String binaryString = Integer.toBinaryString(content.charAt(i));
			for(int pad = 8-binaryString.length() ; pad > 0 ; pad --) {
				binaryString = "0"+binaryString;
			}
			builder.append(binaryString);
		}
		return builder.toString();
	}
	
	private static String toBase64BinaryString(final String content) {
		StringBuilder builder = new StringBuilder();
		String temp = content;
		int index = content.indexOf("=");
		if(index > 0) {
			temp = temp.substring(0, index);
		}
		
		for(int i = 0; i < temp.length() ; i++) {
			int k = DICT.indexOf(temp.charAt(i));
			String binaryString = Integer.toBinaryString(k);
			for(int pad = 6-binaryString.length() ; pad > 0 ; pad --) {
				binaryString = "0"+binaryString;
			}
			builder.append(binaryString);
		}
		
		return builder.toString();
	}
}
