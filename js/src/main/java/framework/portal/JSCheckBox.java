package framework.portal;

import framework.JSContainer;
import framework.JSInput;

public class JSCheckBox extends JSContainer{

	private JSLabel label;
	
	private JSInput checkbox;
	
	public JSCheckBox(String name, String label) {
		super(name, "div");
		addClass("checkbox");
		checkbox = new JSInput(name).setType(InputTypes.checkbox);
		this.label = new JSLabel("label");
		this.label.setText(label);
		JSContainer wrapper = new JSContainer("label");
		addChild(wrapper);
		wrapper.addChild(checkbox);
		wrapper.addChild(this.label);
		
	}
	
	public boolean isChecked(){
		return "true".equals(checkbox.getValue());
	}
	
	public JSCheckBox setDisabled(boolean b){
		if(b){
			addClass("disabled");
		}else{
			removeClass("disabled");
		}
		return this;
	}
	
	public JSCheckBox setTitleColor(String color){
		label.setStyle("color", color);
		return this;
	}
	
	public JSInput getCheckBox(){
		return checkbox;
	}

}
