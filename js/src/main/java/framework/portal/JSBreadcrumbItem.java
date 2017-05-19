package framework.portal;

import framework.JSContainer;
import framework.services.Node;

public class JSBreadcrumbItem extends JSContainer{

	private JSContainer link = new JSContainer("link", "a");
	
	private Node node;
	
	public JSBreadcrumbItem(Node node) {
		super(node.getName(), "li");
		addChild(link);
		setNode(node);
	}
	
	public void setNode(Node node){
		this.node = node;
		link.setHtml(node.getLabel());
	}
	
	public Node getNode(){
		return node;
	}
	
	

}
