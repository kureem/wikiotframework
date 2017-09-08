package framework.builder;

import framework.JSContainer;
import framework.builder.model.AbstractComponentFactory;

public class BasicComponentFactory extends AbstractComponentFactory{

	private String tag;
	
	public BasicComponentFactory(String tag) {
		super("html:" + tag);
		this.tag = tag;
	}

	@Override
	public JSContainer createInstance() {
		JSContainer container = new JSContainer(tag);
		return container;
	}

}
