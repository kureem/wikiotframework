package framework.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import framework.JSContainer;
import framework.portal.JSPage;

public class Node {

	private String name;

	private String label;

	private String icon;

	private Node parent;

	private boolean active;
	
	

	private List<Node> children = new LinkedList<>();

	private Map<String, String> data = new HashMap<>();

	private Page page;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


	
}
