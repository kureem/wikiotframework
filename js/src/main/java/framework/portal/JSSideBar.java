package framework.portal;

import framework.JSContainer;

public class JSSideBar extends JSContainer {

	private JSContainer content = new JSContainer("div").addClass("sidebar-content");


	public JSSideBar(String name) {
		super(name, "div");
		addClass("sidebar");
		addChild(content);

	}

	public JSSideBar addWidget(JSSideBarWidget widget) {
		content.addChild(widget);
		return this;
	}

}
