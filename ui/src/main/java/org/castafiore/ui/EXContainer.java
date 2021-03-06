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

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.castafiore.utils.StringUtil;
import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnore;

/** 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * June 27 2008
 */
public class EXContainer extends EXDynamicHTMLTag implements Container {
	
	

	private static final long serialVersionUID = 8510467682895944117L;
	
	

	//private Map<String, String> readonlyAttributes_ = new LinkedHashMap<String, String>(0);
	
	private String[][] readonlyAttributes_;
	

	
	private Set<String> resources =null;
	
	//private List<Container> children_  = Collections.synchronizedList( new LinkedList<Container>());
	private List<Container> children_  =  new LinkedList<Container>();
	
	

	public EXContainer(String name, String tagName) {
		super(name, tagName);
	}
	
	public Container addScript(String script)
	{
		Assert.notNull(script, "cannot add a null script");
		if(resources == null)
		{
			resources = new LinkedHashSet<String>(0);
		}
		resources.add(script);
		return this;
	}
	
	public Set<String> getResources() {
		return resources;
	}
	
	@JsonIgnore
	@SuppressWarnings("unchecked")
	public <T extends Application> T getRoot()
	{
		return (T)CastafioreApplicationContextHolder.getCurrentApplication();
	}
	
	
	public Container addClass(String styleClass)
	{
		Assert.notNull(styleClass, "cannot add a not style class");
		String styles = getAttribute("class");
		String[] aStyles = StringUtil.split(styles, " ");
		
		boolean add = true;
		for(String style : aStyles)
		{
			if(style.trim().equals(styleClass))
			{
				add = false;
			}
		}
		if(add)
			setAttribute("class", styles.trim() + " "  + styleClass);
		
		return this;
	}
	
	
	
	public Container getChildByIndex(int index)
	{
		return this.children_.get(index);
	}
	
	public EXContainer getRoot(EXContainer child)
	{
		if(child.getParent() == null)
		{
			return child;
		}
		else
		{
			return getRoot((EXContainer)child.getParent());
		}
	}
	
	
	public void refresh()
	{
		
		
	}

	@Override
	public String getHTML() {
		
		String readonlyAttributes = StringUtil.buildattributesFromMap(this.readonlyAttributes_);
		
		/*id="sdfsd"*/
		return "<" + getTag()+" "+readonlyAttributes+">"+getText()+"</"+getTag()+">";
	}

	public Container getChild(String name) {
		Assert.notNull(name, "cannot get a child with name null");
		for(Container component : children_)
		{
			if(component.getName().equalsIgnoreCase(name))
			{
				return component;
			}
		} 
		
		return null;
	}

