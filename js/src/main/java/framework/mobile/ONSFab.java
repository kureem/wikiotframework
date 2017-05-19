package framework.mobile;


public class ONSFab extends ONSModifiable{


	private boolean ripple;
	
	private boolean disabled;
	
	private String position;
	
	public ONSFab(String name) {
		super(name, "ons-fab");
	}
	
	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		if (disabled) {
			setAttribute("disabled", "true");
		} else {
			setAttribute("disabled", (String) null);
		}
	}

	public boolean isRipple() {
		return ripple;
	}

	public void setRipple(boolean ripple) {
		this.ripple = ripple;
		if(ripple){
			setAttribute("ripple", "true");
		}else{
			setAttribute("ripple", (String)null);
		}
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
		setAttribute("position", position);
	}

	
	

}
