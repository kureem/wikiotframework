package framework.services;

import java.util.LinkedList;
import java.util.List;

import framework.JSContainer;
import jsweet.lang.Array;
import jsweet.lang.JSON;
import jsweet.lang.Object;



public class ComponentService implements ComponentFactory{

	private List<Component> components = null;

	
	private List<ComponentFactory> factories = new LinkedList<>();
	
	
	private static ComponentService instance;
	
	
	public static ComponentService getInstance(){
		if(instance== null){
			instance = new ComponentService();
			instance.factories.add(new SimpleComponentFactory());
		}
		return instance;
	}	
	
	private ComponentService(){
		
	}
	
	
	private String json = "[{\"name\":\"h1\",\"label\":\"H1\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"h2\",\"label\":\"H2\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"h3\",\"label\":\"H3\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"h4\",\"label\":\"H4\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"h5\",\"label\":\"H5\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"span\",\"label\":\"SPAN\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"label\",\"label\":\"LABEL\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"input\",\"label\":\"INPUT\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"textarea\",\"label\":\"TEXTAREA\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"div\",\"label\":\"DIV\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			+ ",{\"name\":\"table\",\"label\":\"TABLE\",\"parameters\":[{\"name\":\"placeholder\",\"label\":\"PlaceHolder\"},{\"name\":\"defaultValue\",\"label\":\"Default Value\"},{\"name\":\"datasource\",\"label\":\"DateSource\"},{\"name\":\"datafield\",\"label\":\"DataField\"}]}"
			
			
			+ "]";
	private void loadComponents()  {	
		if (components == null) {
			Array<Object> comps = (Array<Object>)JSON.parse(json);
			components = new LinkedList<>();
			for(Object c : comps){
				Component co = new Component();
				co.setName(c.$get("name").toString());
				co.setLabel(c.$get("label").toString());
				components.add(co);
			}
			//components = (List<Component>)JSON.parse(json);
			
		}
	}

	public Component saveComponents(Component component){
		if(!components.contains(component)){
			components.add(component);
		}
		return component;
	}

	public List<Component> getComponents()  {

		loadComponents();
		return components;
	}
	
	
	public Component getComponent(String name){
		loadComponents();
		for(Component c : components){
			if(c.getName().equals(name)){
				return c;
			}
		}
		return null;
	}
	
	
	public JSContainer createInstance(Layout layout, boolean designMode){
		for(ComponentFactory factory : factories){
			if(factory.supports(layout.getComponentName())){
				return factory.createInstance(layout, designMode);
			}
		}
		
		throw new RuntimeException("cannot find componentfactory for component with layoyt:" + layout.getComponentName()) ;
		
		//if(layout.getComponentName())
	}

	@Override
	public boolean supports(String name) {
		return true;
	}

}
