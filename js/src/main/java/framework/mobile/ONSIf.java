package framework.mobile;

import framework.JSContainer;

public class ONSIf extends JSContainer{

	private String platform;
	
	private String orientation;
	
	public ONSIf(String name) {
		super(name, "ons-if");
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
		setAttribute("platform", platform);
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
		setAttribute("orientation", orientation);
	}
	
	
	

}
