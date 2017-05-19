package framework.renderer;

import static def.jquery.Globals.$;
import static jsweet.lang.Globals.eval;

import java.util.List;

import def.jquery.JQuery;
import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.JSContainer.JSCommand;
import framework.JSInput;
import framework.Renderable;
import framework.portal.InputField;
import jsweet.dom.HTMLElement;
import jsweet.dom.NamedNodeMap;

public class ContainerRenderer implements Renderer<JSContainer> {

	public void doRender(JSContainer c) {

		JQuery jq = $("#" + c.getId());
		String tag = c.getTag();
		boolean rendered = c.isRendered();
		String name = c.getName();
		String html = c.getHtml();
		Renderable parent = c.getParent();
		if (!rendered) {
			jq.remove();
			String shtml = "<" + tag + "></" + tag + ">";
			JQuery njq = $(shtml);
			if(name != null && name.length() > 0)
				njq.attr("name", name);
			njq.attr("id", c.getId()).html(html);
			renderAttributes(njq, c, false);
			renderStyles(njq, c, false);

			if (parent == null) {
				njq.appendTo($("body"));
			} else {
				int index = parent.getChildren().indexOf(c);
				Renderable prevSib = null;
				Renderable nextSib = null;
				if(index > 0){
					prevSib = parent.getChildren().get(index-1);
					if(!prevSib.isRendered()){
						prevSib = null;
					}
				}
				if(index < parent.getChildren().size()-1){
					nextSib = parent.getChildren().get(index+1);
					if(!nextSib.isRendered()){
						nextSib = null;
					}
				}
				if(prevSib != null){
					njq.insertAfter($( "#" +prevSib.getId()));
				}else if(nextSib != null){
					njq.insertBefore($( "#" +nextSib.getId()));
				}else{
					njq.appendTo($("#" + parent.getId()));
				}
			}
			renderEvents(njq, c);
			execCommands(njq, c);
			c.flush("a28n12l10");
		} else {
			renderAttributes(jq, c, true);
			renderStyles(jq, c,true);
			execCommands(jq, c);
			c.flush("a28n12l10");

		}
	}
	
	protected void execCommands(JQuery njq, Renderable container){
		for(JSCommand command : container.getCommands()){
			String name = command.getName();
			jsweet.lang.Object params = command.getParameters();
			String variable = command.getVariable();
			if(params == null && variable == null){
				eval("njq." + name + "()");
			}else if(params != null){
				eval("njq." + name + "(params)");
			}else if(variable != null){
				eval("njq." + name + "('"+variable+"')");
			}
		}
	}

	protected void renderEvents(JQuery njq, JSContainer c) {
		
		for (String key : c.getListeners().keySet()) {
			final List<EventListener> listeners = c.getListeners().get(key);
			njq.on(key, (e, o) -> {
				for (EventListener l : listeners) {
					Event<JQueryEventObject> evt = new Event<>(e);
					l.performAction(c, evt);
				}
				c.getRoot().render();
				return o;
			});
		}

	}
	
	
	protected void synchronizeFields(JQuery njq,Renderable field){
		
		if(field instanceof InputField){
			InputField<String> inputField = (JSInput)field;
			if(field.getTag().equals("input") && "checkbox".equals(field.getAttribute("type"))){
				if($("#" + field.getId() + ":checked").length > 0){
					inputField.setRawValue("true");
				}else{
					inputField.setRawValue("false");
				}
			}else{
				
				if(njq.val() == null){
					inputField.setRawValue("");
				}else{
					inputField.setRawValue(njq.val().toString());
				}
			}
		}
		
		for(Renderable c : field.getChildren()){
			synchronizeFields($("#" + c.getId()), c);
		}
		
	}

	protected void renderAttributes(JQuery njq, Renderable c, boolean changed) {

		if(changed){
			for (String key : c.getChangedAttributes()) {
				njq.attr(key, c.getAttribute(key));
			}
		}else{
			for (String key : c.getAttributeNames()) {
			njq.attr(key, c.getAttribute(key));
			}
		}
	}

	protected void clearAttributes(JQuery jq) {
		if (jq.length > 0) {
			HTMLElement elem = jq.$get(0);
			NamedNodeMap attrs = elem.attributes;
			for (double i = 0; i < attrs.length; i++) {
				if(!attrs.$get(i).name.equals("id"))
					jq.removeAttr(attrs.$get(i).name);
			}
		}
	}

	protected void clearStyles(JQuery jq) {
		jq.removeAttr("style");

	}

	protected void renderStyles(JQuery njq, Renderable c, boolean changed) {

		if(changed){
			for (String key : c.getChangedStyles()) {
				njq.css(key, c.getStyle(key));
			}
		}else{
			for (String key : c.getStyleNames()) {
				njq.css(key, c.getStyle(key));
			}
		}
	}
}
