package graph;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Graph {
	private Vertex[] vertex;
	private int currentSize;
	private int[][] matrix;
	
	
	public Graph (int size){
		vertex = new Vertex[size];
		matrix = new int[size][size];
	}
	
	/**
	 * 增加一个顶点
	 * @param vertex
	 */
	public void addVertex(Vertex vertex) {
		matrix[currentSize][currentSize]=1;
		this.vertex[currentSize++] = vertex;
	}
	
	public void addEdge(String v1,String v2) {
		int index1 = 0;
		int index2 = 0;
		
		for (int i = 0 ; i < vertex.length ; i++) {
			if(vertex[i].value.equals(v1)) 
				index1 = i;
			if(vertex[i].value.equals(v2)) 
				index2 = i;
		}
		
		matrix[index1][index2] = 1;
		matrix[index2][index1] = 1;
	}
	
	public void show() {
		for (int[] is : matrix) {
			System.out.println(Arrays.toString(is));
		}
	}
	
	/**
	 * 深度优先算法
	 */
	public void dfs() {
		Stack<Integer> stack = new Stack<>();
		int currentIndex = 0 ;
		stack.push(0);
		vertex[0].visited = true;
		System.out.println(vertex[0].value);
		out:while(!stack.isEmpty()) {
			for (int i = currentIndex+1; i < matrix.length; i++) {
				if(matrix[currentIndex][i]==1 && !vertex[i].visited) {
					stack.push(i);
					vertex[i].visited=true;
					System.out.println(vertex[i].value);
					currentIndex = i;
					continue out;
				}
			}
			
			stack.pop();

			if(!stack.isEmpty())
				currentIndex = stack.peek();
		}
	}
	
	/**
	 * 广度优先算法
	 */
	public void bfs() {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		
		queue.offer(0);
		
		vertex[0].visited=true;
		
		Integer currentIndex = 0 ;
		
		System.out.println(vertex[0].value);
		
		while(!queue.isEmpty()) {
			for(int i = currentIndex+1 ; i < vertex.length ; i ++) {
				if(matrix[currentIndex][i]==1 && !vertex[i].visited) {
					queue.offer(i);
					vertex[i].visited=true;
					System.out.println(vertex[i].value);
				}
			}
			queue.poll();
			currentIndex = queue.peek();
		}
		
		
	}
	
}
