package org.wikiot.server;

import java.util.LinkedList;
import java.util.List;

public class Component {

	private String name;

	private String label;

	private String icon;

	private List<Parameter> parameters = new LinkedList<>();

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		try {
			return ((Component) obj).getName().equals(name);
		} catch (Exception e) {
			return false;
		}
	}

}
