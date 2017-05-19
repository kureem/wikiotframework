package framework.portal;

import framework.JSContainer;
import framework.JSInput;
import framework.services.i18nService;

public class JSForm extends JSContainer{

	private i18nService i18n = new i18nService();
	
	public JSForm(String name) {
		super(name, "form");
	}
	
	public JSForm setInline(boolean b){
		if(b){
			addClass("form-inline");
		}else{
			removeClass("form-inline");
		}
		return this;
	}
	
	public JSForm addFormGroup(JSFormGroup group){
		addChild(group);
		return this;
	}
	
	
	public JSFormGroup addInput(JSLabel label, JSInput input){
		JSFormGroup grp = new JSFormGroup("", input, label);
		addChild(grp);
		return grp;
	}
	
	
	
	public JSForm addCheckBox(JSCheckBox cb){
		addChild(cb);
		return this;
	}
	
	public JSFormGroup addInput(JSInput input){
		return addInput(new JSLabel("").setText(i18n.getValue("form." + getName() + "." + input.getName())), input);
	}
	
	public JSForm addButton(JSButton button){
		addChild(button);
		return this;
	}

}
