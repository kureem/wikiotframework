package org.wikiot.server;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ComponentService {

	private List<Component> components = null;

	private void loadComponents() throws Exception {
		if (components == null) {
			File f = new File("components.js");
			ObjectMapper mapper = new ObjectMapper();
			components = mapper.readValue(f, List.class);
		}
	}

	public Component saveComponents(Component component)throws Exception{
		if(!components.contains(component)){
			components.add(component);
		}
		return component;
	}

	public List<Component> getComponents() throws Exception {

		loadComponents();
		return components;
	}

}
