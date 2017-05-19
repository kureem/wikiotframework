package framework.builder.create;

import java.util.LinkedList;
import java.util.List;

import def.jquery.JQueryEventObject;
import framework.Event;
import framework.EventListener;
import framework.JSContainer;
import framework.portal.JSThumbnail;

public class JSProductType extends JSThumbnail implements EventListener{

	private ProjectType type_;
	
	private List<SelectProjectTypeHandler> handlers = new LinkedList<>();
	
	public JSProductType(ProjectType type) {
		super(type.getName());
		this.type_ = type;
		addCaption(new JSContainer("p").setHtml(type.getLabel()));
		getImage().setSource(type.getIcon());
		getImage().setStyle("width", "100%");
		getCaptions().setStyle("text-align", "center");
		addClass("btn");
		addEventListener(this, "click");
	}
	
	
	public JSProductType addHandler(SelectProjectTypeHandler handler){
		this.handlers.add(handler);
		return this;
	}
	
	
	public JSProductType fireHandlers(){
		for(SelectProjectTypeHandler handler : handlers){
			handler.doSelect(type_);
		}
		return this;
	}
	
	
	public ProjectType getProjectType(){
		return type_;
	}
	
	public interface SelectProjectTypeHandler{
		public void doSelect(ProjectType type);
	}

	@Override
	public void performAction(JSContainer source, Event<JQueryEventObject> evt) {
		getAncestorOfType(JSProjectTypes.class).selectItem(this);
		fireHandlers();
	}

}
