/*
 * Copyright (C) 2007-2008 Castafiore
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 */

package org.castafiore.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.ListOrderedMap;
import org.castafiore.ComponentNotFoundException;
import org.castafiore.Constant;
import org.castafiore.ui.interceptors.Interceptor;
import org.castafiore.ui.interceptors.InterceptorRegistry;
import org.castafiore.ui.js.JSVar;
import org.castafiore.ui.layout.TemplateComponent;
import org.castafiore.ui.panel.EXWarning;
import org.castafiore.utils.ComponentUtil;


/**
 * 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * Oct 22, 2008
 */
public final class CastafioreJSONEngine {
	
	private InterceptorRegistry interceptorRegistry;
	
	
	
	//public static final Log logger = LogFactory.getLog(CastafioreEngine.class);
	 
	public CastafioreJSONEngine(InterceptorRegistry interceptorRegistry) {
		super();
		this.interceptorRegistry = interceptorRegistry;
	}

	public  synchronized void executeInterceptorOnRender(Interceptor interceptor, Container container)
	{
		boolean cont = interceptor.onRender(container);		
		if(cont)
		{
			Interceptor nextInterceptor = interceptor.next();
			if(nextInterceptor != null)
			{
				executeInterceptorOnRender(nextInterceptor, container);
			}
		}
	}
	
