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

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.castafiore.ui.js.JSVar;
import org.castafiore.utils.JavascriptUtil;
import org.castafiore.utils.StringUtil;
import org.springframework.util.Assert;

/**
 * 
 * @author Kureem Rossaye<br>
 *         kureem@gmail.com June 27 2008
 */
public abstract class EXHtmlTag extends EXComponent implements HTMLTag, Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Map<String, String> attributes_ = new LinkedHashMap<String, String>(0);
	private Map<String, String> styles_ = new LinkedHashMap<String, String>(0);

	protected Set<String> changedStyles_ = new LinkedHashSet<String>(0);

	protected Set<String> changedAttributes_ = new LinkedHashSet<String>(0);

	private String tag_;

	private String text_ = "";

	public EXHtmlTag(String name, String tagName) {
		super(name);
		this.setAttribute("name", name);
		this.tag_ = tagName;
	}

	public abstract void flush(int secretKey);

	public String getAttribute(String name) {
		return StringUtil.getValue(name, this.attributes_);
	}

	public abstract String getHTML();

	public String getStyle(String name) {
		return StringUtil.getValue(name, styles_);
	}

	public String getTag() {
		return tag_;
	}

	public Container setAttribute(String name, JSVar value) {
		Assert.notNull(name, "you cannot pass a name as null to set an attribute");

		// attributes_ = StringUtil.addOrUpdateItem(name, "js::-" + txt,
		// attributes_);
		if (value == null) {

			attributes_.remove(name);
		} else {
			String txt = value.getJavascript();
			attributes_.put(name, "js::-" + txt);
			changedAttributes_.add(name);
		}
		return this;
	}
	
	protected void setBoolean(String attr, boolean b){
		if(b){
			setAttribute(attr, "true");
		}else{
			setAttribute(attr, (String)null);
		}
	}

	public Container setAttribute(String name, String value) {

		Assert.notNull(name, "you cannot pass a name as null to set an attribute");
		// attributes_ = StringUtil.addOrUpdateItem(name, value, attributes_);
		if (value == null) {
			if (attributes_.containsKey(name)) {
				attributes_.remove(name);
				setRendered(false);
			}
		} else {
			String cur = attributes_.get(name);
			if (value.equals(cur)) {

			} else {
				attributes_.put(name, value);
				changedAttributes_.add(name);
			}
		}
		return this;
	}

	public Container setStyle(String name, String value) {
		Assert.notNull(name, "you cannot pass a name as null to set a style");
		if (value == null) {

			styles_.remove(name);
			setRendered(false);
		} else {
			styles_.put(name, value);
			changedStyles_.add(name);
			// styles_ = StringUtil.addOrUpdateItem(name, value, styles_);
		}
		return this;
	}

	public Container setStyle(String name, JSVar var) {
		Assert.notNull(name, "you cannot pass a name as null to set a style");
		if (var == null) {
			styles_.remove(name);
			setRendered(false);
		} else {
			String txt = var.getJavascript();
			// styles_ = StringUtil.addOrUpdateItem(name, "js::-" + txt,
			// styles_);
			styles_.put(name, txt);
			changedStyles_.add(name);
		}
		return this;
	}

	public String[] getAttributeNames() {
		return this.attributes_.keySet().toArray(new String[attributes_.keySet().size()]);
		// return StringUtil.getKeys(attributes_);
	}

	public String[] getStyleNames() {
		return this.styles_.keySet().toArray(new String[styles_.keySet().size()]);
		// return StringUtil.getKeys(styles_);
	}

	public String[] getChangedAttributeNames() {
		return changedAttributes_.toArray(new String[changedAttributes_.size()]);
		// return StringUtil.getChangedKeys(attributes_);

	}

	public String[] getChangedStyleNames() {
		return changedStyles_.toArray(new String[changedStyles_.size()]);
		// return StringUtil.getChangedKeys(styles_);
	}

	public String getText(boolean escape) {
		if (text_ == null) {
			return "";
		}
		if (escape)
			return JavascriptUtil.javaScriptEscape(text_.trim());
		else
			return text_;

	}

	public String getText() {
		return getText(true);
	}

	public Container setText(String text_) {
		this.text_ = text_;
		setRendered(false);
		return this;
	}

}
