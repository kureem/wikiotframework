package framework.portal;

import framework.JSContainer;

public class JSNavBar extends AbstractColorType {

	private JSContainer header = new JSContainer("div");

	private JSContainer content = new JSContainer("div").addClass("navbar-collapse collapse");

	public JSNavBar(String name) {
		super(name, "div", "navbar");
		addClass("navbar");
		header.addClass("navbar-header");
		addChild(header);
		addChild(content);
		setColorType(ColorType.DEFAULT);
	}

	public JSNavBar setCollapse(boolean b){
		if(b){
			addClass("navbar-collapse");
		}else{
			removeClass("navbar-collapse");
		}
		return this;
	}
	
	public void setHeader(JSContainer container) {
		header.getChildren().clear();
		header.addChild(container);
	}

	public JSNavBar addTextItem(JSContainer text) {

		text.addClass("navbar-text");
		content.addChild(text);
		return this;
	}

	public JSNavBar addGroupItem(JSNavbarGroup grp) {
		content.addChild(grp);
		return this;
	}

	public JSNavBar addButtonItem(JSButton button) {
		button.addClass("navbar-btn");
		content.addChild(button);
		return this;
	}

	public JSNavBar setFixToTop(boolean b) {
		if (b) {
			addClass("navbar-fixed-top");
			removeClass("navbar-fixed-bottom");
			removeClass("navbar-static-top");
		} else {
			removeClass("navbar-fixed-top");
		}

		return this;
	}

	public JSNavBar addFormItem(JSForm form) {
		form.addClass("navbar-form");
		content.addChild(form);
		return this;
	}

	public JSNavBar setFixToBottom(boolean b) {

		if (b) {
			addClass("navbar-fixed-buttom");
			removeClass("navbar-fixed-top");
			removeClass("navbar-static-top");
		} else {
			removeClass("navbar-fixed-bottom");
		}

		return this;
	}

	
	public JSNavBar setStaticTop(boolean b){
		if (b) {
			addClass("navbar-static-top");
			removeClass("navbar-fixed-buttom");
			removeClass("navbar-fixed-top");
		} else {
			removeClass("navbar-static-top");
		}
		return this;
	}
	
	public JSNavBar setInverted(boolean b){
		if(b){
			addClass("navbar-inverse");
		}else{
			removeClass("navbar-inverse");
		}
		return this;
	}
	
	public JSNavBar setSize(Size size){
		for(Size s : Size.values()){
			removeClass("navbar-" + s.toString());
		}
		
		if(size != null)
			addClass("navbar-" + size.toString());
		
		return this;
	}
}
