public class Node {

	// Private variables
	private int id;
	private boolean mark = false;
	
	//constructor method
	//this method, creates a node with the given id.
	public Node(int id) {
		this.id = id;
		mark = false;
	}

	//this method,marks the node with the specified value
	public void setMark(boolean mark) {
		this.mark = mark;
	}

	//this method, returns the value of hte node which has been marked
	public boolean getMark() {
		return mark;
	}

	//returns the id of the node
	public int getName() {
		return id;
	}

}