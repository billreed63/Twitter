
import java.util.List;

public class Node {
	private boolean visted;
	private int id;
	private List<Node> neighbours;
	
	public Node(int id) {
		this.id = id;
		this.neighbours = null;
		visted = false;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNeighbours (List<Node> neighbours ) {
		this.neighbours = neighbours;
	}
	
	public List<Node> getNeighbours() {
		return neighbours;
	}
	
	public boolean hasBeenVisited() {
		return visted;
	}
	
	public void setVisited(boolean b) {
		visted = b;
	}
	
	public void Visited() {
		visted = true;
	}
}
