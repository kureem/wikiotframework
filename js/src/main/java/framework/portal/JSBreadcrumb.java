package framework.portal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import framework.JSContainer;
import framework.services.Node;

public class JSBreadcrumb extends JSContainer implements PageChangeListener{

	private Node currentNode;
	
	public JSBreadcrumb(String name) {
		super(name, "ul");
	}
	
	
	public void setNode(Node node){
		this.currentNode = node;
		Node n = currentNode;
		List<Node> nodes = new LinkedList<>();
		nodes.add(currentNode);
		this.getChildren().clear();
		while(n.getParent() != null){
			JSBreadcrumbItem item = new JSBreadcrumbItem(n.getParent());
			addChildAt(0,item);
		}
	}
	

	@Override
	public void beforeChange(Node currentPage, Node nextPage, Map<String, String> data) {
		System.out.println("change page");
	}

	@Override
	public void onChange(Node currentPage, Node nextPage, Map<String, String> data) {
		this.currentNode = nextPage;
		setNode(currentNode);
	}

	@Override
	public void afterChange(Node currentPage, Node nextPage, Map<String, String> data) {
		
	}
	
	

}
