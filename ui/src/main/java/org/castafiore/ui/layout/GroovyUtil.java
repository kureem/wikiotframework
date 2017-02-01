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

import groovy.text.SimpleTemplateEngine;
import groovy.text.Template;
import groovy.text.TemplateEngine;
/**
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * Oct 22, 2008
 */
public class GroovyUtil {
	
	private static SimpleTemplateEngine engine = null;
	
	
	private GroovyUtil()
	{
		
	}
	
	
	public static TemplateEngine getGroovyEngine()
	{
		if(engine == null)
		{
			engine = new SimpleTemplateEngine();
		}
		
		return engine;
	}

	public static Template getGroovyTemplate(String template)throws Exception
	{
		return getGroovyEngine().createTemplate(template);
	}
	
	
}
