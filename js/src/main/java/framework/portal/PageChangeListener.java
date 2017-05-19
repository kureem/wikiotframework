package framework.portal;

import java.util.Map;

import framework.services.Node;

public interface PageChangeListener {

	public void beforeChange(Node currentPage, Node nextPage, Map<String,String> data);
	
	public void onChange(Node currentPage, Node nextPage, Map<String,String> data);
	
	public void afterChange(Node currentPage, Node nextPage, Map<String,String> data);

	
}
