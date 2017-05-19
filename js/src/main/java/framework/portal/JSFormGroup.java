package framework.portal;

import framework.JSContainer;
import framework.JSInput;

public class JSFormGroup extends JSContainer{

	private JSInput input;
	
	private JSLabel label;
	
	public JSFormGroup(String name, JSInput input, JSLabel label) {
		super(name, "div");
		addClass("form-group");
		addChild(label);
		addChild(input);
		this.input = input;
		this.label = label;
		input.addClass("form-control");
	}

	public JSInput getInput() {
		return input;
	}

	public JSLabel getLabel() {
		return label;
	}
	
	
	
	public JSFormGroup setTitleColor(String color){
		label.setStyle("color", color);
		return this;
	}

}
