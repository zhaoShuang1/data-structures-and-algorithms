package demo13;

public class GraphTest {
	public static void main(String[] args) {
		Graph graph = new Graph(6);
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		
		graph.addEdge("A", "C");
		graph.addEdge("A", "B");
		graph.addEdge("B", "D");
		graph.addEdge("E", "C");
		graph.addEdge("F", "C");
		graph.addEdge("E", "F");
		
		graph.show();
		//graph.dfs();
		graph.bfs();
		
	}

}
