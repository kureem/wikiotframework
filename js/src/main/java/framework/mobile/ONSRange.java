package framework.mobile;

import framework.JSContainer;

public class ONSRange extends JSContainer {
	
	private boolean disabled;

	private String value;

	public ONSRange(String name) {
		super(name, "ons-range");
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
		if (!disabled)
			setAttribute("disabled", (String) null);
		else
			setAttribute("disabled", "true");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		setAttribute("value", value);
		this.value = value;
		
	}

	
}
