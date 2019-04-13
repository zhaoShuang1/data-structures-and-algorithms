package tree.huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCodeTest {
	public static void main(String[] args) {
		String str = "can you can a can as a canner can a can";
		byte[] bytes = str.getBytes();
		byte[] zipBytes = zip(bytes);
		System.out.println(Arrays.toString(bytes));
		System.out.println(Arrays.toString(zipBytes));
		byte[] oldBytes = unzip(huffmanCode,zipBytes);
		System.out.println(Arrays.toString(oldBytes));
	}

	public static byte[] unzip(Map<Byte, String> huffmanCode2, byte[] bytes) {
		List<Byte> newBytes = new ArrayList<>();
		
		Map<String,Byte> map = new HashMap<String,Byte>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < bytes.length ; i++) {
			sb.append(byteToString(bytes[i],i != bytes.length-1));
		}
		
		//反转Huffman表
		huffmanCode2.forEach((k,v)->{
			map.put(v, k);
		});
		
		int count = 1;
		for(int i = 0 ; i < sb.length() ;) {
			String str = sb.substring(i, i+count);
			Byte b = map.get(str);
			if(b==null) {
				count++;
			}else {
				i+=count;
				count = 1;
				newBytes.add(b);
			}
		}
		byte[] _newBytes = new byte[newBytes.size()];
		int index = 0;
		for (Byte b : newBytes) {
			_newBytes[index++] = b;
		}
		return _newBytes;
	}
	
	private static String byteToString(byte b,boolean flag) {
		String binaryString = Integer.toBinaryString(b);
		int length = binaryString.length();
		//负数截取后八位
		if(length > 8) {
			binaryString = binaryString.substring(length-8);
		}else { //	正数 ，如果不足八位则补零
			if(flag)
			while(binaryString.length()<8) {
				binaryString = "0".concat(binaryString);
			}
		}
		return binaryString;
	}
	
	
	
	
	
	
	

	public static byte[] zip(byte[] bytes) {
		//字节数组转成节点
		List<Node> nodes = getNodes(bytes);
		//创建Huffmantree
		Node node = createHuffmanTree(nodes);
		//创建Huffman编码表
		Map<Byte,String> huffmanCode = createHuffmanCode(node);
		//编码
		byte[] b1 = encode(huffmanCode,bytes);
		
		return b1;
	}
	
	
	private static byte[] encode(Map<Byte, String> huffmanCode2, byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		
		for (byte b : bytes) {
			sb.append(huffmanCode2.get(b));
		}
		
		//八位一个字节
		byte[] newBytes = new byte[(sb.length()+7)/8];
		int index = 0;
		for(int i = 0 ; i < sb.length();i+=8) {
			String str;
			if(i+8 > sb.length()) {
				str = sb.substring(i);
			}else {
				str = sb.substring(i,i+8);
			}
			System.out.println(str);
			byte b = (byte) Integer.parseInt(str, 2);
			newBytes[index++] = b;
		}
		
		return newBytes;
	}


	static Map<Byte,String> huffmanCode = new HashMap<Byte,String>();
	private static Map<Byte, String> createHuffmanCode(Node node) {
		StringBuilder sb = new StringBuilder();
		if(node == null)return null;
		
		createHuffmanCode("1",node.getLeftNode(),sb);
		createHuffmanCode("0",node.getRightNode(),sb);
		return huffmanCode;
	}

	private static void createHuffmanCode(String p, Node node, StringBuilder sb) {
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.append(p);
		
		if(node.data == null) {
			createHuffmanCode("0", node.getRightNode(), sb2);
			createHuffmanCode("1", node.getLeftNode(), sb2);
		}else {
			huffmanCode.put(node.getData(), sb2.toString());
		}
	}

	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()!=1) {
			Collections.sort(nodes);
			Node left = nodes.get(nodes.size()-1);
			Node right = nodes.get(nodes.size()-2);
			Node parent = new Node(null, left.getValue()+right.getValue());
			parent.setLeftNode(left);
			parent.setRightNode(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}

	private static List<Node> getNodes(byte[] bytes) {
		Map<Byte,Integer> map = new HashMap<>();
		List<Node> nodes = new ArrayList<Node>();
		for (byte b : bytes) {
			Integer c = map.get(b);
			if(c==null) {
				map.put(b, 1);
			}else {
				map.put(b, c+1);
			}
		}
		map.forEach((k,v)->{
			nodes.add(new Node(k, v));
		});
		return nodes;
	}
	
	
	
	public static class Node implements Comparable<Node>{
		private Byte data;
		private Integer value;
		private Node leftNode;
		private Node rightNode;
		
		
		public Node(Byte data, Integer value) {
			super();
			this.data = data;
			this.value = value;
		}
		public Integer getValue() {
			return value;
		}
		public void setValue(Integer value) {
			this.value = value;
		}
		public Byte getData() {
			return data;
		}
		public void setData(Byte data) {
			this.data = data;
		}
		public Node getLeftNode() {
			return leftNode;
		}
		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}
		public Node getRightNode() {
			return rightNode;
		}
		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}
		@Override
		public int compareTo(Node o) {
			return o.getValue()-this.getValue();
		}
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}
	
	
	
	
	
	
	
}









