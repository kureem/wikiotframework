package framework.portal.widgets;

import framework.portal.JSMedia;

public class JSMediaList extends AbstractWidget {

	public JSMediaList(String name) {
		super(name);
		addClass("media-list");
		setTag("ul");
	}
	
	public JSMediaList addItem(JSMedia item){
		item.setTag("li");
		addChild(item);
		return this;
	}

}
