package org.wikiot.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/designer")
public class DesignerOperations {
	
	
	@Autowired
	private ComponentService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Component> getComponents()throws Exception{
		return service.getComponents();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Component saveComponent(Component component)throws Exception{
		return service.saveComponents(component);
	}

}
