package framework.mobile;

import framework.JSContainer;

public class ONSSplitterContent extends JSContainer{

	private String page;
	
	public ONSSplitterContent(String name) {
		super(name, "ons-splitter-content");
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		setAttribute("page", page);
	}
	
	
	
	

}
