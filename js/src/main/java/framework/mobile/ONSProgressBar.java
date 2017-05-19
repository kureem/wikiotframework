package framework.mobile;


public class ONSProgressBar extends ONSModifiable {

	
	private Integer value;
	
	private Integer secondaryValue;
	
	private boolean indeterminate;
	
	protected ONSProgressBar(String name, String tagName) {
		super(name, tagName);
	}
	
	public ONSProgressBar(String name) {
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
