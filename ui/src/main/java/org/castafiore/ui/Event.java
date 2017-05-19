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

import java.io.Serializable;
import java.util.Map;

/**
 * The event model in castafiore
 * It is split Stringo 3 parts due to the fact that in a web application codes can be executed on the browser, and on the server as well
 * 
 * Of course the Success method is executed after a ServerAction
 * 
 *    				request data					requestData
 * ClientAction -----------------> ServerAction-------------------->Success
 * 
 * 
 * 
 * @author Kureem Rossaye<br>
 *          kureem@gmail.com
 * June 27 2008
 */
public interface Event extends Serializable {
	
	/**
	 * event type on blur
	 */
	public final static String BLUR = "blur";
	
	public final static String CHANGE = "change";
	
	public final static String CLICK = "click";
	
	public final static String DOUBLE_CLICK = "dblclick";
	
	public final static String FOCUSS = "focus";
	
	public final static String HELP = "help";
	
	public final static String HOVER = "hover";
	
	public final static String KEY_DOWN = "keydown";
	
	public final static String KEY_PRESS = "keypress";
	
	public final static String KEY_UP = "keyup";
	
	public final static String LOAD = "load";
	
	public final static String MOUSE_DOWN = "mousedown";
	
	public final static String MOUSE_MOVE = "mousemove";
	
	public final static String MOUSE_OUT = "mouseout";
	
	public final static String MOUSE_OVER = "mouseover";
	
	public final static String MOUSE_UP = "mouseup";
	
	public final static String RESET = "reset";
	
	public final static String SELECT = "select";
	
	public final static String SUBMIT = "submit";
	
	public final static String UNLOAD = "unload";
	
	public final static String READY = "ready";
	
	public final static String SCROLL = "scroll";
	
	
	
	
	
	
	/**
	 * This method represents the client part of an event.
	 * This method is executed only once on rendering of the component.
	 * {@link JQuery} provides a nice abstraction for generating javascript codes. It is the browser version of the component
	 * 
	 * It is this method that is responsible in starting a server request to be executed in the serverAction method
	 * 
	 * This allows user to make actions that does not require server actions
	 * 
	 * @param container - A proxy for the browser
	 */
	public void ClientAction(JQuery container);
	
	
	
	/**
	 * executed whenever a serverRequest is made in the clientAction method
	 * {@link JQuery.makeServerRequest}
	 * 
	 * Here the component is the server version of the Component
	 * 
	 * The browser will be update only if this method returns true
	 * This allows users to make server action, that does not require update of the client
	 * 
	 * @param container - the container on which the event was registered
	 * @param request	- request parameters that can be passed in the {@link JQuery.makeServerRequest}
	 * @return			- tells the engine to update the browser or not
	 * @throws UIException
	 */
	public boolean ServerAction(Container container, Map<String, String> request)throws UIException;
	

	/**
	 * This method is executed after each server action
	 * Basically it is the javascript that may be required after a server action
	 * @param container 	- again, this is the browser version of the component on which the event was registered
	 * @param request		- request parameters that can be added in the serverAction method
	 * @throws UIException
	 */
	public void Success(JQuery container,Map<String, String> request)throws UIException;
}
