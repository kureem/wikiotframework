package framework.mobile;


public class ONSButton extends ONSModifiable{

	private String ripple;
	
	private boolean disabled;
	
	public ONSButton(String name) {
		super(name, "ons-button");
		// TODO Auto-generated constructor stub
	}

	public String getRipple() {
		return ripple;
	}

	public void setRipple(String ripple) {
		this.ripple = ripple;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		if(!disabled)
			setAttribute("disabled", (String)null);
		else
			setAttribute("disabled", "true");
	}
	
	
	
	

}
