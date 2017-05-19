package framework.portal;

import framework.Clickable;
import framework.EventListener;
import framework.JSContainer;

public class JSButton extends AbstractColorType implements Clickable<JSButton>{

	
	private JSContainer span = new JSContainer("span");
	
	private JSIcon icon = new JSIcon("icon");
	
	public JSButton(String name) {
		super(name, "a","button");
		addChild(icon);
		addChild(span);
		addClass("btn");
		//URL url = new URL("");
		
		
	}
	
	
	public JSButton setDisabled(boolean b){
		if(b){
			addClass("disabled");
		}else{
			removeClass("disabled");
		}
		return this;
	}
	
	public JSButton setFloat(boolean f){
		if(f){
			addClass("btn-float");
		}else{
			removeClass("btn-float");
		}
		
		return this;
	}
	
	
	public JSButton setText(String txt){
		addClass("has-text");
		span.setHtml(txt);
		return this;
	}
	
	public JSButton clearText(){
		removeClass("has-text");
		span.setHtml("");
		return this;
	}
	
	
	public JSButton setIcon(String icon){
		this.icon.setIcon(icon);
		this.icon.setVisible(true);
		return this;
	}

	@Override
	public JSButton addOnClick(EventListener l) {
		addEventListener(l, "click");
		return this;
	}

	@Override
	public JSButton addOnDoubleClick(EventListener l) {
		addEventListener(l, "dblclick");
		return this;
	}

}
