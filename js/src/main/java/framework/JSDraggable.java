package framework;

import def.jqueryui.jqueryui.DraggableOptions;

public abstract class JSDraggable implements Renderable {
	
	
	
	
	public JSDraggable setDraggable(DraggableOptions options){
		exec("draggable", options);
		return this;
	}
	
	

}