	public List<Container> getChildren() 
	{
		return children_;
		
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Container> T getDescendentOfType(Class<T> type)
	{
		Assert.notNull(type, "cannot search a descendent with type null");
		if(type.isAssignableFrom(getClass()))
		{
			return (T)this;
		}
		else
		{
			for(Container child : this.getChildren())
			{
				T c = child.getDescendentOfType(type);
				if(c != null)
				{
					return c;
				}
			}
		}
		
		return null;
	}

	public Container getDescendentById(String id)
	{
		Assert.notNull(id, "cannot search a descendent with id null");
		if(id.equals(getId()))
		{
			return this;
		}
		else
		{
			for(Container child : this.getChildren())
			{
				Container c = child.getDescendentById(id);
				if(c != null)
				{
					return c;
				}
			}
		}
		return null;
	}
	
	public Container getDescendentByName(String name)
	{
		Assert.notNull(name, "cannot search a descendent with name null");
		if(name.equals(getName()))
		{
			return this;
		}
		else
		{
			for(Container child : this.getChildren())
			{
				Container c = child.getDescendentByName(name);
				if(c != null)
				{
					return c;
				}
			}
		}
		
		return null;
	}
	
	public Container setStyleClass(String styleClass)
	{
		Assert.notNull(styleClass, "cannot set a styleclass null");
		this.setAttribute("class", styleClass);
		return this;
	}
	
	public String getStyleClass()
	{
		return this.getAttribute("class");
	}
	
	public boolean isValidChild(Container child) 
	{
		return true;
	}

	public Container removeChild(String name) 
	{
		Assert.notNull(name, "cannot remove a child with name null");
		for(Container component : children_)
		{
			if(component.getName().equalsIgnoreCase(name))
			{
				children_.remove(component);
				component.remove();
				break;
			}
		}
		return this;
	}

	public Container addChild(Container component) 
	{
		Assert.notNull(component, "cannot add a component that is null");
		if(isValidChild(component))
		{
		
			this.children_.add(component);
		
			component.setParent(this);
		}
		else
		{
			throw new UIException("the component " + component.getClass().getName() + " cannot be added to the component " + this.getClass().getName());
		}
		return this;
	}
	
	@Override
	public boolean hasChildren()
	{
		if(children_ != null)
		{
			if(children_.size() > 0)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public String[][] getReadonlyAttributes()
	{
		return this.readonlyAttributes_;
	}

	@Override
	public void flush(int secretKey) {
		super.flush( secretKey);
		
		for(Container child : children_)
		{
			child.flush(secretKey);
		}
	}
	
	
	
	public boolean hasEvent(Class<?> event,int type)
	{
		Assert.notNull(event, "cannot search an event to type null");
		List<Event> events = this.getEvents().get(type);
		if(events != null)
		{
			for(Event evt : events)
			{
				if(evt.getClass().isAssignableFrom(event))
				{
					return true;
				}
			}
		}	
		return false;
	}
	
	public void removeEvent(Class<?> event, int type)
	{
		Assert.notNull(event, "cannot remove an event to type null");
		List<Event> events = this.getEvents().get(type);
		if(events != null)
		{
			for(Event evt : events)
			{
				if(evt.getClass().isAssignableFrom(event))
				{
					events.remove(evt);
					break;
				}
			}
		}
		
		this.setRendered(false);
	}
	
	



	
	public Container setDisplay(boolean display)
	{
		if(display)
		{
			if(getTag().equalsIgnoreCase("table"))
				this.setStyle("display", "table");
			else
				this.setStyle("display", "block");
		}
		else
		{
			this.setStyle("display", "none");
		}
		return this;
	}

	public Container addStyleSheet(String stylesheeturl) {
		Assert.notNull(stylesheeturl, "cannot add a stylesheet that is null");
		//logger.debug("adding stylesheet " + stylesheeturl);
		if(resources == null)
		{
			resources = new LinkedHashSet<String>();
		}
		resources.add(stylesheeturl);	
		return this;
	}

	

	public Container addChildAt(Container component, int position) {
		Assert.notNull(component, "cannot add a component that is null");
		if(isValidChild(component))
		{
		
			this.children_.add(position,component);
		
			component.setParent(this);
		}
		else
		{
			throw new UIException("the component " + component.getClass().getName() + " cannot be added to the component " + this.getClass().getName());
		}
		return this;
		
	}
	
	public Container removeClass(String sclass)
	{
		Assert.notNull(sclass, "cannot remove a class null");
		String cls = getAttribute("class");
		String[] asClas = StringUtil.split(cls, " ");
		StringBuilder newClass = new StringBuilder();
		for(String s : asClas)
		{
			if(!s.trim().equalsIgnoreCase(sclass))
			{
				newClass.append(s).append(" ");
			}
		}
		setStyleClass(newClass.toString().trim());
		return this;
		
	}

	public void onReady(JQuery proxy) {
		
	}
	
	public void setReadOnlyAttribute(String key, String value){
		readonlyAttributes_ = StringUtil.addOrUpdateItem(key, value, readonlyAttributes_);
	}

	public boolean isVisible() {
		String display = getStyle("display");
		
		if(StringUtil.isNotEmpty(display) && display.equals("none")){
			return false;
		}else{
			return true;
		}
		//return !"none".equals(getStyle("display"));
	}
}
