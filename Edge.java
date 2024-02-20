public class Edge {

	// Private variables
	private Node U;
	private Node V;
	private String type;

	//constructor method.
	//the first two parameters are the end points of the edge
	public Edge(Node u, Node v, String type) {
		this.U = u;
		this.V = v;
		this.type = type;
	}

	//returns the first endpoint of the edge
	public Node firstEndpoint() {
		return U;
	}

	//returns the second end point
	public Node secondEndpoint() {
		return V;
	}

	//returns the type of edge
	public String getType() {
		return type;
	}


}
