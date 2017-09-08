package framework.builder.model;

import java.util.LinkedList;
import java.util.List;

public class ComponentFactoryRegistry {

	
	private static ComponentFactoryRegistry INSTANCE = new ComponentFactoryRegistry();
	
	private List<ComponentFactory> factories =new LinkedList<>();
	
	public void registerFactory(ComponentFactory factory){
		factories.add(factory);
	}
	
	public ComponentFactory getFactory(String impl){
		for(ComponentFactory factory : factories){
			if(factory.supports(impl)){
				return factory;
			}
		}
		return null;
	}
	
	public static ComponentFactoryRegistry getInstance(){
		return INSTANCE;
	}
}
