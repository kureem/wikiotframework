package framework.services;

import java.util.LinkedList;
import java.util.List;

import framework.JSContainer;

public class SimpleComponentFactory implements ComponentFactory{
	
	private final static List<String> supportedTags = new LinkedList<>();
	
	static{
		supportedTags.add("h1");
		supportedTags.add("h2");
		supportedTags.add("h3");
		supportedTags.add("h4");
		supportedTags.add("h5");
		supportedTags.add("h6");
		supportedTags.add("label");
		supportedTags.add("span");
		supportedTags.add("div");
		supportedTags.add("fieldset");
		supportedTags.add("form");
		supportedTags.add("table");
		supportedTags.add("tr");
		supportedTags.add("td");
		supportedTags.add("thead");
		supportedTags.add("th");
		supportedTags.add("tbody");
		supportedTags.add("td");
		supportedTags.add("tfoot");
	}

	@Override
	public boolean supports(String name) {
		return supportedTags.contains(name);
	}

	@Override
	public JSContainer createInstance(Layout layout, boolean designMode) {
		String name = layout.getComponentName();
		JSContainer container = new JSContainer(name,name);
		
		for(String attr : layout.getAttributes().keySet()){
			String val = layout.getAttributes().get(attr);
			container.setAttribute(attr, val);
		}
		
		for(String style : layout.getStyles().keySet()){
			String val = layout.getAttributes().get(style);
			container.setStyle(style, val);
		}
		
		container.setParameters(layout.getParameters());
		
		return container;
	}
	
	

}
