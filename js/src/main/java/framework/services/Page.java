package framework.services;

import framework.portal.JSPage;

public class Page {

	private String name;
	
	private String label;
	
	private Class<? extends JSPage> implementation;

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

	public Class<? extends JSPage> getImplementation() {
		return implementation;
	}

	public void setImplementation(Class<? extends JSPage> implementation) {
		this.implementation = implementation;
	}
	
	
	
}
