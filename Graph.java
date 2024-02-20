/*THIS CLASS REPRESTENTS AN UNDIRECTED GRAPH
 * STUDENT ID = 251185394
 * AUTHOR = SARA MEHRAVAR
 */
import java.util.*;


public class Graph {

	// Private variables
	private Node node[];	
	private Edge edge[][];	

	//constructor
	//this method creates a graph with n nodes and no edges
	public Graph(int n){

		// we are Creating an array for the nodes and edges
		node = new Node[n];
		edge = new Edge[n][n];
		
		//the ids of the nodes are 0,1,2,..,n-1 so less than n 
		for (int i=0; i < n; i++){
			
			node[i] = new Node(i);
		}

	}
	//this method gets the node with a specified name
	 
	public Node getNode(int name) throws GraphException{

		// if the name of the node is valid based on instructions, we will return the node
		if (name>=0 && name<node.length)
			return node[name];
		else
			//otherwise, we will throw an exception
			throw new GraphException("Invalid node");
	}


	//this method adds an edge of the given type connecting U and V
	public void addEdge(Node u, Node v, String edgeType) throws GraphException{

		// checking the conditions for the nodes
		if (u.getName()>=0 && v.getName()>=0 && u.getName()<node.length && v.getName()<node.length){

			// checking if there is no edge between them
			if (edge[u.getName()][v.getName()] == null && edge[v.getName()][u.getName()] == null){

				// forming the edges we want to add 
				edge[u.getName()][v.getName()] = new Edge(u, v, edgeType);
				edge[v.getName()][u.getName()] = new Edge(v, u, edgeType);
			}
			else
				// if there is an edge connecting the given nodes in the graph, we will throw an exception
				throw new GraphException("Edge already exists,try again");
		}
		else
			// if the node does not exist, we will throw an exception
			throw new GraphException("invalid node,try again");
	}

	
	//this method, returns a java iterator storing all the edges incident on the node u.
	public Iterator<Edge> incidentEdges(Node u) throws GraphException{

		// checking whether the node is valid based on the description
		if (u.getName() >= 0 && u.getName() < node.length){

			// we will create a stack of edges
			Stack<Edge> incidentEdges = new Stack<Edge>();

			// using for to iterate over each edge in the graph that are incident on u
			for (int i = 0; i < node.length; i++){
				if (edge[u.getName()][i] != null){

					// pushing the edge into the stack
					incidentEdges.push(edge[u.getName()][i]);
				}
			}
			// if the stack is empty, we will return null
			if (incidentEdges.isEmpty()){
				return null;
			}
			else{
				// else we will return the iterator for the stack
				return incidentEdges.iterator();
			}
		}
		else
			// if u does not have any edges incident on it, we will return exception
			throw new GraphException("Invalid node");
	}

	//this method, returns the edge connecting nodes u and v
	public Edge getEdge(Node u, Node v) throws GraphException{

		// checking if the node is valid based on description
		if (u.getName()>=0 && v.getName()>=0 && u.getName()<node.length && v.getName()<node.length){

			// checking whether there is any edge between u and v
			if (edge[u.getName()][v.getName()] == null){

				// if not, we will throw an exception
				throw new GraphException("No edge between specified nodes");
			}
			else{
				// if there is, we will return the edge
				return edge[u.getName()][v.getName()];
			}
		}

		else{
			// if one of the nodes are invalid, throw an exception
			throw new GraphException("Invalid node");
		}
	}

	// this method,returns true if nodes u and v are adjacent and false otherwise
	public boolean areAdjacent(Node u, Node v) throws GraphException{

		//checking if the nodes are valid
		if (u.getName()>=0 && v.getName()>=0 && u.getName()<node.length && v.getName()<node.length)

			// if the edge exists between the nodes,return true
			if(edge[u.getName()][v.getName()] != null){
				return true;
			}

			else{
				// otherwise, return false
				return false;
			}

		else
			// we will throw an exception if a node is invalid
			throw new GraphException("Invalid node");
	}
}