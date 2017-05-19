package framework.portal.widgets;

import framework.JSContainer;
import framework.JSInput;
import framework.portal.InputTypes;
import framework.portal.JSIcon;

public class WSearchForm extends AbstractWidget{

	
	private JSInput input = new JSInput("input");
	public WSearchForm(String name) {
		super(name);
		addClass("has-feedback has-feedback-left");
		addChild(input);
		input.setType(InputTypes.search);
		JSContainer feedback = new JSContainer("div").addClass("form-control-feedback");
		addChild(feedback);
		
		JSIcon icon = new JSIcon("");
		icon.setIcon("icon-search4 text-size-base text-muted");
		feedback.addChild(icon);
		
	}

}
