package framework.builder;

import java.util.LinkedList;
import java.util.List;

public class FormDefinition {

	private String name;

	private List<FieldDefinition> fieldDefinitions = new LinkedList<>();

	private List<ActionDefinition> actionDefinitions = new LinkedList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}

	public List<ActionDefinition> getActionDefinitions() {
		return actionDefinitions;
	}

	public void setActionDefinitions(List<ActionDefinition> actionDefinitions) {
		this.actionDefinitions = actionDefinitions;
	}

}
