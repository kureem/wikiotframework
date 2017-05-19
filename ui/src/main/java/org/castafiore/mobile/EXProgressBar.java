package org.castafiore.mobile;

public class EXProgressBar extends EXModifiable {

	
	private Integer value;
	
	private Integer secondaryValue;
	
	private boolean indeterminate;
	
	protected EXProgressBar(String name, String tagName) {
		super(name, tagName);
	}
	
	public EXProgressBar(String name) {
		super(name, "ons-progress-bar");
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
		setAttribute("value", value.toString());
	}

	public Integer getSecondaryValue() {
		return secondaryValue;
	}

	public void setSecondaryValue(Integer secondaryValue) {
		this.secondaryValue = secondaryValue;
		setAttribute("secondary-value", secondaryValue.toString());
	}

	public boolean isIndeterminate() {
		return indeterminate;
	}

	public void setIndeterminate(boolean indeterminate) {
		this.indeterminate = indeterminate;
		if(indeterminate){
			setAttribute("indeterminate", "true");
		}else{
			setAttribute("indeterminate", (String)null);
		}
	}
	
	
	

}
