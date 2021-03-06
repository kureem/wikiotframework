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

package org.castafiore.ui.layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.castafiore.InvalidLayoutDataException;
import org.castafiore.ui.Container;
import org.castafiore.ui.EXContainer;
import org.castafiore.ui.Event;
import org.castafiore.ui.LayoutContainer;
import org.castafiore.ui.UIException;
import org.castafiore.ui.js.JSMap;
import org.castafiore.utils.EventUtil;
import org.castafiore.utils.JavascriptUtil;
import org.castafiore.utils.ResourceUtil;


/**
 * 
 * 
 * @author Kureem Rossaye<br>
 *         kureem@gmail.com Oct 22, 2008
 */
public abstract class EXTemplateComponent extends EXContainer implements TemplateComponent, LayoutContainer {

	private static final long serialVersionUID = 1L;
	private boolean forceStyle = false;
	private String templateLocation = null;

	private String id;

	private String tmpTpl;

	public EXTemplateComponent(String name) {
		super(name, "div");

	}

	public String event(String type) {
		return event(type, null);
	}

	public String event(String type, Map<String, String> params) {
		JSMap map = new JSMap();
		List<Event> evts = getEvents().get(type);
		if (evts == null || evts.size() == 0) {
			throw new UIException("There is no event of type " + type
					+ " configured in component " + getName());
		}
		map.put("casta_applicationid", getRoot().getName());
		map.put("casta_eventid", evts.get(0).hashCode());
		map.put("casta_componentid", getId());

		if (params != null) {
			Iterator<String> keys = params.keySet().iterator();
			while (keys.hasNext()) {
				String key = keys.next();
				String val = params.get(key);
				map.put(key, val);
			}
		}
		String script = map.getJavascript();
		return "sCall(" + script + ")";
	}

	public boolean isForceStyle() {
		return forceStyle;
	}

	public void setForceStyle(boolean forceStyle) {
		this.forceStyle = forceStyle;
	}

	public EXTemplateComponent(String name, String templateLocation) {
		super(name, "div");
		setTemplateLocation(templateLocation);

	}

	private Map<String, Object> context_;

	public Map<String, Object> getContext() {
		if (context_ == null) {
			context_ = new HashMap<String, Object>(1);
			context_.put("component", this);
		}
		return context_;
	}

	public void setContext(Map<String, Object> context) {
		this.context_ = context;
		setRendered(false);

	}

	public void addInContext(String name, Object value) {
		getContext().put(name, value);
		setRendered(false);
	}

	@Override
	public String getId() {

		if (forceStyle) {
			if (id == null) {
				getHTML();
			}
			if (id == null) {
				id = super.getId();
			}

			return id;

		} else {
			return super.getId();
		}

	}

	@Override
	public Compiler getCompiler() {
		return null;
	}

	@Override
	public String getHTML() {
		if (tmpTpl != null) {
			String tt = tmpTpl;
			tmpTpl = null;
			return tt;
		}
		try {
			String html = this.getCompiler().compile(getTemplate(), getContext());
			if (forceStyle) {
			} else {
				html = JavascriptUtil.javaScriptEscape(html);
			}
			return html;
		} catch (Exception e) {
			e.printStackTrace();
			return "<h1>There was an error<h1><p>" + e.getMessage() + "</p>";
			// throw new IllegalStateException(e);
		}
	}

	public String getTemplateLocation() {
		return templateLocation;
	}

	public void setTemplateLocation(String templateLocation) {
		this.templateLocation = templateLocation;
		setRendered(false);
		id = null;
	}

	public String getTemplate() {
		return ResourceUtil.getTemplate(getTemplateLocation(), getRoot());

	}

	public void setTemplate(String xhtml) {
		throw new RuntimeException(
				"template cannot be set in the type of component, please set the template location instead");

	}

	@Override
	public Container setRendered(boolean rendered) {
		if (!rendered && rendered()) {
			id = null;
			tmpTpl = null;
		}
		return super.setRendered(rendered);
	}

	public void addChild(Container child, String layoutData) {

		getContainer(layoutData).addChild(child);
		setRendered(false);
	}

	public Container getChild(String name, String layoutData) {
		return getContainer(layoutData).getChild(name);
	}

	public List<Container> getChildren(String layoutData) {
		return getContainer(layoutData).getChildren();
	}

	public Container getContainer(String layoutData) {
		return this;
	}

	public Container getDescendentById(String id, String layoutData) {
		return getContainer(layoutData).getDescendentById(id);
	}

	public Container getDescendentByName(String name, String layoutData) {
		return getContainer(layoutData).getDescendentByName(name);
	}

	public Container getDescendentOfType(Class<? extends Container> type, String layoutData) {
		return getContainer(layoutData).getDescendentOfType(type);
	}

	public List<DroppableSection> getSections() {
		List<Container> children = getChildren();

		List<DroppableSection> sections = new ArrayList<DroppableSection>();
		for (Container c : children) {
			DroppableSection ds = new DroppableSection(c.getId(), c.getName(), c.getName());
			sections.add(ds);
		}

		return sections;
	}

	public void removeChildFromLayout(String id) {
		getDescendentById(id).remove();

	}

	public void validateLayoutData(String layoutData) throws InvalidLayoutDataException {
		// TODO Auto-generated method stub

	}

}
