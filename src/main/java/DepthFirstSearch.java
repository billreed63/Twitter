import java.util.Iterator;
import java.util.List;

public class DepthFirstSearch {

	public String search(Node n) {
		String r = "";
		System.out.println(n.getId() + " ");
		r = r + n.getId() + " ";
		List<Node> neighbours = n.getNeighbours();
		Iterator<Node> i = neighbours.iterator();
		while (i.hasNext()) {
			Node node = i.next();
			if (!node.hasBeenVisited()) {
				r = r + search(node);
				node.setVisited(true);
			}
		}
		return r;
	}
}
