package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXSplitterContent extends EXContainer{

	private String page;
	
	public EXSplitterContent(String name) {
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
