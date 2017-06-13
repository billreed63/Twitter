import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	@org.junit.Test
	public void bfsTest() {
		ArrayList<Node> al = new ArrayList<Node>(); 
		Node node40 =new Node(40);
		 Node node10 =new Node(10);
		 Node node20 =new Node(20);
		 Node node30 =new Node(30);
		 Node node60 =new Node(60);
		 Node node50 =new Node(50);
		 Node node70 =new Node(70);
	
		 node40.setNeighbours(Arrays.asList(new Node[] {node20, node10}));
		 node10.setNeighbours(Arrays.asList(new Node[] {node30}));
		 node20.setNeighbours(Arrays.asList(new Node[] {node10, node30, node60, node50}));
		 node30.setNeighbours(Arrays.asList(new Node[] {node60}));
		 node60.setNeighbours(Arrays.asList(new Node[] {node70}));
		 node50.setNeighbours(Arrays.asList(new Node[] {node70}));
		 node70.setNeighbours(Arrays.asList(new Node[] {}));

		
		al.add(node40);
		al.add(node10);
		al.add(node20);
		al.add(node30);
		al.add(node60);
		al.add(node50);
		al.add(node70);
		
		BreathFirstSearch bfs = new BreathFirstSearch(node40,  al);
		String r = bfs.search();
		assertEquals("40 20 10 30 60 50 70 ", r);

	}
	
	@org.junit.Test
	public void dfsTest() {
		ArrayList<Node> al = new ArrayList<Node>(); 
		Node node40 =new Node(40);
		 Node node10 =new Node(10);
		 Node node20 =new Node(20);
		 Node node30 =new Node(30);
		 Node node60 =new Node(60);
		 Node node50 =new Node(50);
		 Node node70 =new Node(70);
	
		 node40.setNeighbours(Arrays.asList(new Node[] {node20, node10}));
		 node10.setNeighbours(Arrays.asList(new Node[] {node30}));
		 node20.setNeighbours(Arrays.asList(new Node[] {node10, node30, node60, node50}));
		 node30.setNeighbours(Arrays.asList(new Node[] {node60}));
		 node60.setNeighbours(Arrays.asList(new Node[] {node70}));
		 node50.setNeighbours(Arrays.asList(new Node[] {node70}));
		 node70.setNeighbours(Arrays.asList(new Node[] {}));

		
		al.add(node40);
		al.add(node10);
		al.add(node20);
		al.add(node30);
		al.add(node60);
		al.add(node50);
		al.add(node70);
		
		DepthFirstSearch bfs = new DepthFirstSearch();
		String r = bfs.search(node40);
		assertEquals("40 20 10 30 60 70 50 ", r);

	}

}