	public  synchronized void getJQuery(Container container, String parentId, Container root,  List<Data> result) {
		
		Data data = new Data();
		data.setId(container.getId());
		if(!container.rendered()) {
			
			if(container instanceof FormInput) {
				container.setAttribute("stf", "true");
			}

			
			Interceptor[] interceptors = interceptorRegistry.getInterceptors(container);
			
			for(Interceptor interceptor : interceptors) {
				executeInterceptorOnRender(interceptor, container);
			}
			
			
			/**
			 * first we get previous and next sibbling to guess the best way to append the child
			 */
			
			
			String html = container.getHTML();
			
			
			
			Container[] sibbilings = getPrevAndNextSibblings(container);
			Container nextSibbling = sibbilings[2];
			Container previousSibbling = sibbilings[0];
			
			
			
			 String creationCommand = "";
			/**
			 * we add command to remove the child
			 * 
			 */
			if(!(container.getParent() instanceof TemplateComponent)){
				creationCommand = Constant.NO_CONFLICT + "(\"#"+container.getId()+"\").remove();";
			}
			
			
			
			/**
			 * get the creation command
			 */
			
			
			creationCommand =creationCommand + JQuery.getCreationCommand(container, parentId, html, previousSibbling, nextSibbling);
			
			data.setCreation(creationCommand);
			
		}
		
		/**
		 * we append changed css
		 */
		
		data.setStyles(getMap(container, 0));
		
		/**
		 * we append changed styles
		 */
		data.setAttributes(getMap(container, 1));
			
		
		result.add(data);
		
		
		/**
		 * do the same thing for the children recursively
		 */
		
		if(container.hasChildren()) {
			Iterator<Container> iterChildren = container.getChildren().iterator();
			
			while(iterChildren.hasNext()) {
				Container child = iterChildren.next();
				
				getJQuery(child, container.getId(), root, result);
				
			}
		}
		
		
		if(!container.rendered()){
			
			data.setEvents(executeClientPartOfEvents(container, root));
			
		} 
		
		
		if(!container.rendered()){
			data.setRendered(false);
			JQuery ready = new JQuery(container, new ListOrderedMap());
			container.onReady(ready);
			JEvent evt = new JEvent();
			evt.setBody(ready.getCompleteJQuery());
			evt.setEventName("ready");
			List<String> parameters = new LinkedList<>();
			parameters.add("event");
			evt.setParameters(parameters);
			data.getEvents().add(evt);
			//builder.append(ready.getCompleteJQuery());
		}else{
			data.setRendered(true);
		}
		
		if(!data.isRendered()|| data.getAttributes().size() > 0 || data.getStyles().size() > 0 || data.getEvents().size() > 0 || (data.getCreation() != null && data.getCreation().length() > 0)){
			
		}else{
			result.remove(data);
		}
		
		
		//jQuery.addEvent("ready",ready);
		
		
		//include lazy script load
		
		
		Set<String> requiredScript = container.getResources();
		if(requiredScript != null && requiredScript.size() > 0 && !container.rendered())
		{
			//Container root = component.getRoot();
			if(root instanceof EXApplication)
			{
				((EXApplication)root).mergeResources(requiredScript);
			}
		}
		
		
		
		
		//String script =creationCommand + builder.toString();// getLazyScriptLoad(container, builder, creationCommand);
		
		//return script;
	}
	
	
	/**
	 * executes a server event
	 * @param componentId	- the component on which the event is registered
	 * @param eventType		- the type of event registered  
	 * @param application	- the application in which the component belongs
	 * @param parentId		- the parentId of the component
	 * @param parameters	- the parameters passed as parameter
	 * @return returns the JQuery necessary to make the update
	 */
	@SuppressWarnings("rawtypes")
	public  synchronized void executeServerAction(String componentId,  Application application, String parentId, Map<String, String> parameters, List<Data> result)
	{
		
		//Data data = new Data();
		//data.setId(componentId);
		//data.
		
		List<FormInput> statefullcomponents =  new ArrayList<FormInput>(5);
		List<Container> cCo = new ArrayList<Container>(1);
		ComponentUtil.compcount = 0;
		//logger.debug("extracting components from dom");
		ComponentUtil.fastExtractComponents(application, statefullcomponents, cCo,componentId);
		
		
		//logger.debug("updating stateful components with client values");
		
		int eventId = Integer.parseInt(parameters.get("casta_eventid"));
		for(FormInput component : statefullcomponents)
		{
			boolean toUpdate = parameters.containsKey("casta_value_" + component.getId());
			if(toUpdate)
			{
				String browserValue = parameters.get("casta_value_" + component.getId());
				
				String sessionValue = component.getAttribute("value");
				
				if(browserValue == null && sessionValue == null)
					continue;
				
				if(browserValue!= null && browserValue.equals(sessionValue))
					continue;
					
				component.setAttribute("value",browserValue);
			}
		}
		
		Container component = null;
		if(cCo.size() > 0)
		{
			component = cCo.get(0);
		}
		
		//StringBuilder result = new StringBuilder();
		
		List<Event> events = null;
		Event event = null;
		
		if(component != null)
		{	
			 Map<String, List<Event>> map =  component.getEvents();
			 
			 Iterator<String> types = map.keySet().iterator();
			 while(types.hasNext())
			 {
				 String eType = types.next();
				 events = map.get(eType);
				 if(events != null)
				 {
					 for(Event e : events)
					 {
						 if(e.hashCode() == eventId)
						 {
							 event = e;
							 break;
							 //eventType = eType;
						 }
					 }
				 }
			 }
		}
		else
		{
			//we don't do anything in particular in this case, since Castafiore is for creating extremely rich application.
			//it is likely to have race condition in some extreme cases.
			//it is up to the user of the framework to make necessary correction in program execution
			//logger.warn("the component " + componentId  + " cannot be found in dom. Possibly deleted");
			throw new ComponentNotFoundException("a component could not be found");
			
			
		}
		
		
		
		if(event != null && event.hashCode() == eventId)
		{
			try
			{
				
				//boolean error = false;
				
				//logger.debug("executing events, or rather your business logic");
				boolean updateClient = false;
				try{
					updateClient = event.ServerAction(component, parameters);
				}catch(Throwable uie){
					
					uie.printStackTrace();
					Application root = component.getRoot();
					EXWarning warning = root.getDescendentOfType(EXWarning.class);
					if(warning == null){
					warning = new EXWarning("rootWarning");
						root.addChild(warning);
					}
					warning.setDisplay(true);
					while(uie.getCause() != null)
						uie=uie.getCause();
					
					warning.addMessage("Error: " + uie.getMessage());
					updateClient = true;
				//error = true;
				}
				
				
				
				if(updateClient)
				{
					//logger.debug("action returned true, meaning client should be updated");
					
					//logger.debug("generating jquery");
					//String jQuery = getJQuery(application, parentId, application, new ListOrderedMap());
					//result.append(jQuery);
					getJQuery(application, parentId, application, result);
					
					
					
					
					
					//result.append(Constant.NO_CONFLICT + "(\".castatohide\").css(\"display\", \"none\");\n");
					
				}
				
				JQuery wrapper = new JQuery(component,new ListOrderedMap());
				
				
				//logger.debug("executing success method");
				event.Success(wrapper, parameters);
				
				//result.append(wrapper.getCompleteJQuery());
				
			}
			catch(UIException e)
			{
				/**
				 * @todo UIException should be handled by showing a div, with the stacktrace in it
				 * @todo other exceptions should be thrown to j2ee container since they are most probably technical exception
				 *preferable do something scalable. Probably redirect to some page, show a div or whatever. This will probably depend on the developer
				 *a good idea would be to delegate the handling of the exception on an interface loaded via spring.
				 */
				//logger.error("a ui exception has occured", e);
				//e.printStackTrace();
			}
		}
		
		
		
		
		
		
		//return result.toString();		
	}
	
	
	/**
	 * returns the previous sibbling , current and next sibbling in an array of 3 elements
	 * @param container
	 * @return
	 */
	private  synchronized Container[] getPrevAndNextSibblings(Container container)
	{
		Container[] result = new Container[3];
		
		Container nextSibbling = null;
		
		Container previousSibbling = null;
		
		if(container.getParent() != null)
		{
			List<Container> sibblings = container.getParent().getChildren();
			int i = 0;
			for(i= 0; i <sibblings.size(); i ++)
			{
				if(container.getParent().getChildren().get(i).getId().equals(container.getId()))
				{
					break;
				}
			}
			if(i > 0)
			{
				previousSibbling = sibblings.get(i-0);
			}
			if( i < sibblings.size() - 1)
			{
				nextSibbling = sibblings.get(i + 1);
			}
			

		}
		
		
		result[0] = previousSibbling;
		result[1] = container;
		result[2] = nextSibbling;
		
		return result;
	}
	
