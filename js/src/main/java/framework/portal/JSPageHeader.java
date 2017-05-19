package framework.portal;

import framework.JSContainer;
import framework.services.Node;

public class JSPageHeader extends JSContainer {

	private JSContainer headerContent = new JSContainer("div");

	private JSContainer pageTitle = new JSContainer("div");

	private JSNavBar toolbar = new JSNavBar("toolbar");

	public JSPageHeader(String name) {
		super(name, "div");
		addClass("page-header page-header-default no-margin");

		addChild(headerContent);
		pageTitle.addClass("page-title").addClass("no-padding");
		headerContent.addChild(pageTitle);
		headerContent.addChild(toolbar);
		toolbar.addClass("navbar-xs");

	}

	public JSPageHeader hideTitle(boolean b) {
		pageTitle.setVisible(!b);
		return this;
	}

	public void setTitle(String title) {
		JSButton button = new JSButton("title");
		button.setTag("h4");
		button.setText(title);
		pageTitle.addChild(button);
	}

	public void setNode(Node node) {
		JSButton button = new JSButton(node.getName());
		button.setTag("h4");
		button.setText(node.getLabel());
		button.setIcon(node.getIcon());
		pageTitle.addChild(button);
	}

	public JSPageHeader addButtonItem(JSButton btn) {
		toolbar.addButtonItem(btn);
		return this;
	}

}
