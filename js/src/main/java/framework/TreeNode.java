package framework;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	
	private String text;
	
	private List<TreeNode> nodes = new LinkedList<>();
	
	private Object userObject;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<TreeNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeNode> nodes) {
		this.nodes = nodes;
	}

	public Object getUserObject() {
		return userObject;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}
	
	
	
}
