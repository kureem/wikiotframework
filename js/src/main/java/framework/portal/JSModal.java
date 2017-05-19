package framework.portal;

import static jsweet.dom.Globals.alert;

import framework.EventListener;
import framework.JSContainer;
import framework.Renderable;

public class JSModal extends JSContainer{

	
	private JSContainer content = new JSContainer("div").addClass("modal-content");
	
	private JSContainer dialog = new JSContainer("div").addClass("modal-dialog");
	
	private AbstractColorType header = (AbstractColorType)new AbstractColorType("header", "div", "bg").addClass("modal-header");
	
	private JSContainer body = new JSContainer("div").addClass("modal-body");
	
	private JSContainer footer = new JSContainer("div").addClass("modal-footer");
	
	private JSContainer title = new JSContainer("h5").addClass("modal-title");
	
	private JSContainer close = new JSContainer("a").setAttribute("data-dismiss", "modal").addClass("fa fa-close close");
	
	public JSModal(String name) {
		super(name, "div");
		addClass("modal").addClass("fade");
		addChild(dialog);
		dialog.addChild(content);
		content.addChild(header).addChild(body).addChild(footer);
		
		header.addChild(close).addChild(title);
	}
	
	public JSModal pack(boolean pack){
		if(pack){
			body.addClass("no-padding");
		}else{
			body.removeClass("no-padding");
		}
		return this;
	}
	
	public JSModal show(){
		exec("modal", "show");
		return this;
	}
	
	public JSModal hide(){
		exec("modal", "hide");
		return this;
	}
	
	public JSModal setSize(Size size){
		
		dialog.setAttribute("class", "modal-dialog modal-" + size.toString());
		return this;
	}
	
	public JSModal addOnShowListener(EventListener listener){
		addEventListener(listener, "show.bs.modal");
		return this;
	}
	
	public JSModal addOnShownListener(EventListener listener){
		addEventListener(listener, "shown.bs.modal");
		return this;
	}
	
	public JSModal addOnHideListener(EventListener listener){
		addEventListener(listener, "hide.bs.modal");
		return this;
	}
	
	public JSModal addOnHiddenListener(EventListener listener){
		addEventListener(listener, "hidden.bs.modal");
		return this;
	}
	
	public JSModal addOnLoadedListener(EventListener listener){
		addEventListener(listener, "loaded.bs.modal");
		return this;
	}
	
	public JSModal showHeader(boolean b){
		header.setVisible(b);
		return this;
	}
	
	public JSModal showFooter(boolean b){
		footer.setVisible(b);
		return this;
	}
	
	
	public JSModal setTitle(String txt){
		title.setHtml(txt);
		return this;
	}

	public Renderable getHeader() {
		return header;
	}

	public Renderable getBody() {
		return body;
	}

	public Renderable getFooter() {
		return footer;
	}

	public JSModal disableBackdrop(boolean b){
		if(b){
			setAttribute("data-backdrop", "false");
		}else{
			setAttribute("data-backdrop", "true");
		}
		
		return this;
	}
	
	public JSModal disableKeyboard(boolean b){
		if(b){
			setAttribute("data-keyboard", "false");
		}else{
			setAttribute("data-keyboard", "true");
		}
		
		return this;
	}
	
	public JSModal setColorType(ColorType type){
		
		header.setColorType(type);
		return this;
	}
	
}
