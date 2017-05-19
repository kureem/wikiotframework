package framework.portal;

import framework.JSContainer;

public class JSDropdownMenu extends JSContainer {

	public JSDropdownMenu(String name) {
		super(name, "ul");
		addClass("dropdown-menu");
	}

	public void setRight(boolean b) {
		if (b) {
			addClass("dropdown-menu-right");
		} else {
			removeClass(" dropdown-menu-right");
		}
	}

	public JSDropdownMenu addButton(JSButton button) {

		JSContainer li = new JSContainer("", "li");

		li.addChild(button);

		addChild(li);
		
		button.removeClass("btn");
		
		return this;

	}

	public JSDropdownMenu setActive(int index, boolean active) {
		if (active)
			getChildren().get(index).addClass("active");
		else
			getChildren().get(index).removeClass("active");

		return this;
	}

	public JSDropdownMenu setEnabled(int index, boolean enable) {
		if (enable)
			getChildren().get(index).removeClass("disabled");
		else
			getChildren().get(index).addClass("disabled");

		return this;
	}

	public JSDropdownMenu addDivider() {
		JSContainer li = new JSContainer("", "li");
		li.addClass("divider");
		addChild(li);
		return this;
	}

	public JSDropdownMenu addHeader(String title) {
		JSContainer li = new JSContainer("", "li");

		li.addClass("dropdown-header").setHtml(title);

		addChild(li);

		return this;
	}

}
