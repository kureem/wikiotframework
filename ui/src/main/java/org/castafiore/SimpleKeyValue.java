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

package org.castafiore;

/**
 * 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * Oct 22, 2008
 */
public class SimpleKeyValue implements KeyValue,
		Comparable<SimpleKeyValue> {

	private static final long serialVersionUID = -550647585055640132L;

	private String key;

	private String value;

	public SimpleKeyValue() {

	}

	public SimpleKeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	
	@Override
	public boolean equals(Object obj) {
	if(obj instanceof SimpleKeyValue){
		return ((SimpleKeyValue)obj).getKey().equals(key);
	}
		return super.equals(obj);
	}

	public int compareTo(SimpleKeyValue o) {
		return this.key.compareToIgnoreCase(o.getKey());
	}
}
