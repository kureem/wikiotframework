package framework.mobile;

import framework.JSColor;

public class ONSListItem extends ONSModifiable {

	private boolean lockOnDrag;

	private boolean tappable;

	private JSColor tabBackgroundColor;

	public ONSListItem(String name) {
		super(name, "ons-list-item");
	}

	public boolean isLockOnDrag() {
		return lockOnDrag;
	}

	public void setLockOnDrag(boolean lockOnDrag) {
		this.lockOnDrag = lockOnDrag;
		if (lockOnDrag) {
			setAttribute("lock-on-drag", "true");
		} else {
			setAttribute("lock-on-drag", (String) null);
		}
	}

	public boolean isTappable() {
		return tappable;
	}

	public void setTappable(boolean tappable) {
		this.tappable = tappable;
		if (tappable) {
			setAttribute("tappable", "true");
		} else {
			setAttribute("tappable", (String) null);
		}
	}

	public JSColor getTabBackgroundColor() {
		return tabBackgroundColor;
	}

	public void setTabBackgroundColor(JSColor tabBackgroundColor) {
		this.tabBackgroundColor = tabBackgroundColor;
		if (tabBackgroundColor != null) {
			setAttribute("tab-backgroundcolor",
					"rgba(" + tabBackgroundColor.getRed() + "," + tabBackgroundColor.getGreen() + ","
							+ tabBackgroundColor.getBlue() + "," + tabBackgroundColor.getAlpha() + ")");
		} else {
			setAttribute("tab-backgroundcolor", (String) null);
		}
	}

}