	/**
	 * executes only the client part of an event
	 * @param container	- the container that contains the event
	 * @param root		- the root of the application
	 * @param jQuery	
	 */
	public  synchronized List<JEvent> executeClientPartOfEvents(Container container, Container root)
	{
		Map<String, List<Event>> mapEvents = container.getEvents();
		
		Set<String> eventTypes = mapEvents.keySet();
		
		Iterator<String> eventTypesIterator = eventTypes.iterator();
		List<JEvent> result = new LinkedList<JEvent>();
		while(eventTypesIterator.hasNext())
		{
			
			JQuery rootWrapper = new JQuery(root, new ListOrderedMap());
			
			JQuery wrapper = rootWrapper.getDescendentById(container.getId());
			String eventType = eventTypesIterator.next();
			
			//if(eventType < 30)
		//	{
			
				String eventName = eventType;
				
				List<Event> events = mapEvents.get(eventType);
				String clientJS = "";
				for(Event event : events)
				{
					
					if(wrapper != null)
					{
						JQuery clone = wrapper.clone();
						event.ClientAction(clone);
					
						clientJS =  clientJS + clone.getCompleteJQuery();
					
						
					}
				}
				JEvent evt = new JEvent();
				List<String> parameters = new LinkedList<>();
				parameters.add("event");
				evt.setParameters(parameters);
				evt.setBody(clientJS);
				evt.setEventName(eventName);
				result.add(evt);
				//jQuery.on(eventName, clientJS);
			//}
		}
		return result;
	}
	
	
	
	private   Map<String,String> getMap(Container tag, int type)
	{
		Map<String,String> result = new HashMap<String,String>();
		if(type == 0)
		{
			if(tag.rendered())
			{
				for(String key : tag.getChangedStyleNames())
				{
					String val = tag.getStyle(key);
					if(val != null && val.startsWith("js::-")){
						val = val.replace("js::-", "");
						result.put(key, "eval('"+new JSVar(val).getJavascript()+"')");
					}else if(val != null && val.trim().length() > 0){
						result.put(key, val);
					}
				}
			}
			else
			{
				for(String key : tag.getStyleNames())
				{
					String val = tag.getStyle(key);
					if(val != null && val.startsWith("js::-")){
						val = val.replace("js::-", "");
						result.put(key, "eval('"+new JSVar(val).getJavascript()+"')");
					}else if(val != null && val.trim().length() > 0){
						result.put(key,val);
					}
				}
			}
		}
		else
		{
			if(tag.rendered())
			{
				for(String key : tag.getChangedAttributeNames())
				{
					
					String val = tag.getAttribute(key);
					if(val != null && val.startsWith("js::-")){
						val = val.replace("js::-", "");
						result.put(key, "eval('"+new JSVar(val).getJavascript()+"')");
					}else if(val != null && val.trim().length() > 0){
						result.put(key,val);
					}
					
					//String attr = tag.getAttribute(key);
					//result.put(key, attr);
				}
			}
			else
			{
				for(String key : tag.getAttributeNames())
				{
					
					String val = tag.getAttribute(key);
					if(val != null && val.startsWith("js::-")){
						val = val.replace("js::-", "");
						result.put(key, "eval('"+new JSVar(val).getJavascript()+"')");
					}else if(val != null && val.trim().length() > 0){
						result.put(key,val);
					}
				}
			}
		}		
		return result;
	}

}
