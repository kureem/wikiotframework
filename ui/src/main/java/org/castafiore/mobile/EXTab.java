package org.castafiore.mobile;

import org.castafiore.ui.EXContainer;

public class EXTab extends EXContainer {

	private String page;// String The page that is displayed when the tab is
						// tapped. Optional. Works only during initialization.
	private String icon;// String The icon name for the tab. Can specify the
						// same icon name as <ons-icon>. If you need to use your
						// own icon, create a CSS class with background-image or
						// any CSS properties and specify the name of your CSS
						// class here.Optional.
	private String activeIcon;// String The name of the icon when the tab is
								// active. Optional.
	private String label;// String The label of the tab item. Optional.
	private String badge;// String Display a notification badge on top of the
							// tab. Optional.
	private String active;//

	public EXTab(String name) {
		super(name, "ons-tab");
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
		setAttribute("page", page);
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
		setAttribute("icon", icon);
	}

	public String getActiveIcon() {
		return activeIcon;
	}

	public void setActiveIcon(String activeIcon) {
		this.activeIcon = activeIcon;
		setAttribute("active-icon", activeIcon);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
		setAttribute("label", label);
	}

	public String getBadge() {
		return badge;
	}

	public void setBadge(String badge) {
		this.badge = badge;
		setAttribute("badge", badge);
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
		setAttribute("active", active);
	}
	
	
	

}
