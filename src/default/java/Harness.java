import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.IntegerEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.util.traverse.LexDFS;

public class Harness {

	public static void main(String[] args) {
		GraphInterface<Integer, IntegerEdge> g = new SimpleUndirectedGraph<>(IntegerEdge.class);

		for (int i = 0; i < 5; i++) {
			g.addVertex(i);
		}
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(3, 2);
		g.addEdge(2, 4);
		
		LexDFS<Integer> dfs = new LexDFS<>(g);
		System.out.println(dfs.getOrder());
	}
}
