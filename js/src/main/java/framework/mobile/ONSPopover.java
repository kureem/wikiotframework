package framework.mobile;


public class ONSPopover extends ONSDialog{
	
	private String direction;

	public ONSPopover(String name) {
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
