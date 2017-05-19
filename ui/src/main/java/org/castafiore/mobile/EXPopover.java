package org.castafiore.mobile;

public class EXPopover extends EXDialog{
	
	private String direction;

	public EXPopover(String name) {
		super(name, "ons-popover");
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
		setAttribute("direction", direction);
	}

	
	
	
}
