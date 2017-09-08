package framework.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Layout {

	private String componentName;

	private Map<String, String> attributes = new HashMap<>();

	private Map<String, String> styles = new HashMap<>();

	private Map<String, String> events = new HashMap<>();

	private Map<String, String> parameters = new HashMap<>();

	private List<Layout> children = new LinkedList<>();

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}

	public Map<String, String> getStyles() {
		return styles;
	}

	public void setStyles(Map<String, String> styles) {
		this.styles = styles;
	}

	public Map<String, String> getEvents() {
		return events;
	}

	public void setEvents(Map<String, String> events) {
		this.events = events;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public List<Layout> getChildren() {
		return children;
	}

	public void setChildren(List<Layout> children) {
		this.children = children;
	}
	
	
	

}
