package framework.portal;

import java.util.Map;

import framework.Renderable;

public interface Designable extends Renderable {
	
	public void setParameters(Map<String,String> parameters);

}
