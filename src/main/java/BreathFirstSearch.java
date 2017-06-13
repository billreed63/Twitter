import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class BreathFirstSearch {
	
	private LinkedList<Node> queue;
	private List<Node> nodes;
	
	public BreathFirstSearch(Node root, List<Node> nodes) {
		this.nodes = nodes;
		// 1. Create empty queue and push root node to it.
		queue = new LinkedList<Node>();
		queue.add(root);
	}
	
	public String search() {
		String result = "";
		/*
		 * Do the following when queue is not empty
			Pop a node from queue and print it.
			Find neighbours of node with the help of adjacency matrix and check if node is already visited or not.
			Push neighbours of node into queue if not null
		 */
		while(!queue.isEmpty()) {
			Node n = queue.removeFirst();
			System.out.print(n.getId() + " ");
			result = result + n.getId() + " ";
			List<Node> neighbours = n.getNeighbours();
			Iterator<Node> i = neighbours.iterator();
			while (i.hasNext()) {
				Node nn = i.next();
				if (!nn.hasBeenVisited()) {
					nn.Visited();
					queue.add(nn);
				}
			}
			result = result + search();
		}
		return result;
	}
}
