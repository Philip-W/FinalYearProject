import static org.junit.Assert.*;

import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.IntegerEdge;
import org.gt4j.annas.graph.SimpleUndirectedGraph;
import org.gt4j.annas.graph.UndirectedGraph;
import org.gt4j.annas.graph.classifier.ChordalClassifier;
import org.gt4j.annas.graph.classifier.Classifier;
import org.gt4j.annas.graph.classifier.CoChordalClassifier;
import org.gt4j.annas.graph.generate.CycleGraphGenerator;
import org.gt4j.annas.graph.generate.DefaultVertexFactory;
import org.gt4j.annas.graph.generate.GraphGenerator;
import org.gt4j.annas.graph.util.Utilities;
import org.junit.Test;

public class TestChordal {

	@Test
	public void test_cycle() {
		for (int i = 4; i < 200; i++) {
			cycle(i);

		}
	}

	@Test
	public void test_cycle_comp() {
		for (int i = 4; i < 200; i++) {
			cycle_comp(i);
		}
	}

	private void cycle(int i) {
		GraphGenerator g = new CycleGraphGenerator(i);
		GraphInterface<Integer, IntegerEdge> graph = new UndirectedGraph<>(IntegerEdge.class);
		g.generateGraph(graph, new DefaultVertexFactory(), null);

		Classifier<Integer, IntegerEdge> chordal = new ChordalClassifier<>();
		assertFalse(chordal.classify(graph));

	}

	private void cycle_comp(int i) {
		GraphGenerator g = new CycleGraphGenerator(i);
		GraphInterface<Integer, IntegerEdge> graph = new SimpleUndirectedGraph<>(IntegerEdge.class);
		g.generateGraph(graph, new DefaultVertexFactory(), null);
		graph = getComp(graph);

		Classifier<Integer, IntegerEdge> cochordal = new CoChordalClassifier<>();

		assertFalse(cochordal.classify(graph));

	}

	private GraphInterface<Integer, IntegerEdge> getComp(GraphInterface<Integer, IntegerEdge> graph) {
		GraphInterface<Integer, IntegerEdge> retval = new SimpleUndirectedGraph<>(IntegerEdge.class);
		retval.addVertices(graph.getVertices());
		for (Integer v : graph.getVertices()) {
			for (Integer u : graph.getVertices()) {
				if (graph.getEdges(v, u).size() == 0) {
					retval.addEdge(v, u);
				}
			}
		}
		return retval;
	}

}
