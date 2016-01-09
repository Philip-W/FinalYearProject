import org.gt4j.annas.graph.GraphInterface;
import org.gt4j.annas.graph.IntegerEdge;
import org.gt4j.annas.graph.UndirectedGraph;
import org.gt4j.annas.graph.classifier.ChordalClassifier;
import org.gt4j.annas.graph.classifier.Classifier;
import org.gt4j.annas.graph.classifier.CoChordalClassifier;

public class CoChordalTest {

	public static void main(String[] args) {
		GraphInterface<Integer, IntegerEdge> graph = new UndirectedGraph<>(IntegerEdge.class);
		
		for(int i =0; i <4; i++){
			graph.addVertex(i);
		}
		
		Classifier<Integer, IntegerEdge> chordal = new ChordalClassifier<>();
		Classifier<Integer, IntegerEdge> cochordal = new CoChordalClassifier<>();
		
		graph.addEdge(0, 1);
		graph.addEdge(2, 3);
		
		System.out.println("2k_2");
		System.out.println("Chordal " +chordal.classify(graph));
		System.out.println("CoChordal " +cochordal.classify(graph));
		
		graph.addEdge(1, 2);
		graph.addEdge(3, 0);
		
		System.out.println("C_4");
		System.out.println("Chordal " +chordal.classify(graph));
		System.out.println("CoChordal " +cochordal.classify(graph));
		
		graph.addEdge(1, 3);
		
		System.out.println("Diamond");
		System.out.println("Chordal " +chordal.classify(graph));
		System.out.println("CoChordal " +cochordal.classify(graph));
	}
	

}
