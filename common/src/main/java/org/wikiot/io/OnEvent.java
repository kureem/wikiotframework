package org.wikiot.io;

import java.util.LinkedHashMap;
import java.util.Map;


public class OnEvent  {
	
	private String name;
	
	private Map<String, String> params = new LinkedHashMap<String, String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	
	
	

}
